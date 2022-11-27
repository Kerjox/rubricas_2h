using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial
{
    public partial class Form_08_Personas : System.Web.UI.Page {

        protected void Page_Load(object sender, EventArgs e) {

            string query = "SELECT * FROM personas";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlCommand cmd = new SqlCommand(query, conn);

                DataTable dt = new DataTable();

                dt.Columns.Add(new DataColumn("DNI"));
                dt.Columns.Add(new DataColumn("Nombre"));
                dt.Columns.Add(new DataColumn("Provincia"));
                dt.Columns.Add(new DataColumn("Fecha Nacimiento"));
                dt.Columns.Add(new DataColumn("Mayor de edad"));

                conn.Open();

                SqlDataReader dataReader = cmd.ExecuteReader();

                while (dataReader.Read()) {

                    DataRow row = dt.NewRow();
                    dt.Rows.Add(row);

                    row["DNI"] = dataReader["dni"];
                    row["Nombre"] = dataReader["nombre"];
                    row["Provincia"] = dataReader["provincia"];
                    row["Fecha Nacimiento"] = ((DateTime) dataReader["date"]).ToShortDateString();
                    row["Mayor de edad"] = isLegalAge((DateTime) dataReader["date"]) ? "Sí" : "No";

                }

                conn.Close();

                gvPersonas.DataSource = dt;
                gvPersonas.DataBind();

            }

            
        }

        private bool isLegalAge(DateTime date) {

            return (DateTime.Now - date).TotalDays > 18 * 365;
        }

        protected void gvPersonas_RowDataBound(object sender, GridViewRowEventArgs e) {

            if (e.Row.Cells[4].Text == "No") {

                e.Row.Cells[4].ForeColor = System.Drawing.Color.Red;
            }
        }
    }
}
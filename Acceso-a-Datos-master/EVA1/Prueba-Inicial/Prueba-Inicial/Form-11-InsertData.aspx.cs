using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial {
    public partial class Form_11_InsertData : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

        }

        protected void Button1_Click(object sender, EventArgs e) {

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlDataAdapter da = new SqlDataAdapter((string) ViewState["query"], conn);

                DataSet ds = new DataSet();
                ds.ReadXml(Server.MapPath("~/Datos/datos3.xml"));

                DataTable dtProvincias = ds.Tables["Provincia"];
                DataTable dtPersonas = ds.Tables["Persona"];

                conn.Open();

                using (SqlBulkCopy bc = new SqlBulkCopy(conn)) {

                    bc.DestinationTableName = "personas";
                    bc.ColumnMappings.Add("dni", "dni");
                    bc.ColumnMappings.Add("nombre", "nombre");
                    bc.ColumnMappings.Add("provincia", "provincia");
                    bc.WriteToServer(dtPersonas);
                }

                using (SqlBulkCopy bc = new SqlBulkCopy(conn)) {

                    bc.DestinationTableName = "provincias";
                    bc.ColumnMappings.Add("id", "id_provincia");
                    bc.ColumnMappings.Add("nombre", "nombre");
                    bc.WriteToServer(dtProvincias);
                }
            }

        }
        /*
        private void updateUser() {

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlDataAdapter da = new SqlDataAdapter((string) ViewState["query"], conn);

                SqlCommandBuilder builder = new SqlCommandBuilder(da);

                DataSet ds = (DataSet) ViewState["dataSet"];

                if (ds.Tables["person"].Rows.Count > 0) {

                    DataRow dr = ds.Tables["person"].Rows[0];

                    dr["dni"] = dni.Text;
                    dr["nombre"] = name.Text;
                    dr["provincia"] = country.Text;
                    dr["date"] = date.Text;
                }

                if (da.Update(ds, "person") > 0) {

                    msg.ForeColor = System.Drawing.Color.Green;
                    msg.Text = "Update Done";
                } else {

                    msg.Text = "No updates Required";
                }
            }
        }*/

    }
}
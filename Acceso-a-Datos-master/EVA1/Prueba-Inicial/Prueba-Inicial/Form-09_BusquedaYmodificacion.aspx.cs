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
    public partial class Form_09 : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {


        }

        protected void searchButton_Click(object sender, EventArgs e) {

            Array personData = null;

            try {

                personData = getDataFromId(int.Parse(personTextBox.Text));
            } catch (SystemException) {

                
            }

            if (personData != null) {

                setValuesForm(personData);

                msg.ForeColor = System.Drawing.Color.Black;
                msg.Text = "OK";
            } else {

                msg.ForeColor = System.Drawing.Color.Red;
                msg.Text = "Not found";

                setValuesForm(null);
            }
        }

        protected void updateButton_Click(object sender, EventArgs e) {

            updateUser();
        }

        private Array getDataFromId(int id) {

            string query = "SELECT * FROM personas WHERE id_persona=" + id;

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlDataAdapter da = new SqlDataAdapter(query, conn);

                DataSet ds = new DataSet();

                da.Fill(ds, "person");      //"person" es el nombre de la tabla

                ViewState["query"] = query;
                ViewState["dataSet"] = ds;

                if (ds.Tables["person"].Rows.Count > 0) {

                    return ds.Tables["person"].Rows[0].ItemArray;


                } else {

                    return null;
                }
            }
        }

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
        }
        private void setValuesForm(Array a) {

            if (a != null) {

                dni.Text = a.GetValue(1).ToString();
                name.Text = a.GetValue(2).ToString();
                country.Text = a.GetValue(3).ToString();
                date.Text = ((DateTime) a.GetValue(4)).ToShortDateString();
            } else {

                dni.Text = "";
                name.Text = "";
                country.Text = "";
                date.Text = "";
            }
        }
    }
}
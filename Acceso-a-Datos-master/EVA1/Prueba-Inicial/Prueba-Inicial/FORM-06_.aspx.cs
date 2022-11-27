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
    public partial class FORM_06_ : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                loadDropDownTablas();
            }
            

        }

        private void loadDropDownTablas()
        {

            DropDownTables.DataValueField = "TABLE_NAME";
            DropDownTables.DataTextField = "TABLE_NAME";
            DropDownTables.DataSource = getTables();
            DropDownTables.DataBind();

            ListItem firstItem = new ListItem("Selecciona tabla", "-1");
            firstItem.Selected = true;
            DropDownTables.Items.Insert(0, firstItem);
        }

        private DataTable getTables()
        {

            string query = "getTables";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            SqlConnection conn = new SqlConnection(conectionString);
            SqlDataAdapter data = new SqlDataAdapter(query, conn);
            
            DataTable output = new DataTable();
            
            data.Fill(output);

            return output;
        }

        private DataTable getMetaDataFromTable(string tableName)
        {

            string query = "getMetaDatos";
            //string query = "EXEC getMetaDatos personas;";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            SqlConnection conn = new SqlConnection(conectionString);
            SqlDataAdapter data = new SqlDataAdapter(query, conn);
            data.SelectCommand.CommandType = CommandType.StoredProcedure;
            data.SelectCommand.Parameters.Add(new SqlParameter("@tableName", tableName));

            DataTable output = new DataTable();

            data.Fill(output);

            return output;

        }

        protected void DropDownTables_SelectedIndexChanged(object sender, EventArgs e)
        {

            string table = DropDownTables.SelectedValue.ToString();

            if (table != "-1")
            {
                GridView1.DataSource = getMetaDataFromTable(table);

                GridView1.DataBind();
            }
        }
    }
}
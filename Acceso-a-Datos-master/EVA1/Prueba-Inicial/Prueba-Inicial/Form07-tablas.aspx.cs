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
    public partial class Form07_tablas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            setTables();
        }

        private void setTables()
        {

            string query = "getProvinciasPlusPersonas";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            SqlConnection conn = new SqlConnection(conectionString);
            SqlDataAdapter data = new SqlDataAdapter(query, conn);

            DataSet ds = new DataSet();

            data.Fill(ds);

            List<DataTable> tables = new List<DataTable>();

            foreach (DataTable table in ds.Tables)
            {
                tables.Add(table);
            }

            if (tables.Count != 0)
            {
                tables[0].TableName = "Perosnas";
                tables[1].TableName = "Provincias";
                tables[2].TableName = "Inner Join";

                gvPersonas.DataSource = tables[0];
                gvPersonas.DataBind();

                gvProvincias.DataSource = tables[1];
                gvProvincias.DataBind();

                gvInnerJoin.DataSource = tables[2];
                gvInnerJoin.DataBind();

            }
            

            

        }
    }
}
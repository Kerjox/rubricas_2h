using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Configuration;     // Accede al web.config
using System.Data;
using System.Data.SqlClient;


namespace Prueba_Inicial
{
	public partial class Form_05_SQL : System.Web.UI.Page
	{
		protected void Page_Load(object sender, EventArgs e)
		{
			string query = "SELECT p.nombre, pro.nombre FROM personas p INNER JOIN provincias pro ON p.provincia = pro.id_provincia;";

			string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;

			using (SqlConnection conn = new SqlConnection(conectionString)) {

				SqlDataAdapter data = new SqlDataAdapter(query, conn);
				DataSet ds = new DataSet();
				data.Fill(ds);
				listado.DataSource = ds;
				listado.DataBind();
			}
			
		}
	}
}
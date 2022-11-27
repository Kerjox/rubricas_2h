using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial {
    public partial class Form_10_XML : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {


            DataSet ds = new DataSet();
            ds.ReadXml(Server.MapPath("~/Datos/Datos2.xml"));
            GridView3.DataSource = ds;
            GridView3.DataBind();
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EF3 {
    public partial class Entity3 : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

        }

        protected void DetailsView1_ItemInserted(object sender, DetailsViewInsertedEventArgs e) {

            GridView1.DataBind();
        }
    }
}
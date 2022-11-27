using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial {
    public partial class Form_12_InsertSexo : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

        }

        protected void insertButton_Click(object sender, EventArgs e) {

            SqlDataSource1.InsertParameters["dni"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("dni")).Text;
            SqlDataSource1.InsertParameters["nombre"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("nombre")).Text;
            SqlDataSource1.InsertParameters["sexo"].DefaultValue = ((DropDownList) GridView1.FooterRow.FindControl("sexo")).SelectedValue;

            SqlDataSource1.Insert();
        }
    }
}
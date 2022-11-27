using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial {
    public partial class Form_13_InsertDeleteEdit : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

        }

        protected void insertButton_Click(object sender, EventArgs e) {

            ObjectDataSource1.InsertParameters["dni"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("dni")).Text;
            ObjectDataSource1.InsertParameters["nombre"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("nombre")).Text;
            ObjectDataSource1.InsertParameters["provincia"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("provincia")).Text;
            ObjectDataSource1.InsertParameters["date"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("date")).Text;
            ObjectDataSource1.InsertParameters["sexo"].DefaultValue = ((DropDownList) GridView1.FooterRow.FindControl("sexo")).SelectedValue;

            ObjectDataSource1.Insert();

        }
    }
}
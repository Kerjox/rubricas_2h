using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial {
    public partial class Pruebas : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

        }

        protected void insertButton_Click(object sender, EventArgs e) {

            ObjectDataSource1.InsertParameters["Dni"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("DNI_TextBox")).Text;
            ObjectDataSource1.InsertParameters["Nombre"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("Nombre_TextBox")).Text;
            ObjectDataSource1.InsertParameters["Provincia"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("Provicia_TextBox")).Text;
            ObjectDataSource1.InsertParameters["Date"].DefaultValue = ((TextBox) GridView1.FooterRow.FindControl("Date_TextBox")).Text;
            ObjectDataSource1.InsertParameters["Sexo"].DefaultValue = ((DropDownList) GridView1.FooterRow.FindControl("Seso_DropDown")).SelectedValue;

            ObjectDataSource1.Insert();
        }
    }
}
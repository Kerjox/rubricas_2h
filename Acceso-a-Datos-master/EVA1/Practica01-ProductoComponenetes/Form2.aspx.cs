using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practica01_ProductoComponenetes {
    public partial class Form2 : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            if (IsPostBack) {
                return;
            }

            TiendaDbConnection conn = new TiendaDbConnection();

            List<Producto> productos = conn.Productos.ToList();

            DropDownList1.Items.Add(new ListItem("---", "-1"));

            foreach (Producto p in productos) {

                DropDownList1.Items.Add(new ListItem(p.Nombre, p.ID.ToString()));
            }
        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e) {

            TiendaDbConnection conn = new TiendaDbConnection();

            int selectedProductId = DropDownList1.SelectedIndex;

            if (selectedProductId != -1) {

                GridView1.DataSource = conn.Productos.Include("Componentes").FirstOrDefault(p => p.ID == selectedProductId).Componentes.ToList();
                GridView1.DataBind();
            }

        }
    }
}
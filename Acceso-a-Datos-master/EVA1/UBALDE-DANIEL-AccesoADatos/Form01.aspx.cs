using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace UBALDE_DANIEL_AccesoADatos {
    public partial class Form01 : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            if (!IsPostBack) {

                loadDropDowns();
            }
        }

        private void loadDropDowns() {

            ComponentesConnection conn = new ComponentesConnection();

            List<ProductosPropios> productosPropios = conn.ProductosPropios.ToList();

            ProductosDropDownList.Items.Add(new ListItem("---", "-1"));

            foreach (ProductosPropios p in productosPropios) {

                ProductosDropDownList.Items.Add(new ListItem(p.Nombre, p.ID.ToString()));
            }


            List<Componente> componentes = conn.Componentes.ToList();

            ComponentesDropDownList.Items.Add(new ListItem("---", "-1"));

            foreach (Componente c in componentes) {

                ComponentesDropDownList.Items.Add(new ListItem(c.Nombre, c.ID.ToString()));
            }
        }

        protected void InsertarComponenteAProducto_Click(object sender, EventArgs e) {

            ComponentesConnection conn = new ComponentesConnection();

            int productoSelectedId = Convert.ToInt32(ProductosDropDownList.SelectedValue);
            int componeneteSelectedId = Convert.ToInt32(ComponentesDropDownList.SelectedValue);

            ProductosPropios productoSelected = conn.ProductosPropios.Include("Componentes").FirstOrDefault(p => p.ID == productoSelectedId);
            Componente componeneteSelected = conn.Componentes.Find(componeneteSelectedId);

            productoSelected.Componentes.Add(componeneteSelected);

            conn.SaveChanges();
            Response.Redirect(Request.RawUrl);
        }

        protected void BorrarComponenteDeProducto_Click(object sender, EventArgs e) {

            ComponentesConnection conn = new ComponentesConnection();

            int productoSelectedId = Convert.ToInt32(ProductosDropDownList.SelectedValue);
            int componeneteSelectedId = Convert.ToInt32(ComponentesDropDownList.SelectedValue);

            ProductosPropios productoSelected = conn.ProductosPropios.Include("Componentes").FirstOrDefault(p => p.ID == productoSelectedId);
            Componente componeneteSelected = conn.Componentes.Find(componeneteSelectedId);

            productoSelected.Componentes.Remove(componeneteSelected);

            conn.SaveChanges();
            Response.Redirect(Request.RawUrl);
        }
    }
}
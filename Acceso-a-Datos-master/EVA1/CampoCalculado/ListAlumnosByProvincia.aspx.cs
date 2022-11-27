using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CampoCalculado {
    public partial class ListAlumnosByProvincia : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            if (!IsPostBack) {

                loadDropDownProvincias();
            }
        }

        private void loadDropDownProvincias() {

            UniversidadDBConnection conn = new UniversidadDBConnection();

            List<Provincia> provincias = conn.Provincias.ToList();

            ProvinciasDD.Items.Add(new ListItem("---", "-1"));

            foreach (Provincia provincia in provincias) {

                ListItem p = new ListItem(provincia.Nombre, provincia.ID.ToString());
                ProvinciasDD.Items.Add(p);
            }
                
        }

        protected void ProvinciasDD_SelectedIndexChanged(object sender, EventArgs e) {

            int provinciaSelected = int.Parse(ProvinciasDD.SelectedValue);

            if (provinciaSelected == -1) {

                return;
            }

            UniversidadDBConnection conn = new UniversidadDBConnection();


            GridView1.DataSource = conn.Provincias.Include("Alumnos").FirstOrDefault(p => p.ID == provinciaSelected).Alumnos.ToList();
            GridView1.DataBind();
        }
    }
}
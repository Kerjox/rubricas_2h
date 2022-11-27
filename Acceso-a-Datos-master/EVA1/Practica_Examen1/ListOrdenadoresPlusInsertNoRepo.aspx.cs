using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practica_Examen1 {
    public partial class ListOrdenadores : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            if (!IsPostBack) {

                LoadGridView();
            }
        }

        private void LoadGridView() {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            GridView1.DataSource = conn.Ordenadores.ToList();
            GridView1.DataBind();
        }

        protected void insertButton_Click(object sender, EventArgs e) {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            Ordenador ordenador = new Ordenador();

            ordenador.Marca = ((TextBox) GridView1.FooterRow.FindControl("marca")).Text;
            ordenador.Modelo = ((TextBox) GridView1.FooterRow.FindControl("modelo")).Text;

            conn.Ordenadores.Add(ordenador);

            conn.SaveChanges();
        }
    }
}
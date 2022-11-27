using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Practica_Examen1 {
    public partial class AgregarOrdenadorAPersona : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            loadGridView();

            if (!IsPostBack) {

                loadDropDowns();
            }
        }

        private void loadGridView() {
           
            OrdenadoresConnection conn = new OrdenadoresConnection();
 
            List<Ordenador> ordenadores = conn.Ordenadores.Include("Persona").ToList();

            DataTable dt = new DataTable();
            dt.Columns.Add("Marca");
            dt.Columns.Add("Modelo");
            dt.Columns.Add("Persona");

            foreach (Ordenador ordenador in ordenadores) {

                DataRow dr = dt.NewRow();
                dt.Rows.Add(dr);

                dr["Marca"] = ordenador.ID;
                dr["Modelo"] = ordenador.Modelo;
                if (ordenador.Persona != null) {

                    dr["Persona"] = ordenador.Persona.Nombre;
                } else {

                    dr["Persona"] = "No tiene";
                }
            }

            GridView1.DataSource = dt;
            GridView1.DataBind();
        }

        private void loadDropDowns() {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            List<Ordenador> ordenadores = conn.Ordenadores.ToList();
            List<Persona> personas = conn.Personas.ToList();

            OrdenadoresDD.Items.Add(new ListItem("---", "-1"));
            PersonasDD.Items.Add(new ListItem("---", "-1"));

            foreach (Ordenador ordenador in ordenadores) {

                OrdenadoresDD.Items.Add(new ListItem(ordenador.Marca + ", " + ordenador.Modelo, ordenador.ID.ToString()));
            }

            foreach (Persona persona in personas) {

                PersonasDD.Items.Add(new ListItem(persona.Nombre, persona.ID.ToString()));
            }
        }

        protected void Insert_Click(object sender, EventArgs e) {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            Ordenador OrdenadorSelected = conn.Ordenadores.Find(int.Parse(OrdenadoresDD.SelectedValue));
            Persona PersonaSelected = conn.Personas.Find(int.Parse(PersonasDD.SelectedValue));

            OrdenadorSelected.Persona = PersonaSelected;

            conn.SaveChanges();
            Response.Redirect(Request.RawUrl);
        }

        protected void Delete_Click(object sender, EventArgs e) {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            Ordenador OrdenadorSelected = conn.Ordenadores.Find(int.Parse(OrdenadoresDD.SelectedValue));
            Persona PersonaSelected = conn.Personas.Find(int.Parse(PersonasDD.SelectedValue));

            PersonaSelected.Ordenadores.Remove(OrdenadorSelected);

            conn.SaveChanges();
            Response.Redirect(Request.RawUrl);
        }
        
    }
}
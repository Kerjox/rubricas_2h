using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EF6 {
    public partial class EF6___C : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            FutbolDbContext conn = new FutbolDbContext();

            GridView1.DataSource = (from Equipo in conn.Equipos
                                    from Futbolista in conn.Futbolistas
                                    select new {

                                        Equipo = Equipo.Nombre,
                                        Futbolista = Futbolista.Nombre
                                    }).ToList();
            GridView1.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e) {

            FutbolDbContext conn = new FutbolDbContext();
            conn.Futbolistas.Include("Equipos").ToList();

            Equipo equipo = conn.Equipos.FirstOrDefault(eq => eq.ID == 1);  // Barcenona
            conn.Futbolistas.FirstOrDefault(f => f.ID == 1).Equipos.Add(equipo); // Insertar Messi

            conn.SaveChanges();
        }

        protected void Button2_Click(object sender, EventArgs e) {

            FutbolDbContext conn = new FutbolDbContext();
            conn.Futbolistas.Include("Equipos").ToList();

            Equipo equipo = conn.Equipos.FirstOrDefault(eq => eq.ID == 1);
            conn.Futbolistas.FirstOrDefault(f => f.ID == 1).Equipos.Remove(equipo);

            conn.SaveChanges();
        }
    }
}
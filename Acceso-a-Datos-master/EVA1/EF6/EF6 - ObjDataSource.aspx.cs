using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EF6 {
    public partial class EF6 : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

        }

        protected void Button1_Click(object sender, EventArgs e) {

            FutbolDbContext conn = new FutbolDbContext();
            conn.Futbolistas.Include("Equipos").ToList();

            Equipo equipo = conn.Equipos.FirstOrDefault(eq => eq.ID == 1); // Barcelona
            conn.Futbolistas.FirstOrDefault(f => f.ID == 1).Equipos.Add(equipo); // Insertar a Messi

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
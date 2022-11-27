using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EF5 {
    public partial class Form01 : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            FutboolConn db = new FutboolConn();

            GridView1.DataSource = (from Futbolista in db.Futbolistas
                                    from Equipos in db.Equipoes
                                    select new {
                                        nomFutbolista = Futbolista.nombre,
                                        nomEquipo = Equipos.nombre
                                    }).ToList();

            GridView1.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e) {

            FutboolConn db = new FutboolConn();
            Futbolista futbolista = db.Futbolistas.FirstOrDefault(f => f.id == 1);
            db.Equipoes.FirstOrDefault(eq => eq.id == 1).Futbolistas.Add(futbolista);
            db.SaveChanges();
        }

        protected void Button2_Click(object sender, EventArgs e) {

            FutboolConn db = new FutboolConn();
            Futbolista futbolista = db.Futbolistas.FirstOrDefault(f => f.id == 1);
            db.Equipoes.FirstOrDefault(eq => eq.id == 1).Futbolistas.Remove(futbolista);
            db.SaveChanges();
        }
    }
}
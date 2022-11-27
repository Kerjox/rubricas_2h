using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF6 {
    public class EquipoRepo {

        public List<Equipo> GetEquipos() {

            FutbolDbContext conn = new FutbolDbContext();
            conn.Equipos.Include("Futbolistas").ToList();
            return conn.Equipos.ToList();
        }

        public void Insert(Equipo equipo) {

            FutbolDbContext conn = new FutbolDbContext();
            conn.Equipos.Add(equipo);
            conn.SaveChanges();
        }
    }
}
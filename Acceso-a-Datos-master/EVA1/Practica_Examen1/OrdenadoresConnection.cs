using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Practica_Examen1 {
    public class OrdenadoresConnection : DbContext {
        public DbSet<Ordenador> Ordenadores { get; set; }
        public DbSet<Persona> Personas { get; set; }
    }
}
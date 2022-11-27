using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace CampoCalculado {
    public class UniversidadDBConnection : DbContext {

        public DbSet<Alumno> Alumnos { get; set; }
        public DbSet<Asignatura> Asignaturas { get; set; }
        public DbSet<Provincia> Provincias { get; set; }
    }
}
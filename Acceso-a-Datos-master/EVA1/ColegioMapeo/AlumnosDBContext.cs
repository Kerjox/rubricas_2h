using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace ColegioMapeo {
    public class AlumnosDBContext : DbContext {

        public DbSet<Curso> Cursos { get; set; }
        public DbSet<Alumno> Alumnos { get; set; }


    }
}
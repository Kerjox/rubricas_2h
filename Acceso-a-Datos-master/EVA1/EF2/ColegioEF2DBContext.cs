using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EF2 {
    public class ColegioEF2DBContext : DbContext {

        public DbSet<Curso> Cursos { get; set; }
        public DbSet<Alumno> Alumnos { get; set; }
    }
}
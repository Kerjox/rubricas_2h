using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EF4 {
    public class ColegioDbContext : DbContext {

        public DbSet<Alumno> Alumnos { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder) {

            modelBuilder.Entity<Alumno>().MapToStoredProcedures();
            base.OnModelCreating(modelBuilder);
        }
    }
}
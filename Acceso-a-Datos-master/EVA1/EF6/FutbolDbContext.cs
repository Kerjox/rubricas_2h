using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EF6 {
    public class FutbolDbContext : DbContext {

        public DbSet<Equipo> Equipos { get; set; }
        public DbSet<Futbolista> Futbolistas { get; set; }

        // No hace falta si no quieres poner un nombre específico a la tabla internedia, te la crea igual
        protected override void OnModelCreating(DbModelBuilder modelBuilder) {

            modelBuilder.Entity<Equipo>()
                .HasMany(eq => eq.Futbolistas)
                .WithMany(f => f.Equipos)
                .Map(m => {
                    m.ToTable("EquiposFutbolistas");
                    m.MapLeftKey("id_equipo");
                    m.MapRightKey("id_futbolista");
                });

            base.OnModelCreating(modelBuilder);
        }
    }
}
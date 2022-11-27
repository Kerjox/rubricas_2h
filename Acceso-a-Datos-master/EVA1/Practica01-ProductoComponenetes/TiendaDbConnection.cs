using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Practica01_ProductoComponenetes {
    public class TiendaDbConnection : DbContext {

        public DbSet<Producto> Productos { get; set; }
        public DbSet<Componenete> Componentes { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder) {

            modelBuilder.Entity<Producto>()
                .HasMany(c => c.Componentes)
                .WithMany(p => p.Productos)
                .Map(m => {
                        m.ToTable("ProductosComponentes");
                        m.MapLeftKey("id_Producto");
                        m.MapRightKey("id_Componente");
                    });
            base.OnModelCreating(modelBuilder);
        }
    }
}
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace UBALDE_DANIEL_AccesoADatos {
    public class ComponentesConnection : DbContext {

        public DbSet<ProductosPropios> ProductosPropios { get; set; }
        public DbSet<Componente> Componentes { get; set; }
        public DbSet<Marca> Marcas { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder) {

            modelBuilder.Entity<ProductosPropios>()
                .HasMany(c => c.Componentes)
                .WithMany(p => p.ProductosPropios)
                .Map(m => {
                    m.ToTable("ProductosComponentes");
                    m.MapLeftKey("id_Producto");
                    m.MapRightKey("id_Componente");
                });
            base.OnModelCreating(modelBuilder);
        }
    }
}
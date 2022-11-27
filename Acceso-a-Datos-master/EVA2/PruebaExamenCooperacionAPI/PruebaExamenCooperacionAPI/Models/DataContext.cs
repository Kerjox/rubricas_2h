using Microsoft.EntityFrameworkCore;

namespace PruebaExamenCooperacionAPI.Models {
    public class DataContext : DbContext {

        public DataContext(DbContextOptions<DataContext> options) : base(options) { }

        public DbSet<Proyecto> Proyectos { get; set; }
        public DbSet<Pais> Paises { get; set; }
        public DbSet<Destinatario> Destinatarios { get; set; }
        public DbSet<ODS> Odses { get; set; }

    }
}

using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MVC01.Models {
    public class Connection : DbContext {

        public DbSet<MarcaModel> Marcas { get; set; }
        public DbSet<SerieModel> Series { get; set; }
        public DbSet<VehiculoModel> Vehiculos { get; set; }
        public DbSet<ExtraModel> Extras { get; set; }
        public DbSet<VehiculoExtrasModel> VehiculoExtras { get; set; }
    }
}
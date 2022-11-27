using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace MVC01.Models {
    public class SerieModel {

        [Key]
        public int ID { get; set; }
        [DisplayName("Serie")]
        public string Nombre { get; set; }

        [ForeignKey("MarcaID")]
        public MarcaModel Marca { get; set; }
        public int MarcaID { get; set; }
        public List<VehiculoModel> Veiculos { get; set; }
    }
}
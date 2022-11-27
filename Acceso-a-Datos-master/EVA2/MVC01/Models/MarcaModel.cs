using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MVC01.Models {
    public class MarcaModel {

        [Key]
        public int ID { get; set; }
        [DisplayName("Marca")]
        public string Nombre { get; set; }
        public List<SerieModel> Series { get; set; }
    }
}
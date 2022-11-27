using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.UI.WebControls;

namespace MVC01.Models {
    public class VehiculoModel {

        [Key]
        public int ID { get; set; }
        public string Matricula { get; set; }
        public string Color { get; set; }
        public int SerieID { get; set; }
        public SerieModel Serie { get; set; }
        public List<int> VehiculoExtrasID { get; set; }
        public List<VehiculoExtrasModel> VehiculoExtras { get; set; }

        [NotMapped]
        public List<SelectListItem> ExtrasSelectListItem { get; set; }
    }
}
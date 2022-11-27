using System.Collections.Generic;

namespace MVC01.Models {
    public class ExtraModel {

        public int ID { get; set; }
        public string Tipo_Extra { get; set; }
        public List<VehiculoExtrasModel> VehiculoExtras { get; set; }
    }
}
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using MVC01.Models;

namespace MVC01.Models {
    public class VehiculoExtrasModel {

        [Key] public int ID { get; set; }
        public int VehiculoID { get; set; }
        public VehiculoModel Vehiculo { get; set; }
        public int ExtraID { get; set; }
        public ExtraModel Extra { get; set; }
    }
}
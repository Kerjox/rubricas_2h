using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF4 {
    public class Alumno {

        public int ID { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Genero { get; set; }
        public int Edad { get; set; }
    }
}
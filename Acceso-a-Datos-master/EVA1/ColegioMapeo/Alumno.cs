using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ColegioMapeo {
    public class Alumno {

        public int ID { get; set; }
        public String DNI { get; set; }
        public String Nombre { get; set; }
        public String Apellido { get; set; }
        public String Sexo { get; set; }
        public Curso Curso { get; set; }
        public int Edad { get; set; }
    }
}
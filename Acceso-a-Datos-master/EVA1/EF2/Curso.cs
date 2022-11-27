using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF2 {
    public class Curso {

        public int ID { get; set; }
        public string Nombre { get; set; }
        public List<Alumno> Alumnos { get; set; }
    }
}
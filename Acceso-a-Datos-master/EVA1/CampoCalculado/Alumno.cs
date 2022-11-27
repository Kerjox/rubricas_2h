using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CampoCalculado {
    public class Alumno {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public DateTime FNac { get; set; }
        public List<Asignatura> Asignaturas { get; set; }
        public Provincia Provincia { get; set; }
    }
}
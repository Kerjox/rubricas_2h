using System.Collections.Generic;

namespace CampoCalculado {
    public class Provincia {
        public int ID { get; set; }
        public string Nombre { get; set; }

        public List<Alumno> Alumnos { get; set; }
    }
}
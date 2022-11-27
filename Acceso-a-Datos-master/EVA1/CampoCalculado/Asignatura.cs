using System.Collections.Generic;

namespace CampoCalculado {
    public class Asignatura {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public int Creditos { get; set; }
        public List<Alumno> Alumnos { get; set; }
    }
}
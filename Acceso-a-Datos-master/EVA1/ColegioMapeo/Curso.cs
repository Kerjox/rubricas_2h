using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ColegioMapeo {
    public class Curso {
        public int ID { get; set; }
        public String NomCurso { get; set; }

        public List<Alumno> Alumnos { get; set; }
    }
}
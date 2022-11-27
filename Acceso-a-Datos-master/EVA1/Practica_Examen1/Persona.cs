using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Practica_Examen1 {
    public class Persona {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public DateTime FechaNac { get; set; }
        public List<Ordenador> Ordenadores { get; set; }
    }
}
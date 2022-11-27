using System.Collections.Generic;

namespace EF6 {
    public class Futbolista {

        public int ID { get; set; }
        public string Nombre { get; set; }
        public List<Equipo> Equipos { get; set; }
    }
}
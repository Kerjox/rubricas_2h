using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF6 {
    public class Equipo {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public List<Futbolista> Futbolistas { get; set; }
    }
}
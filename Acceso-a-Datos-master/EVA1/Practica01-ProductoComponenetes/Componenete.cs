using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Practica01_ProductoComponenetes {
    public class Componenete {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public int Precio { get; set; }
        public List<Producto> Productos { get; set; }
    }
}
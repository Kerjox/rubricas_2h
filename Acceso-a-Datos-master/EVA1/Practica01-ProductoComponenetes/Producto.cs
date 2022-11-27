using System.Collections.Generic;

namespace Practica01_ProductoComponenetes {
    public class Producto {

        public int ID { get; set; }
        public string Nombre { get; set; }
        public List<Componenete> Componentes { get; set; }
    }
}
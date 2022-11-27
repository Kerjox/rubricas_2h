using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UBALDE_DANIEL_AccesoADatos {
    public class ProductosPropios {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public int Precio { get; set; }
        public List<Componente> Componentes { get; set; }
    }
}
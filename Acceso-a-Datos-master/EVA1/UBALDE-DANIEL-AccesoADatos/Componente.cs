using System.Collections.Generic;

namespace UBALDE_DANIEL_AccesoADatos {
    public class Componente {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public int NumUnidadesBolsa { get; set; }
        public double PrecioBolsa { get; set; }
        public List<ProductosPropios> ProductosPropios { get; set; }
        public Marca Marca { get; set; }
    }
}
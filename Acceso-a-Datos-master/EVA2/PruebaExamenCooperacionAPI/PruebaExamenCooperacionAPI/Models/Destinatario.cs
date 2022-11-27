using System.Text.Json.Serialization;

namespace PruebaExamenCooperacionAPI.Models {
    public class Destinatario {

        public int ID { get; set; }
        public string NombreDestinatario { get; set; }
        public string Direccion { get; set; }
        [JsonIgnore]
        public Pais Pais { get; set; }
        [JsonIgnore]
        public List<Proyecto> Proyectos { get; set; }
    }
}

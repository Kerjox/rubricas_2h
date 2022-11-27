using System.Text.Json.Serialization;

namespace PruebaExamenCooperacionAPI.Models {
    public class ODS {

        public int ID { get; set; }
        public string NombreOds { get; set; }
        public string FotoURL { get; set; }
        [JsonIgnore]
        public List<Proyecto> Proyectos { get; set; }
    }
}

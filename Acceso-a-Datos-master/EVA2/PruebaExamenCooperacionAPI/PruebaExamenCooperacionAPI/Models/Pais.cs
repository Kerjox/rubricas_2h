using System.Text.Json.Serialization;

namespace PruebaExamenCooperacionAPI.Models {
    public class Pais {

        public int ID { get; set; }
        public string NombrePais { get; set; }
        public string BanderaURL { get; set; }
        [JsonIgnore]
        public List<Destinatario> Destinatarios { get; set; }
    }
}

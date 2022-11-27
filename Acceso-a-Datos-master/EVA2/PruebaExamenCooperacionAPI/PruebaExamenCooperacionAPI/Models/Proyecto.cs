using System.Text.Json.Serialization;

namespace PruebaExamenCooperacionAPI.Models {
    public class Proyecto {

        public int ID { get; set; }
        public string nombreProyecto { get; set; }
        public DateTime FechaInicio { get; set; }
        [JsonIgnore]
        public Destinatario Destinatario { get; set; }
        [JsonIgnore]
        public ODS Ods { get; set; }
    }
}

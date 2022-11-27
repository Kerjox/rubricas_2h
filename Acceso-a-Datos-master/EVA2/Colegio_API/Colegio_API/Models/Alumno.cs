using System.Text.Json.Serialization;

namespace Colegio_API.Models {
    public class Alumno {
        public int ID { get; set; }
        public string Name { get; set; }
        public string Street { get; set; }
        public DateTime Date { get; set; }
        public string Gender { get; set; }
        [JsonIgnore]
        public Curso Curso { get; set; }
    }
}

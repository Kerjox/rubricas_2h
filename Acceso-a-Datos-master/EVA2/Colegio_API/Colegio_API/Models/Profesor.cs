namespace Colegio_API.Models {
    public class Profesor {

        public int ID { get; set; }
        public string Name { get; set; } = string.Empty;
        public string Street { get; set; } = string.Empty;
        public DateTime Date { get; set; } = DateTime.Now;
        public string Gender { get; set; } = string.Empty;
        public string Degree { get; set; } = string.Empty;

    }
}

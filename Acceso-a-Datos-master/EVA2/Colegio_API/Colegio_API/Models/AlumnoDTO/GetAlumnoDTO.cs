namespace Colegio_API.Models.AlumnoDTO {
    public class GetAlumnoDTO {

        public int ID { get; set; }
        public string Name { get; set; }
        public string Street { get; set; }
        public DateTime Date { get; set; }
        public string Gender { get; set; }
        public Curso Curso { get; set; }
    }
}

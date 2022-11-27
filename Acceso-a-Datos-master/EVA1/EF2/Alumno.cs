namespace EF2 {
    public class Alumno {
        public int ID { get; set; }
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Genero { get; set; }
        public int Edad { get; set; }
        public Curso Curso { get; set; }
    }
}
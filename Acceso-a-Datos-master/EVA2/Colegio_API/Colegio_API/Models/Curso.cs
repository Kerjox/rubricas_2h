using System.Text.Json.Serialization;

namespace Colegio_API.Models {
  public class Curso {

    public int ID { get; set; }
    public string NombreCurso { get; set; }
    public string Localizacion { get; set; }
    [JsonIgnore]
    public List<Alumno> Alumnos { get; set; }

  }
}

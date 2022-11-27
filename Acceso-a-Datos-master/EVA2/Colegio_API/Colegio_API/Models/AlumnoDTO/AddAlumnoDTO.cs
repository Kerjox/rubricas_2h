namespace Colegio_API.Models.AlumnoDTO {
  public class AddAlumnoDTO
  {
    public string Name { get; set; } = String.Empty;
    public string Street { get; set; } = String.Empty;
    public DateTime Date { get; set; } = DateTime.Today;
    public string Gender { get; set; } = String.Empty;
    public int CursoID { get; set; }
  }
}

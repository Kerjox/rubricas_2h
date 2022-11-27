using Microsoft.EntityFrameworkCore;

namespace Colegio_API.Models {
    public class DataContext : DbContext {

        public DataContext(DbContextOptions<DataContext> options) : base(options) {}

        public DbSet<Alumno> Alumnos { get; set; }
        public DbSet<Profesor> Profesores { get; set; }
        public DbSet<Curso> Cursos { get; set; }
    }
}

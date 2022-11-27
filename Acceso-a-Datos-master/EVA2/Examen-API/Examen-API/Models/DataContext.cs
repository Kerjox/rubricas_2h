using Microsoft.EntityFrameworkCore;

namespace Examen_API.Models {
  public class DataContext : DbContext {

    public DataContext(DbContextOptions<DataContext> options) : base(options) { }


  }
}

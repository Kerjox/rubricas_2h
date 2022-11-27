#nullable disable
using Colegio_API.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Colegio_API.Models.AlumnoDTO;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Colegio_API.Controllers {
  [Route("api/[controller]")]
  [ApiController]
  public class AlumnosController : ControllerBase {
    private readonly DataContext _context;

    public AlumnosController(DataContext context) {
      _context = context;
    }

    // GET: api/Alumnos
    [HttpGet]
    public async Task<ActionResult<IEnumerable<GetAlumnoDTO>>> GetAlumnos() {

        var alumnos = await _context.Alumnos.Include(a => a.Curso)
            .ToListAsync();

        List<GetAlumnoDTO> alumnosDTO = new List<GetAlumnoDTO>();

        foreach (var alumno in alumnos) {
            var alumnoDTO = new GetAlumnoDTO
            {
                ID = alumno.ID,
                Name = alumno.Name,
                Date = alumno.Date,
                Gender = alumno.Gender,
                Street = alumno.Street,
                Curso = alumno.Curso
            };
            alumnosDTO.Add(alumnoDTO);
        }

        return alumnosDTO;
    }

    // GET: api/Alumnos/5
    [HttpGet("{id}")]
    public async Task<ActionResult<Alumno>> GetAlumno(int id) {
      var alumno = await _context.Alumnos.FindAsync(id);

      if (alumno == null) {
        return NotFound();
      }

      return alumno;
    }

    // PUT: api/Alumnos/5
    // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
    [HttpPut("{id}")]
    public async Task<IActionResult> PutAlumno(int id, Alumno alumno) {
      if (id != alumno.ID) {
        return BadRequest();
      }

      _context.Entry(alumno).State = EntityState.Modified;

      try {
        await _context.SaveChangesAsync();
      } catch (DbUpdateConcurrencyException) {
        if (!AlumnoExists(id)) {
          return NotFound();
        } else {
          throw;
        }
      }

      return NoContent();
    }

    // POST: api/Alumnos
    // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
    [HttpPost]
    public async Task<ActionResult<Alumno>> PostAlumno(AddAlumnoDTO request)
    {

      var curse = await _context.Cursos.FindAsync(request.CursoID);

      if (curse == null)
      {
        return NotFound();
      }

      var newAlumno = new Alumno {

        Name = request.Name,
        Date = request.Date,
        Street = request.Street,
        Gender = request.Gender,
        Curso = curse

      };

      _context.Alumnos.Add(newAlumno);
      await _context.SaveChangesAsync();

      return CreatedAtAction("GetAlumno", new { id = newAlumno.ID }, newAlumno);
    }

    // DELETE: api/Alumnos/5
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteAlumno(int id) {
      var alumno = await _context.Alumnos.FindAsync(id);
      if (alumno == null) {
        return NotFound();
      }

      _context.Alumnos.Remove(alumno);
      await _context.SaveChangesAsync();

      return NoContent();
    }

    private bool AlumnoExists(int id) {
      return _context.Alumnos.Any(e => e.ID == id);
    }

    // Rutas Personalizadas

    // GET: api/Alumnos/Name/Pepe
    [HttpGet("Name/{name}")]
    public async Task<ActionResult<GetAlumnoDTO>> GetAlumnoByName(string name) {

        var alumno = await _context.Alumnos
            .Include(c => c.Curso)
            .FirstOrDefaultAsync(a => a.Name == name);

        var _alumno = new GetAlumnoDTO() {
            ID = alumno.ID,
            Name = alumno.Name,
            Curso = alumno.Curso,
            Street = alumno.Street,
            Date = alumno.Date,
            Gender = alumno.Gender
        };


        return _alumno;
        }


    // GET: api/Alumnos/Curso/
    [HttpGet("Curso/{id}")]
    public async Task<ActionResult<IEnumerable<Alumno>>> GetAlumnoCurso(int id)
    {

        var alumnos = await _context.Alumnos
            .Include(c => c.Curso)
            .Where(a => a.Curso.ID == id).ToListAsync();


        return alumnos;
    }
  }
}

#nullable disable
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PruebaExamenCooperacionAPI.Models;
using PruebaExamenCooperacionAPI.Models.DTO;

namespace PruebaExamenCooperacionAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProyectosController : ControllerBase
    {
        private readonly DataContext _context;

        public ProyectosController(DataContext context)
        {
            _context = context;
        }

        // GET: api/Proyectos
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Proyecto>>> GetProyectos()
        {
            return await _context.Proyectos.ToListAsync(); ;
        }

        // GET: api/Proyectos
        [HttpGet("idsDTO")]
        public async Task<ActionResult<IEnumerable<ProyectoIdsDTO>>> GetProyectosIdesDTO() {

            var proyectoIdsDTOList = new List<ProyectoIdsDTO>();

            var proyectos = await _context.Proyectos
                .Include(a=> a.Ods)
                .Include(a=>a.Destinatario)
                .ToListAsync();

            foreach (var proyecto in proyectos)
            {

                var proyectoIdsDTO = new ProyectoIdsDTO
                {

                    ID = proyecto.ID,
                    nombreProyecto = proyecto.nombreProyecto,
                    FechaInicio = proyecto.FechaInicio,
                    IDOds = proyecto.Ods.ID,
                    IDDestinatario = proyecto.Destinatario.ID

            };

                proyectoIdsDTOList.Add(proyectoIdsDTO);
            }

            return proyectoIdsDTOList;
        }

        // GET: api/Proyectos/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Proyecto>> GetProyecto(int id)
        {
            var proyecto = await _context.Proyectos.FindAsync(id);

            if (proyecto == null)
            {
                return NotFound();
            }

            return proyecto;
        }

        // PUT: api/Proyectos/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutProyecto(int id, Proyecto proyecto)
        {
            if (id != proyecto.ID)
            {
                return BadRequest();
            }

            _context.Entry(proyecto).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ProyectoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Proyectos
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Proyecto>> PostProyecto(Proyecto proyecto)
        {
            _context.Proyectos.Add(proyecto);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetProyecto", new { id = proyecto.ID }, proyecto);
        }

        // DELETE: api/Proyectos/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteProyecto(int id)
        {
            var proyecto = await _context.Proyectos.FindAsync(id);
            if (proyecto == null)
            {
                return NotFound();
            }

            _context.Proyectos.Remove(proyecto);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ProyectoExists(int id)
        {
            return _context.Proyectos.Any(e => e.ID == id);
        }
    }
}

#nullable disable
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PruebaExamenCooperacionAPI.Models;

namespace PruebaExamenCooperacionAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DestinatariosController : ControllerBase
    {
        private readonly DataContext _context;

        public DestinatariosController(DataContext context)
        {
            _context = context;
        }

        // GET: api/Destinatarios
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Destinatario>>> GetDestinatarios()
        {
            return await _context.Destinatarios.ToListAsync();
        }

        // GET: api/Destinatarios/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Destinatario>> GetDestinatario(int id)
        {
            var destinatario = await _context.Destinatarios.FindAsync(id);

            if (destinatario == null)
            {
                return NotFound();
            }

            return destinatario;
        }

        // PUT: api/Destinatarios/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutDestinatario(int id, Destinatario destinatario)
        {
            if (id != destinatario.ID)
            {
                return BadRequest();
            }

            _context.Entry(destinatario).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DestinatarioExists(id))
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

        // POST: api/Destinatarios
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Destinatario>> PostDestinatario(Destinatario destinatario)
        {
            _context.Destinatarios.Add(destinatario);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetDestinatario", new { id = destinatario.ID }, destinatario);
        }

        // DELETE: api/Destinatarios/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDestinatario(int id)
        {
            var destinatario = await _context.Destinatarios.FindAsync(id);
            if (destinatario == null)
            {
                return NotFound();
            }

            _context.Destinatarios.Remove(destinatario);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool DestinatarioExists(int id)
        {
            return _context.Destinatarios.Any(e => e.ID == id);
        }
    }
}

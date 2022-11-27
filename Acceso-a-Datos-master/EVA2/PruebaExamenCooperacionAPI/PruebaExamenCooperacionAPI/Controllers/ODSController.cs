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
    public class ODSController : ControllerBase
    {
        private readonly DataContext _context;

        public ODSController(DataContext context)
        {
            _context = context;
        }

        // GET: api/ODS
        [HttpGet]
        public async Task<ActionResult<IEnumerable<ODS>>> GetOdses()
        {
            return await _context.Odses.ToArrayAsync();
        }

        // GET: api/ODS/5
        [HttpGet("{id}")]
        public async Task<ActionResult<ODS>> GetODS(int id)
        {
            var oDS = await _context.Odses.FindAsync(id);

            if (oDS == null)
            {
                return NotFound();
            }

            return oDS;
        }

        // PUT: api/ODS/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutODS(int id, ODS oDS)
        {
            if (id != oDS.ID)
            {
                return BadRequest();
            }

            _context.Entry(oDS).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ODSExists(id))
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

        // POST: api/ODS
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<ODS>> PostODS(ODS oDS)
        {
            _context.Odses.Add(oDS);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetODS", new { id = oDS.ID }, oDS);
        }

        // DELETE: api/ODS/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteODS(int id)
        {
            var oDS = await _context.Odses.FindAsync(id);
            if (oDS == null)
            {
                return NotFound();
            }

            _context.Odses.Remove(oDS);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ODSExists(int id)
        {
            return _context.Odses.Any(e => e.ID == id);
        }
    }
}

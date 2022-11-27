using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ColegioMapeo {
    public class AlumnosRepo {
        
        public List<Curso> GetCursos() {

            AlumnosDBContext alumnosDBContext = new AlumnosDBContext();
            alumnosDBContext.Cursos.Include("Alumnos").ToList();
            return alumnosDBContext.Cursos.ToList();
        }
    }
}
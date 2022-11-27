using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EF2 {
    public class AlumnosRepo {

        public List<Curso> getCursos() {

            ColegioEF2DBContext conn = new ColegioEF2DBContext();

            conn.Cursos.Include("Alumnos").ToList();
            return conn.Cursos.ToList();
        }
    }
}
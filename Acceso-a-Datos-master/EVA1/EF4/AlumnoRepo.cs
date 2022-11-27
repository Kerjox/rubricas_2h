using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace EF4 {
    public class AlumnoRepo {

        ColegioDbContext colegioDbContext = new ColegioDbContext();

        public void insert(Alumno alumno) {

            colegioDbContext.Alumnos.Add(alumno);
            colegioDbContext.SaveChanges();
        }

        public void delete(Alumno alumno) {

            Alumno alumnoToRemove = colegioDbContext.Alumnos.Find(alumno.ID);
            colegioDbContext.Alumnos.Remove(alumnoToRemove);
            colegioDbContext.SaveChanges();
        }

        public void update(Alumno alumno) {

            //Alumno dbAlumno = colegioDbContext.Alumnos.Find(alumno);
            Alumno dbAlumno = colegioDbContext.Alumnos.FirstOrDefault(a => a.ID == alumno.ID);
            dbAlumno.Nombre = alumno.Nombre;
            dbAlumno.Apellido = alumno.Apellido;
            dbAlumno.Edad = alumno.Edad;
            dbAlumno.Genero = alumno.Genero;

            colegioDbContext.SaveChanges();
        }

        public List<Alumno> findAll() {

            return colegioDbContext.Alumnos.ToList();
        }
    }
}
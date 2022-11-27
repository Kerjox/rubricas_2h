using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using PracticaExamenEscuela.Models;

namespace PracticaExamenEscuela.Controllers
{
    public class AsignaturasController : Controller
    {
        private EscuelaEntities conn = new EscuelaEntities();

        // GET: Asignaturas
        public ActionResult Index()
        {
            var a = conn.Asignaturas.ToList();
            return View(a);
        }

        // GET: Asignaturas/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Asignaturas/Create
        public ActionResult Create()
        {
            var cursosSelectListItem = new List<SelectListItem>();

            foreach (var curso in conn.Cursos)
            {

                var listItem = new SelectListItem();

                listItem.Value = curso.ID.ToString();
                listItem.Text = curso.NombreCurso + " - " + curso.Etapas.Acronimo;

                cursosSelectListItem.Add(listItem);
            }

            ViewBag.cursos = cursosSelectListItem;
            return View();
        }

        // POST: Asignaturas/Create
        [HttpPost]
        public ActionResult Create(Asignaturas asignatura)
        {
            try
            {

                asignatura.AsignaturasCursos = getAsignaturasCurso(asignatura.CursoListID);
                conn.Asignaturas.Add(asignatura);

                conn.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        private List<AsignaturasCursos> getAsignaturasCurso(List<int> ExtrasID) {

            List<AsignaturasCursos> vehiculoExtrasList = new List<AsignaturasCursos>();

            foreach (var _cursoID in ExtrasID) {

                AsignaturasCursos asignaturasCursos = new AsignaturasCursos();

                asignaturasCursos.CursoID = _cursoID;
                vehiculoExtrasList.Add(asignaturasCursos);
            }

            return vehiculoExtrasList;
        }

        // GET: Asignaturas/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Asignaturas/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Asignaturas/Delete/5
        public ActionResult Delete(int id)
        {
            

            return View(conn.Asignaturas.Find(id));
        }

        // POST: Asignaturas/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {

                var asignatura = conn.Asignaturas.Find(id);

                var asignaturasCurso = conn.AsignaturasCursos.Where(a => a.AsignaturaID == id);
                conn.AsignaturasCursos.RemoveRange(asignaturasCurso);
                
                conn.Asignaturas.Remove(asignatura);
                conn.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        public ActionResult ListByEtapaCurso(int idEtapa = -1, int idCurso = -1)
        {

            var asignaturas = new List<Asignaturas>();

            if (idEtapa != -1) {

                ViewBag.Etapas = new SelectList(conn.Etapas, "ID", "Acronimo", idEtapa);
            } else {

                ViewBag.Etapas = new SelectList(conn.Etapas, "ID", "Acronimo");
            }

            if (idCurso != -1) {

                ViewBag.Cursos = new SelectList(conn.Cursos.Where(s => s.Etapas.ID == idEtapa), "ID", "NombreCurso", idCurso);
                asignaturas = conn.AsignaturasCursos
                    .Where(ac => ac.Cursos.ID == idCurso)
                    .Select(a => a.Asignaturas)
                    .ToList();
            } else {

                ViewBag.Cursos = new SelectList(conn.Cursos.Where(s => s.Etapas.ID == idEtapa), "ID", "NombreCurso");
            }

            return View(asignaturas);
        }
    }
}

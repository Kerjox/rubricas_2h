using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using PracticaExamenEscuela.Models;

namespace PracticaExamenEscuela.Controllers
{
    public class CursoController : Controller
    {
        private EscuelaEntities conn = new EscuelaEntities();
        // GET: Curso
        public ActionResult Index()
        {
            return View(conn.Cursos.ToList());
        }

        // GET: Curso/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Curso/Create
        public ActionResult Create()
        {
            ViewBag.EtapaID = new SelectList(conn.Etapas.ToList(), "ID", "Acronimo");
            return View();
        }

        // POST: Curso/Create
        [HttpPost]
        public ActionResult Create(Cursos curso)
        {
            try
            {
                conn.Cursos.Add(curso);
                conn.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Curso/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Curso/Edit/5
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

        // GET: Curso/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Curso/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Curso/Etapa/5
        public ActionResult CursosEtapa(int etapaID) {

            var cursos = conn.Cursos.Where(e => e.EtapaID == etapaID).ToList();
            return View(cursos);
        }
    }
}

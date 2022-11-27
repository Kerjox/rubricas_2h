using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using PracticaExamenEscuela.Models;

namespace PracticaExamenEscuela.Controllers
{
    public class EtapasController : Controller
    {
        private EscuelaEntities conn = new EscuelaEntities();

        // GET: Etapas
        public ActionResult Index()
        {
            return View(conn.Etapas.ToList());
        }

        // GET: Etapas/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Etapas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Etapas/Create
        [HttpPost]
        public ActionResult Create(Etapas etapa)
        {
            try
            {
                conn.Etapas.Add(etapa);
                conn.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Etapas/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Etapas/Edit/5
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

        // GET: Etapas/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Etapas/Delete/5
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

        public ActionResult ListEtapasCurso(int idAsignatura = -1)
        {

            var etapas = new List<Etapas>();
            if (idAsignatura != -1)
            {
                ViewBag.Asignaturas = new SelectList(conn.Asignaturas, "ID", "NombreAsignatura", idAsignatura);

                etapas = conn.AsignaturasCursos
                    .Where(a => a.Asignaturas.ID == idAsignatura)
                    .Select(a => a.Cursos.Etapas).Distinct().ToList();
            }
            else
            {
                ViewBag.Asignaturas = new SelectList(conn.Asignaturas, "ID", "NombreAsignatura");
            }

            return View(etapas);
        }
    }
}

using MVC01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC01.Controllers
{

    public class SeriesController : Controller
    {

        Connection db = new Connection();

        // GET: Series
        public ActionResult Index()
        {

            List<SerieModel> series = db.Series.Include("Marca").ToList();

            return View(series);
        }

        // GET: Series/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Series/Create
        public ActionResult Create()
        {


            ViewBag.MarcaID = new SelectList(db.Marcas, "ID", "Nombre");
            return View();
        }

        // POST: Series/Create
        [HttpPost]
        public ActionResult Create(SerieModel serie)
        {
            try
            {
                db.Series.Add(serie);
                db.SaveChanges();

                return RedirectToAction("Create");
            }
            catch
            {
                return View();
            }
        }

        // GET: Series/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Series/Edit/5
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

        // GET: Series/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Series/Delete/5
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

        public ActionResult ListSeriesMarca(int idMarca) {

            ViewBag.Marca = db.Marcas.ToList();

            List<SerieModel> series = (from s in db.Series where s.Marca.ID.Equals(idMarca) select s).ToList();

            return View(series);
        }
    }
}

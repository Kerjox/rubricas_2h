using MVC01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC01.Controllers
{
    public class MarcaController : Controller
    {

        Connection db = new Connection();

        // GET: Marca
        public ActionResult Index()
        {

            List<MarcaModel> marcas = db.Marcas.ToList();
            return View(marcas);
        }

        // GET: DropDownMenuMarca
        public ActionResult DropDownMenuMarcas() {

                
            ViewBag.Marcas = new SelectList(db.Marcas, "ID", "Nombre");
            ViewBag.Marcas2 = db.Marcas.ToList();

            return View();
        }

        // GET: Marca/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Marca/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Marca/Create
        [HttpPost]
        public ActionResult Create(MarcaModel marca)
        {
            try
            {
                db.Marcas.Add(marca);
                db.SaveChanges();
                /*
                using (var db = new Connection()) {

                    db.Marcas.Add(marca);
                    db.SaveChanges();
                }
                */

                return RedirectToAction("Create");
            }
            catch
            {
                return View();
            }
        }

        // GET: Marca/Edit/5
        public ActionResult Edit(int id)
        {


            return View(db.Marcas.Find(id));
        }

        // POST: Marca/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, MarcaModel marca)
        {
            try
            {
                MarcaModel MarcaDb = db.Marcas.Find(id);
                MarcaDb.Nombre = marca.Nombre;
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Marca/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Marca/Delete/5
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
    }
}

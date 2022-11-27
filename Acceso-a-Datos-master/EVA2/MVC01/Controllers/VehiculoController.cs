using MVC01.Models;
using System;
using System.Collections;
using System.Collections.Generic;
using System.EnterpriseServices;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.UI.WebControls;

namespace MVC01.Controllers
{
    public class VehiculoController : Controller {

        Connection db = new Connection();

        // GET: Vehiculo
        public ActionResult Index() {

          var vehiculos = db.Vehiculos
            .Include("Serie")
            .Include("VehiculoExtras")
            .ToList();

          ViewBag.Marca = db.Marcas.ToList();
          

          foreach (var _vehiculo in vehiculos) {
            
            var ExtrasListItems = new List<SelectListItem>();
            var ExtraModel = db.VehiculoExtras.Where(v => v.VehiculoID == _vehiculo.ID).Select(e => e.Extra).ToList();

            foreach (var _extra in ExtraModel) {
              
              ExtrasListItems.Add(new SelectListItem { Disabled = true, Text = _extra.Tipo_Extra });
            }

            _vehiculo.ExtrasSelectListItem = ExtrasListItems;
          }

          return View(vehiculos);
        }

        // GET: Vehiculo/Details/5
        public ActionResult Details(int id)
        {
            ViewBag.Marca = db.Marcas.ToList();
            ViewBag.Serie = db.Series.ToList();
            ViewBag.Extras = db.Extras.ToList();
            var vehiculos = db.Vehiculos
                .Include("VehiculoExtras")
                .FirstOrDefault(v => v.ID == id);

            ViewBag.extras = db.VehiculoExtras
                .Include("Extra")
                .Where(v => v.VehiculoID == id)
                .Select(e => e.Extra).ToList();
            
            return View(vehiculos);
        }

        // GET: Vehiculo/Create
        public ActionResult Create(int ID_Marca = -1)
        {
            if (ID_Marca != -1) {

                ViewBag.SerieID = new SelectList(db.Series.Where(m => m.MarcaID == ID_Marca), "ID", "Nombre");
                ViewBag.MarcasDropDown = new SelectList(db.Marcas, "ID", "Nombre", ID_Marca);

            } else {
                ViewBag.SerieID = new SelectList("");
                ViewBag.MarcasDropDown = new SelectList(db.Marcas, "ID", "Nombre");
            }

            ViewBag.Extras = new MultiSelectList(db.Extras, "ID", "Tipo_Extra");
            
            return View();
        }

        // POST: Vehiculo/Create
        [HttpPost]
        public ActionResult Create(VehiculoModel vehiculo)
        {
            try { 

                db.Vehiculos.Add(vehiculo);
                db.VehiculoExtras.AddRange(getVehiculoExtrasModels(vehiculo.VehiculoExtrasID));
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        private List<VehiculoExtrasModel> getVehiculoExtrasModels(List<int> ExtrasID)
        {

          List<VehiculoExtrasModel> vehiculoExtrasList = new List<VehiculoExtrasModel>();

          foreach (var _extra in ExtrasID)
          {

            VehiculoExtrasModel VehiculoExtra = new VehiculoExtrasModel();

            VehiculoExtra.ExtraID = _extra;
            vehiculoExtrasList.Add(VehiculoExtra);
          }

          return vehiculoExtrasList;
        }

        private List<VehiculoExtrasModel> getVehiculoExtrasModels(int _VehiculoID, List<int> _ExtrasID) {

          List<VehiculoExtrasModel> vehiculoExtrasList = new List<VehiculoExtrasModel>();

          foreach (var _extraID in _ExtrasID) {

            VehiculoExtrasModel VehiculoExtra = new VehiculoExtrasModel();

            VehiculoExtra.VehiculoID = _VehiculoID;
            VehiculoExtra.ExtraID = _extraID;
            vehiculoExtrasList.Add(VehiculoExtra);
          }

          return vehiculoExtrasList;
        }

    // GET: Vehiculo/Edit/5
    public ActionResult Edit(int id)
        {

            
            var vehiculo = db.Vehiculos.Find(id);
            ViewBag.Extras = new MultiSelectList(db.Extras, "ID", "Tipo_Extra", getExtrasVehiculo(vehiculo.ID));
            ViewBag.SerieID = new SelectList(db.Series, "ID", "Nombre", vehiculo.SerieID);

            return View(vehiculo);
        }

    private IEnumerable getExtrasVehiculo(int _vehiculoID) {

      return db.VehiculoExtras
        .Where(e => e.VehiculoID == _vehiculoID)
        .Select(e => e.ExtraID).ToList();
    }

    // POST: Vehiculo/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, VehiculoModel Vehiculo)
        {
            try { 

                var dbVehiculo = db.Vehiculos.Include("VehiculoExtras").FirstOrDefault(v => v.ID == id);

                dbVehiculo.Matricula = Vehiculo.Matricula;
                dbVehiculo.SerieID = Vehiculo.SerieID;
                dbVehiculo.Color = Vehiculo.Color;
                db.VehiculoExtras.RemoveRange(dbVehiculo.VehiculoExtras);
                db.VehiculoExtras.AddRange(getVehiculoExtrasModels(Vehiculo.ID, Vehiculo.VehiculoExtrasID));
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Vehiculo/Delete/5
        public ActionResult Delete(int id)
        {
            ViewBag.serie = db.Series.ToList();
            return View(db.Vehiculos.Find(id));
        }

        // POST: Vehiculo/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, VehiculoModel vehiculo)
        {
            try
            {
                db.Vehiculos.Remove(db.Vehiculos.Find(id));
                db.SaveChanges();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        
        // GET: Vehiculo by Matricula
        public ActionResult FindByMatriculaDropDown(string Matriculas) {


            ViewBag.Matriculas = new SelectList(db.Vehiculos, "Matricula", "Matricula");
            ViewBag.Serie = db.Series.ToList();

            List<VehiculoModel> vehiculos = (from v in db.Vehiculos where v.Matricula.Equals(Matriculas) select v).ToList();

            return View(vehiculos);
        }

        // GET: Vehiculo by Matricula
        // El parametro matricula es el "name" del input del formulario
        public ActionResult FindByMatricula(string matricula = "") {

            ViewBag.Serie = db.Series.ToList();

            List<VehiculoModel> vehiculos = (from v in db.Vehiculos where v.Matricula.Contains(matricula) select v).ToList();

            return View(vehiculos);
        }

        // GET: Vehiculo by Color
        public ActionResult FindByColor(string color) {


            ViewBag.Serie = db.Series.ToList();
            ViewBag.colores = (from v in db.Vehiculos select v.Color).Distinct().ToList();
            List<VehiculoModel> vehiculos = (from v in db.Vehiculos where v.Color.Equals(color) select v).ToList();

            return View(vehiculos);
        }

        public ActionResult FindByMarcaAndSerie(int idMarca = -1, int idSerie = -1) {

            ViewBag.Sere = db.Series.ToList();
            var vehiculos = new List<VehiculoModel>();

            if (idMarca != -1) {

                ViewBag.MarcasDropDown = new SelectList(db.Marcas, "ID", "Nombre", idMarca);
            } else {

                ViewBag.MarcasDropDown = new SelectList(db.Marcas, "ID", "Nombre");
            }

            if (idSerie != -1) {

                ViewBag.SeriesByMarcaDropDown = new SelectList(db.Series.Where(s => s.Marca.ID == idMarca), "ID", "Nombre", idSerie);
                vehiculos = db.Vehiculos.Where(v => v.Serie.ID == idSerie).ToList();
            }else {

                ViewBag.SeriesByMarcaDropDown = new SelectList(db.Series.Where(s => s.Marca.ID == idMarca), "ID", "Nombre");
            }

            return View(vehiculos);
        }

        public ActionResult Listado() {

 
            var listado = db.Database.SqlQuery<VehiculosDTO>("getSeriesVehiculos").ToList();

            return View(listado);
        }

        public ActionResult FindByColorProcedure(string Color = "") {

            ViewBag.Colores = db.Vehiculos.Select(v => new { Color = v.Color }).Distinct().ToList();
            ViewBag.Colores = new SelectList(ViewBag.Colores, "Color", "Color");
            var vehiculos = db.Database.SqlQuery<VehiculosDTO>("getVehiculosByColor @Color = {0}", Color).ToList();

            return View(vehiculos);
        }
    }

    public class VehiculosDTO {

        public int ID { get; set; }
        public string Marca { get; set; }
        public string Serie { get; set; }
        public string Matricula { get; set; }
        public string Color { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Practica01_ProductoComponenetes {
    public class ProductoRepo {

        TiendaDbConnection conn = new TiendaDbConnection();

        public List<Producto> getProductos() {

            return conn.Productos.Include("Componentes").ToList();
        }
    }
}
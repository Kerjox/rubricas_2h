using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Practica_Examen1 {
    public class OrdenadorRepo {

        public List<Ordenador> getOrdenadores() {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            return conn.Ordenadores.ToList();
        }

        public void InsertOrdenador(Ordenador ordenador) {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            conn.Ordenadores.Add(ordenador);
            conn.SaveChanges();
        }

        public void DeleteOrdenador(Ordenador ordenador) {

            OrdenadoresConnection conn = new OrdenadoresConnection();

            conn.Ordenadores.Remove(conn.Ordenadores.Find(ordenador.ID));
            conn.SaveChanges();
        }

        public void UpdateOrdenador(Ordenador ordenador) {

            OrdenadoresConnection conn = new OrdenadoresConnection();
            Ordenador ordenadorDB = conn.Ordenadores.Find(ordenador.ID);

            ordenadorDB.Marca = ordenador.Marca;
            ordenadorDB.Modelo = ordenador.Modelo;
            conn.SaveChanges();
        }
    }
}
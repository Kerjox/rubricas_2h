using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace UBALDE_DANIEL_AccesoADatos {
    public class RepoGeneral {

        public List<Marca> getMarcas() {

            ComponentesConnection conn = new ComponentesConnection();

            return conn.Marcas.ToList();
        }

        public List<ProductosPropios> getProductos() {

            ComponentesConnection conn = new ComponentesConnection();

            return conn.ProductosPropios.Include("Componentes").ToList();
        }

        public List<ComponenteMarca> getComponentesMarca() {

            String query = "SELECT m.Nombre as Marca, c.Nombre as Componente, c.NumUnidadesBolsa as Unidades, c.PrecioBolsa as Precio " +
                "FROM Marcas m INNER JOIN Componentes C on m.ID = C.Marca_ID;";

            string conectionString = ConfigurationManager.ConnectionStrings["ComponentesConnection"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                conn.Open();

                SqlCommand cmd = new SqlCommand(query, conn);

                SqlDataReader dataReader = cmd.ExecuteReader();

                DataTable dt = new DataTable();
                dt.Columns.Add("Marca");
                dt.Columns.Add("Componente");
                dt.Columns.Add("NumUnidades");
                dt.Columns.Add("PrecioTotal");
                dt.Columns.Add("PrecioUnitario");

                while (dataReader.Read()) {

                    DataRow row = dt.NewRow();
                    dt.Rows.Add(row);

                    row["Marca"] = Convert.ToString(dataReader["Marca"]);
                    row["Componente"] = Convert.ToString(dataReader["Componente"]);
                    row["NumUnidades"] = Convert.ToInt32(dataReader["Unidades"]);
                    row["PrecioTotal"] = Convert.ToInt32(dataReader["Precio"]);
                    row["PrecioUnitario"] = Convert.ToDouble(row["PrecioTotal"]) / Convert.ToDouble(row["NumUnidades"]);
                }

                conn.Close();

                List<ComponenteMarca> componnetesMarca = new List<ComponenteMarca>();

                foreach (DataRow row in dt.Rows) {

                    ComponenteMarca componenteMarca = new ComponenteMarca();

                    componenteMarca.Marca = row["Marca"].ToString();
                    componenteMarca.Componenete = row["Componente"].ToString();
                    componenteMarca.NumUnidades = Convert.ToInt32(row["NumUnidades"]);
                    componenteMarca.PrecioTotal = Convert.ToInt32(row["PrecioTotal"]);
                    componenteMarca.PrecioUnitario = Convert.ToDouble(row["PrecioUnitario"]);

                    componnetesMarca.Add(componenteMarca);
                }

                return componnetesMarca;
            }
        }
    }
}
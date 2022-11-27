using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Prueba_Inicial.App_Code {

    public class PersonaDataAccess {
        public static string String { get; private set; }

        public static List<Persona> getPersonas() {

            List<Persona> persons = new List<Persona>();

            String query = "SELECT * FROM personas";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                conn.Open();

                SqlCommand cmd = new SqlCommand(query, conn);

                SqlDataReader dataReader = cmd.ExecuteReader();

                while (dataReader.Read()) {

                    Persona person = new Persona();

                    person.ID = Convert.ToInt32(dataReader["id_persona"]);
                    person.Dni = Convert.ToString(dataReader["dni"]);
                    person.Nombre = Convert.ToString(dataReader["nombre"]);
                    person.Provincia = Convert.ToInt32(dataReader["provincia"]);
                    person.Date = Convert.ToDateTime(dataReader["date"]).ToShortDateString();
                    person.Sexo = Convert.ToString(dataReader["sexo"]);

                    persons.Add(person);
                }

                conn.Close();

                return persons;
            }
        }

        public static void insertPersonas(String Dni, String Nombre, UInt32 Provincia, String Date, String Sexo) {

            String query = "INSERT INTO Personas (dni, nombre, provincia, date, sexo) VALUES (@DNI, @NOMBRE, @PROVINCIA, @DATE, @SEXO)";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlCommand sql = new SqlCommand(query, conn);

                sql.Parameters.Add("@DNI", SqlDbType.NVarChar);
                sql.Parameters.Add("@NOMBRE", SqlDbType.NVarChar);
                sql.Parameters.Add("@PROVINCIA", SqlDbType.Int);
                sql.Parameters.Add("@DATE", SqlDbType.Date);
                sql.Parameters.Add("@SEXO", SqlDbType.Char);

                sql.Parameters["@DNI"].Value = Dni;
                sql.Parameters["@NOMBRE"].Value = Nombre;
                sql.Parameters["@PROVINCIA"].Value = Provincia;
                sql.Parameters["@DATE"].Value = Convert.ToDateTime(Date);
                sql.Parameters["@SEXO"].Value = Convert.ToChar(Sexo);

                try {
                    conn.Open();
                    Int32 rowsAffected = sql.ExecuteNonQuery();
                    Console.WriteLine("RowsAffected: {0}", rowsAffected);
                } catch (Exception ex) {

                    Console.WriteLine(ex.Message);
                } finally {

                    conn.Close();
                }
            }
        }

        public static void updatePersonas(UInt32 ID, String Dni, String Nombre, UInt32 Provincia, String Date, String Sexo) {

            String query = "UPDATE Personas SET dni = @DNI, nombre = @NOMBRE, provincia = @PROVINCIA, date = @DATE, sexo = @SEXO WHERE id_persona = @ID";


            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlCommand sql = new SqlCommand(query, conn);

                sql.Parameters.Add("@ID", SqlDbType.Int);
                sql.Parameters.Add("@DNI", SqlDbType.NVarChar);
                sql.Parameters.Add("@NOMBRE", SqlDbType.NVarChar);
                sql.Parameters.Add("@PROVINCIA", SqlDbType.Int);
                sql.Parameters.Add("@DATE", SqlDbType.Date);
                sql.Parameters.Add("@SEXO", SqlDbType.Char);

                sql.Parameters["@ID"].Value = ID;
                sql.Parameters["@DNI"].Value = Dni;
                sql.Parameters["@NOMBRE"].Value = Nombre;
                sql.Parameters["@PROVINCIA"].Value = Provincia;
                sql.Parameters["@DATE"].Value = Convert.ToDateTime(Date);
                sql.Parameters["@SEXO"].Value = Convert.ToChar(Sexo);

                try {
                    conn.Open();
                    Int32 rowsAffected = sql.ExecuteNonQuery();
                    Console.WriteLine("RowsAffected: {0}", rowsAffected);
                } catch (Exception ex) {

                    Console.WriteLine(ex.Message);
                } finally {

                    conn.Close();
                }
            }
        }

        public static void deletePersonas(UInt32 ID) {

            String query = "DELETE FROM Personas WHERE id_persona = @id";

            string conectionString = ConfigurationManager.ConnectionStrings["BBDD1"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(conectionString)) {

                SqlCommand sql = new SqlCommand(query, conn);

                sql.Parameters.Add("@id", SqlDbType.Int);
                sql.Parameters["@id"].Value = ID;

                try {
                    conn.Open();
                    Int32 rowsAffected = sql.ExecuteNonQuery();
                    Console.WriteLine("RowsAffected: {0}", rowsAffected);
                } catch (Exception ex) {

                    Console.WriteLine(ex.Message);
                } finally {

                    conn.Close();
                }
            }
        }

        public class Persona {

            public int ID { get; set; }
            public String Dni { get; set; }
            public String Nombre { get; set; }
            public int Provincia { get; set; }
            public String Date { get; set; }
            public String Sexo {
                get; set;
            }
        }

    }
}
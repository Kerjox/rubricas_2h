using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CampoCalculado {
    public partial class DobleDesplegable : System.Web.UI.Page {
        protected void Page_Load(object sender, EventArgs e) {

            if (!IsPostBack) {

                loadDropDownAlumnos();
            }
        }

        private void loadDropDownAlumnos() {

            UniversidadDBConnection conn = new UniversidadDBConnection();

            List<Alumno> alumnos = conn.Alumnos.ToList();

            AlumnoDD.Items.Add(new ListItem("---", "-1"));

            foreach (Alumno a in alumnos) {

                ListItem listItem = new ListItem(a.Nombre, a.ID.ToString());
                AlumnoDD.Items.Add(listItem);
            }
        }
        private void loadDropDownAsignaturas() {

            int SelectedAlumno = int.Parse(AlumnoDD.SelectedValue);

            if (SelectedAlumno == -1) { return; }

            UniversidadDBConnection conn = new UniversidadDBConnection();

            AsignaturaDD.Items.Clear();

            List<Asignatura> asignaturas = conn.Alumnos.Include("Asignaturas").FirstOrDefault(a => a.ID == SelectedAlumno).Asignaturas.ToList();

            AsignaturaDD.Items.Add(new ListItem("---", "-1"));

            foreach (Asignatura a in asignaturas) {

                ListItem listItem = new ListItem(a.Nombre, a.ID.ToString());
                AsignaturaDD.Items.Add(listItem);
            }
        }

        protected void AlumnoDD_SelectedIndexChanged(object sender, EventArgs e) {

            loadDropDownAsignaturas();
        }

        protected void AignaturaDD_SelectedIndexChanged(object sender, EventArgs e) {

            int AsignaturaSelected = int.Parse(AsignaturaDD.SelectedValue);

            if (AsignaturaSelected == -1) { return; }

            UniversidadDBConnection conn = new UniversidadDBConnection();

            DataTable dt = new DataTable();
            dt.Columns.Add(new DataColumn("ID"));
            dt.Columns.Add(new DataColumn("Nombre Asignatura"));
            dt.Columns.Add(new DataColumn("Creditos"));

            DataRow row = dt.NewRow();
            dt.Rows.Add(row);

            Asignatura asignatura = conn.Asignaturas.FirstOrDefault(a => a.ID == AsignaturaSelected);

            row["ID"] = asignatura.ID;
            row["Nombre Asignatura"] = asignatura.Nombre;
            row["Creditos"] = asignatura.Creditos;


            DetailsView1.DataSource = dt;
            DetailsView1.DataBind();
        }
    }
}
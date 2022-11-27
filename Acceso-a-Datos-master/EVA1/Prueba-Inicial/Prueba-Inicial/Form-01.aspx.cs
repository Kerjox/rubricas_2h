using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Prueba_Inicial
{
    public partial class Form_01 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) {
                List<ListItem> Listdeportes = new List<ListItem>();

                Listdeportes.Add(new ListItem("Furbol", "1"));
                Listdeportes.Add(new ListItem("Baloncesto", "2"));
                Listdeportes.Add(new ListItem("Tenis", "3"));

                dropDownDeportes.Items.AddRange(Listdeportes.ToArray());
            }
            
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            dropDownDeportes.Items.Add(new ListItem("BalonMano", "4"));
        }
    }
}
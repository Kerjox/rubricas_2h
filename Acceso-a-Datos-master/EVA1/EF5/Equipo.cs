//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace EF5
{
    using System;
    using System.Collections.Generic;
    
    public partial class Equipo
    {
        public Equipo()
        {
            this.Futbolistas = new HashSet<Futbolista>();
        }
    
        public int id { get; set; }
        public string nombre { get; set; }
    
        public virtual ICollection<Futbolista> Futbolistas { get; set; }
    }
}

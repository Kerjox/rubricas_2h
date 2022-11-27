using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Colegio_API.Migrations
{
    public partial class LocalizacionCurso : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Localizacion",
                table: "Cursos",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Localizacion",
                table: "Cursos");
        }
    }
}

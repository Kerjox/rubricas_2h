using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PruebaExamenCooperacionAPI.Migrations
{
    public partial class ActualizadosCampos3 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Proyectos_Paises_PaisID",
                table: "Proyectos");

            migrationBuilder.DropIndex(
                name: "IX_Proyectos_PaisID",
                table: "Proyectos");

            migrationBuilder.DropColumn(
                name: "PaisID",
                table: "Proyectos");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "PaisID",
                table: "Proyectos",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Proyectos_PaisID",
                table: "Proyectos",
                column: "PaisID");

            migrationBuilder.AddForeignKey(
                name: "FK_Proyectos_Paises_PaisID",
                table: "Proyectos",
                column: "PaisID",
                principalTable: "Paises",
                principalColumn: "ID");
        }
    }
}

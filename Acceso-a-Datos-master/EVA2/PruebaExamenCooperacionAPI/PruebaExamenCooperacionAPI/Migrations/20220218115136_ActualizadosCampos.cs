using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PruebaExamenCooperacionAPI.Migrations
{
    public partial class ActualizadosCampos : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "PaisID",
                table: "Destinatarios",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Destinatarios_PaisID",
                table: "Destinatarios",
                column: "PaisID");

            migrationBuilder.AddForeignKey(
                name: "FK_Destinatarios_Paises_PaisID",
                table: "Destinatarios",
                column: "PaisID",
                principalTable: "Paises",
                principalColumn: "ID");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Destinatarios_Paises_PaisID",
                table: "Destinatarios");

            migrationBuilder.DropIndex(
                name: "IX_Destinatarios_PaisID",
                table: "Destinatarios");

            migrationBuilder.DropColumn(
                name: "PaisID",
                table: "Destinatarios");
        }
    }
}

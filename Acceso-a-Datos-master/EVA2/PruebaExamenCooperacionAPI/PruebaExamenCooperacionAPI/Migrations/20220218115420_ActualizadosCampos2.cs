using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PruebaExamenCooperacionAPI.Migrations
{
    public partial class ActualizadosCampos2 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Destinatarios_Paises_PaisID",
                table: "Destinatarios");

            migrationBuilder.DropForeignKey(
                name: "FK_Proyectos_Paises_PaisID",
                table: "Proyectos");

            migrationBuilder.AlterColumn<int>(
                name: "PaisID",
                table: "Proyectos",
                type: "int",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<int>(
                name: "PaisID",
                table: "Destinatarios",
                type: "int",
                nullable: false,
                defaultValue: 0,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AddForeignKey(
                name: "FK_Destinatarios_Paises_PaisID",
                table: "Destinatarios",
                column: "PaisID",
                principalTable: "Paises",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Proyectos_Paises_PaisID",
                table: "Proyectos",
                column: "PaisID",
                principalTable: "Paises",
                principalColumn: "ID");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Destinatarios_Paises_PaisID",
                table: "Destinatarios");

            migrationBuilder.DropForeignKey(
                name: "FK_Proyectos_Paises_PaisID",
                table: "Proyectos");

            migrationBuilder.AlterColumn<int>(
                name: "PaisID",
                table: "Proyectos",
                type: "int",
                nullable: false,
                defaultValue: 0,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AlterColumn<int>(
                name: "PaisID",
                table: "Destinatarios",
                type: "int",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AddForeignKey(
                name: "FK_Destinatarios_Paises_PaisID",
                table: "Destinatarios",
                column: "PaisID",
                principalTable: "Paises",
                principalColumn: "ID");

            migrationBuilder.AddForeignKey(
                name: "FK_Proyectos_Paises_PaisID",
                table: "Proyectos",
                column: "PaisID",
                principalTable: "Paises",
                principalColumn: "ID",
                onDelete: ReferentialAction.Cascade);
        }
    }
}

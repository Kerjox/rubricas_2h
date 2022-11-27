using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PruebaExamenCooperacionAPI.Migrations
{
    public partial class A : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Direccion",
                table: "Destinatarios",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Direccion",
                table: "Destinatarios");
        }
    }
}

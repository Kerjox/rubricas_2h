using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PruebaExamenCooperacionAPI.Migrations
{
    public partial class AnadidoscamposFotoURL : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "BanderaURL",
                table: "Paises",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "FotoURL",
                table: "Odses",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "BanderaURL",
                table: "Paises");

            migrationBuilder.DropColumn(
                name: "FotoURL",
                table: "Odses");
        }
    }
}

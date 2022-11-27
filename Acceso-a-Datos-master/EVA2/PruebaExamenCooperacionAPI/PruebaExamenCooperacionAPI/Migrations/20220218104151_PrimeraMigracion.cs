using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace PruebaExamenCooperacionAPI.Migrations
{
    public partial class PrimeraMigracion : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Destinatarios",
                columns: table => new
                {
                    ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    NombreDestinatario = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Destinatarios", x => x.ID);
                });

            migrationBuilder.CreateTable(
                name: "Odses",
                columns: table => new
                {
                    ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    NombreOds = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Odses", x => x.ID);
                });

            migrationBuilder.CreateTable(
                name: "Paises",
                columns: table => new
                {
                    ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    NombrePais = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Paises", x => x.ID);
                });

            migrationBuilder.CreateTable(
                name: "Proyectos",
                columns: table => new
                {
                    ID = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    nombreProyecto = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    PaisID = table.Column<int>(type: "int", nullable: false),
                    DestinatarioID = table.Column<int>(type: "int", nullable: false),
                    OdsID = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Proyectos", x => x.ID);
                    table.ForeignKey(
                        name: "FK_Proyectos_Destinatarios_DestinatarioID",
                        column: x => x.DestinatarioID,
                        principalTable: "Destinatarios",
                        principalColumn: "ID",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Proyectos_Odses_OdsID",
                        column: x => x.OdsID,
                        principalTable: "Odses",
                        principalColumn: "ID",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Proyectos_Paises_PaisID",
                        column: x => x.PaisID,
                        principalTable: "Paises",
                        principalColumn: "ID",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Proyectos_DestinatarioID",
                table: "Proyectos",
                column: "DestinatarioID");

            migrationBuilder.CreateIndex(
                name: "IX_Proyectos_OdsID",
                table: "Proyectos",
                column: "OdsID");

            migrationBuilder.CreateIndex(
                name: "IX_Proyectos_PaisID",
                table: "Proyectos",
                column: "PaisID");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Proyectos");

            migrationBuilder.DropTable(
                name: "Destinatarios");

            migrationBuilder.DropTable(
                name: "Odses");

            migrationBuilder.DropTable(
                name: "Paises");
        }
    }
}

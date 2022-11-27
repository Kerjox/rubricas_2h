<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CursosAlumnos.aspx.cs" Inherits="ColegioMapeo.CursosAlumnos" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="ObjectDataSource1">
                <Columns>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="NomCurso" HeaderText="Curso" SortExpression="Nombre"></asp:BoundField>
                    <asp:TemplateField HeaderText="Alumnos">
                        <ItemTemplate>
                            <asp:GridView ID="GridView2" runat="server" DataSource='<%# Eval("Alumnos") %>'>
                            </asp:GridView>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" SelectMethod="GetCursos" TypeName="ColegioMapeo.AlumnosRepo"></asp:ObjectDataSource>
        </div>
    </form>
</body>
</html>

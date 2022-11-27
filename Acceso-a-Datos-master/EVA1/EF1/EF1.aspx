<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EF1.aspx.cs" Inherits="EF1.EF1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="id" DataSourceID="EntityDataSource1">
                <Columns>
                    <asp:BoundField DataField="nombre" HeaderText="Curso" SortExpression="nombre"></asp:BoundField>
                    <asp:TemplateField HeaderText="Alumnos">
                        <ItemTemplate>
                            <asp:GridView ID="GridView2" runat="server" DataSource='<%# Eval("Alumnos") %>'>
                            </asp:GridView>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
            <asp:EntityDataSource ID="EntityDataSource1" runat="server" ConnectionString="name=ColegioEF1Connection" DefaultContainerName="ColegioEF1Connection" EnableFlattening="False" EntitySetName="Cursos" Include="Alumnos">
            </asp:EntityDataSource>
        </div>
    </form>
</body>
</html>

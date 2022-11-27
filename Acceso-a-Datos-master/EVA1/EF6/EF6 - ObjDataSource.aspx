<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EF6 - ObjDataSource.aspx.cs" Inherits="EF6.EF6" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" DataSourceID="ObjectDataSource1" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre" />
                    <asp:TemplateField HeaderText="Equipo">
                        <ItemTemplate>
                            <asp:GridView ID="GridView2" runat="server" DataSource='<%# Eval("Futbolistas") %>'>
                            </asp:GridView>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>

            <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px" DataSourceID="ObjectDataSource1" AutoGenerateRows="False">
                <Fields>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID" />
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre" />
                    <asp:CommandField ShowInsertButton="True"></asp:CommandField>
                </Fields>
            </asp:DetailsView>
            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" SelectMethod="GetEquipos" TypeName="EF6.EquipoRepo" DataObjectTypeName="EF6.Equipo" InsertMethod="Insert"></asp:ObjectDataSource>
            <asp:Button ID="Button1" runat="server" Text="Insertar" OnClick="Button1_Click"/>
            <asp:Button ID="Button2" runat="server" Text="Borrar" OnClick="Button2_Click"/>
        </div>
    </form>
</body>
</html>

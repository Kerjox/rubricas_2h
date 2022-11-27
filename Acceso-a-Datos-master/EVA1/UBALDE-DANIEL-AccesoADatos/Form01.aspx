<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form01.aspx.cs" Inherits="UBALDE_DANIEL_AccesoADatos.Form01" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <br />
            <br />

            <!-- Primer Ejercicio -->
            <asp:GridView ID="MarcasGridView" runat="server" DataSourceID="MarcasObjectDataSource" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                </Columns>
            </asp:GridView>
            <asp:GridView ID="ProductosGridView" runat="server" DataSourceID="ProductosObjectDataSource" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Precio" HeaderText="Precio" SortExpression="Precio"></asp:BoundField>
                </Columns>
            </asp:GridView>

            <asp:ObjectDataSource ID="MarcasObjectDataSource" runat="server" SelectMethod="getMarcas" TypeName="UBALDE_DANIEL_AccesoADatos.RepoGeneral"></asp:ObjectDataSource>
            <asp:ObjectDataSource ID="ProductosObjectDataSource" runat="server" SelectMethod="getProductos" TypeName="UBALDE_DANIEL_AccesoADatos.RepoGeneral"></asp:ObjectDataSource>
            <br />
            <br />

            <!-- Según Ejercicio -->

            <asp:GridView ID="ComponentesMarca" runat="server" AutoGenerateColumns="False" DataSourceID="ComponentesMarcaObjectDataSource">
                <Columns>
                    <asp:BoundField DataField="Marca" HeaderText="Marca" SortExpression="Marca"></asp:BoundField>
                    <asp:BoundField DataField="Componenete" HeaderText="Componenete" SortExpression="Componenete"></asp:BoundField>
                    <asp:BoundField DataField="NumUnidades" HeaderText="NumUnidades" SortExpression="NumUnidades"></asp:BoundField>
                    <asp:BoundField DataField="PrecioTotal" HeaderText="PrecioTotal" SortExpression="PrecioTotal"></asp:BoundField>
                    <asp:BoundField DataField="PrecioUnitario" HeaderText="PrecioUnitario" SortExpression="PrecioUnitario"></asp:BoundField>
                </Columns>
            </asp:GridView>
            <asp:ObjectDataSource ID="ComponentesMarcaObjectDataSource" runat="server" SelectMethod="getComponentesMarca" TypeName="UBALDE_DANIEL_AccesoADatos.RepoGeneral"></asp:ObjectDataSource>
            <br />
            <br />

            <!-- Tercer Ejercicio -->

            <asp:GridView ID="ProductoComponentesGridView" runat="server" DataSourceID="ProductoComponentesObjectDataSource" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Precio" HeaderText="Precio" SortExpression="Precio"></asp:BoundField>
                    <asp:TemplateField HeaderText="Componentes">
                        <ItemTemplate>
                            <asp:GridView ID="GridView1" runat="server" DataSource='<%# Eval("Componentes") %>'>
                            </asp:GridView>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
            <asp:ObjectDataSource ID="ProductoComponentesObjectDataSource" runat="server" SelectMethod="getProductos" TypeName="UBALDE_DANIEL_AccesoADatos.RepoGeneral"></asp:ObjectDataSource>
            <br />
            <br />

            <!-- Cuarto Ejercicio -->

            <asp:DropDownList ID="ProductosDropDownList" runat="server"></asp:DropDownList>
            <asp:DropDownList ID="ComponentesDropDownList" runat="server"></asp:DropDownList>

            <asp:Button ID="InsertarComponenteAProducto" runat="server" Text="Insertar" OnClick="InsertarComponenteAProducto_Click"/>
            <asp:Button ID="BorrarComponenteDeProducto" runat="server" Text="Borrar" OnClick="BorrarComponenteDeProducto_Click"/>

        </div>
    </form>
</body>
</html>

<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form1.aspx.cs" Inherits="EF4.Form1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="ObjectDataSource1" DataKeyNames="ID">
                <Columns>
                    <asp:CommandField ShowEditButton="True" ShowDeleteButton="True"></asp:CommandField>
                    <asp:BoundField DataField="ID" InsertVisible="false" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Apellido" HeaderText="Apellido" SortExpression="Apellido"></asp:BoundField>
                    <asp:BoundField DataField="Genero" HeaderText="Genero" SortExpression="Genero"></asp:BoundField>
                    <asp:BoundField DataField="Edad" HeaderText="Edad" SortExpression="Edad"></asp:BoundField>
                </Columns>
            </asp:GridView>
            <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px" AutoGenerateRows="False" DataSourceID="ObjectDataSource1">
                <Fields>
                    <asp:BoundField DataField="ID" InsertVisible="false" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Apellido" HeaderText="Apellido" SortExpression="Apellido"></asp:BoundField>
                    <asp:BoundField DataField="Genero" HeaderText="Genero" SortExpression="Genero"></asp:BoundField>
                    <asp:BoundField DataField="Edad" HeaderText="Edad" SortExpression="Edad"></asp:BoundField>
                    <asp:CommandField ShowInsertButton="True"></asp:CommandField>
                </Fields>
            </asp:DetailsView>
            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DataObjectTypeName="EF4.Alumno" DeleteMethod="delete" InsertMethod="insert" SelectMethod="findAll" TypeName="EF4.AlumnoRepo" UpdateMethod="update"></asp:ObjectDataSource>
        </div>
    </form>
</body>
</html>

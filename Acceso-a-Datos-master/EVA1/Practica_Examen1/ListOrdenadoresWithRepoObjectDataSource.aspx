<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ListOrdenadoresWithRepoObjectDataSource.aspx.cs" Inherits="Practica_Examen1.ListOrdenadoresWithRepoObjectDataSource" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" DataSourceID="ObjectDataSource1" AutoGenerateColumns="False" ShowFooter="true" DataKeyNames="ID">
                <Columns>
                    <asp:CommandField ShowEditButton="True" ShowDeleteButton="True"></asp:CommandField>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Marca" HeaderText="Marca" SortExpression="Marca"></asp:BoundField>
                    <asp:BoundField DataField="Modelo" HeaderText="Modelo" SortExpression="Modelo"></asp:BoundField>
                </Columns>
            </asp:GridView>

            <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px" AutoGenerateRows="False" DataSourceID="ObjectDataSource1">
                <Fields>
                    <asp:BoundField DataField="ID" HeaderText="ID" SortExpression="ID"></asp:BoundField>
                    <asp:BoundField DataField="Marca" HeaderText="Marca" SortExpression="Marca"></asp:BoundField>
                    <asp:BoundField DataField="Modelo" HeaderText="Modelo" SortExpression="Modelo"></asp:BoundField>
                    <asp:CommandField ShowInsertButton="True"></asp:CommandField>
                </Fields>
            </asp:DetailsView>
            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DataObjectTypeName="Practica_Examen1.Ordenador" DeleteMethod="DeleteOrdenador" InsertMethod="InsertOrdenador" SelectMethod="getOrdenadores" TypeName="Practica_Examen1.OrdenadorRepo" UpdateMethod="UpdateOrdenador">
                <InsertParameters>
                    <asp:Parameter Name="marca" Type="String"></asp:Parameter>
                    <asp:Parameter Name="modelo" Type="String"></asp:Parameter>
                </InsertParameters>
            </asp:ObjectDataSource>
        </div>
    </form>
</body>
</html>

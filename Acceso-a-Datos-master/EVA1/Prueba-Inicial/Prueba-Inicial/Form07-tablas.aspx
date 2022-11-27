<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form07-tablas.aspx.cs" Inherits="Prueba_Inicial.Form07_tablas" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>getProvinciasPlusPersonas</title>
<link href="~/lib/twitter-bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <br />
            <asp:GridView class="table table-striped" ID="gvPersonas" runat="server" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="id_persona" HeaderText="id" />
                    <asp:BoundField DataField="dni" HeaderText="dni" />
                    <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                    <asp:BoundField DataField="provincia" HeaderText="Provincia" />
                </Columns>
            </asp:GridView>
            <br />

            <asp:GridView class="table table-striped" ID="gvProvincias" runat="server" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="id_provincia" HeaderText="id" />
                    <asp:BoundField DataField="nombre" HeaderText="Provincia" />
                </Columns>
            </asp:GridView>
            <br />

            <asp:GridView class="table table-striped" ID="gvInnerJoin" runat="server" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="id_persona" HeaderText="id" />
                    <asp:BoundField DataField="dni" HeaderText="dni" />
                    <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                    <asp:BoundField DataField="nombre1" HeaderText="Provincia" />
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>

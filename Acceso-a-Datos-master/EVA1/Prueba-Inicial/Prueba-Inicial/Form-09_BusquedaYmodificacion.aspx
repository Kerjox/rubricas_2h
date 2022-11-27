<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-09_BusquedaYmodificacion.aspx.cs" Inherits="Prueba_Inicial.Form_09" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="~/lib/twitter-bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <title>Formulario Actualización</title>
</head>
<body>
    <div class="container">
        <form id="form1" runat="server">
            <div>
                <table border="1">
                    <tr>
                        <td>Código: </td>
                        <td>
                            <asp:TextBox ID="personTextBox" runat="server"></asp:TextBox>
                        </td>
                        <td>
                            <asp:Button class="btn btn-primary" ID="searchButton" runat="server" Text="Search" AutoPostBack="true" OnClick="searchButton_Click" /></td>
                    </tr>
                    <tr>
                        <td>DNI: </td>
                        <td>
                            <asp:TextBox ID="dni" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td>
                            <asp:TextBox ID="name" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>Provincia: </td>
                        <td>
                            <asp:TextBox ID="country" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td>Fecha Nacimiento: </td>
                        <td>
                            <asp:TextBox ID="date" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <asp:Button class="btn btn-primary" ID="updateButton" runat="server" Text="Update" AutoPostBack="true" OnClick="updateButton_Click" />
                            <asp:Label ID="msg" runat="server" Text=""></asp:Label>
                        </td>

                    </tr>
                </table>

            </div>
        </form>
    </div>
</body>
</html>

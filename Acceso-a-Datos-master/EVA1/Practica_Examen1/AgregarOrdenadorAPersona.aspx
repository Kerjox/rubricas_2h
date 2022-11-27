<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AgregarOrdenadorAPersona.aspx.cs" Inherits="Practica_Examen1.AgregarOrdenadorAPersona" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server"></asp:GridView>

            <asp:DropDownList ID="OrdenadoresDD" runat="server"></asp:DropDownList>
            <asp:DropDownList ID="PersonasDD" runat="server"></asp:DropDownList>

            <asp:Button ID="Insert" runat="server" Text="Insertar" OnClick="Insert_Click"/>
            <asp:Button ID="Delete" runat="server" Text="Delete" OnClick="Delete_Click" />
        </div>
    </form>
</body>
</html>

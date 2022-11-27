<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EF6 - C.aspx.cs" Inherits="EF6.EF6___C" %>

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
            <asp:Button ID="Button1" runat="server" Text="Insertar" OnClick="Button1_Click"/>
            <asp:Button ID="Button2" runat="server" Text="Borrar" OnClick="Button2_Click"/>
        </div>
    </form>
</body>
</html>

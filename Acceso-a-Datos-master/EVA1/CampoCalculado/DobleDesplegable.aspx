<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DobleDesplegable.aspx.cs" Inherits="CampoCalculado.DobleDesplegable" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:DropDownList ID="AlumnoDD" runat="server" AutoPostBack="true" OnSelectedIndexChanged="AlumnoDD_SelectedIndexChanged"></asp:DropDownList>
            <asp:DropDownList ID="AsignaturaDD" runat="server" AutoPostBack="true" OnSelectedIndexChanged="AignaturaDD_SelectedIndexChanged"></asp:DropDownList>

            <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px"></asp:DetailsView>
        </div>
    </form>
</body>
</html>

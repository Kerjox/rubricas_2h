<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-08_Personas.aspx.cs" Inherits="Prueba_Inicial.Form_08_Personas" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
<link href="~/lib/twitter-bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <form id="form1" runat="server">
        <div class="constainer">
            <br />
            <div>
                <asp:GridView class="table table-striped" ID="gvPersonas" runat="server" OnRowDataBound="gvPersonas_RowDataBound"></asp:GridView>
            </div>
        </div>
    </form>
</body>
</html>

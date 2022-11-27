<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="FORM-06_.aspx.cs" Inherits="Prueba_Inicial.FORM_06_" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="~/lib/twitter-bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <title>GetMetaData</title>
</head>
<body>
    <form id="form1" runat="server">
        <div class="container">
            <br/>
            <asp:DropDownList
                class="form-select"
                ID="DropDownTables" 
                runat="server" 
                AutoPostBack="true" 
                OnSelectedIndexChanged="DropDownTables_SelectedIndexChanged"></asp:DropDownList>
            <br/>
            <asp:GridView class="table table-striped" ID="GridView1" runat="server" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="COLUMN_NAME" HeaderText="Nombre Campo" />
                    <asp:BoundField DataField="DATA_TYPE" HeaderText="Tipo Dato" />
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>

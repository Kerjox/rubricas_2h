<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-03.aspx.cs" Inherits="Prueba_Inicial.Form_02" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:AccessDataSource ID="alumnosRow" runat="server"
                SelectCommand="SELECT [Nome], [foto] FROM [Alunos]"
                DataSourceMode="DataReader" DataFile="~/App_Data/TablasEscuelaEmpresa.mdb"></asp:AccessDataSource>

            <asp:GridView ID="GridView1" runat="server" DataSourceID="alumnosRow" AutoGenerateColumns="False">
                <Columns>
                    <asp:BoundField DataField="Nome" HeaderText="Nome" SortExpression="Nome"></asp:BoundField>
                    <asp:ImageField DataImageUrlField="foto" DataImageUrlFormatString="fotos/{0}"></asp:ImageField>
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>

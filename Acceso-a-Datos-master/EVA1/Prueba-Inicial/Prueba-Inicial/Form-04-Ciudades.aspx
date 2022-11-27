<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-04-Ciudades.aspx.cs" Inherits="Prueba_Inicial.Form_05_Ciudades" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:AccessDataSource ID="localRow" runat="server"
                SelectCommand="SELECT [nom_local], [cod_local] FROM [Locals]"
                DataSourceMode="DataReader"
                DataFile="~/App_Data/TablasEscuelaEmpresa.mdb"></asp:AccessDataSource>

            <asp:AccessDataSource ID="alumnosRow" runat="server"
                SelectCommand="SELECT [cod_aluno], [Nome], [cod_cidade], [foto] FROM [Alunos]"
                DataFile="~/App_Data/TablasEscuelaEmpresa.mdb"
                FilterExpression="cod_cidade = '{0}'">
                <FilterParameters>
                    <asp:ControlParameter ControlID="ddCiudades" PropertyName="SelectedValue"/>
                </FilterParameters>
            </asp:AccessDataSource>

            <asp:DropDownList ID="ddCiudades"
                runat="server"
                DataSourceID="localRow"
                DataValueField="cod_local"
                DataTextField="nom_local"
                AutoPostBack="true">
            </asp:DropDownList>
                
            <asp:GridView ID="GridView1" runat="server" DataSourceID="alumnosRow" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="cod_aluno" HeaderText="cod_aluno" ReadOnly="True" SortExpression="cod_aluno"></asp:BoundField>
                    <asp:BoundField DataField="Nome" HeaderText="Nome" SortExpression="Nome"></asp:BoundField>
                    <asp:BoundField DataField="cod_cidade" HeaderText="cod_cidade" SortExpression="cod_cidade"></asp:BoundField>
                    <asp:ImageField DataImageUrlField="foto" DataImageUrlFormatString="fotos/{0}"></asp:ImageField>
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>

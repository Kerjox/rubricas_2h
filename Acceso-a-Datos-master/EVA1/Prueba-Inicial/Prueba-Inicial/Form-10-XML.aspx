<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-10-XML.aspx.cs" Inherits="Prueba_Inicial.Form_10_XML" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="XmlDataSource1">
                <Columns>
                    <asp:BoundField DataField="id" HeaderText="id" SortExpression="id"></asp:BoundField>
                    <asp:BoundField DataField="dni" HeaderText="dni" SortExpression="dni"></asp:BoundField>
                    <asp:BoundField DataField="nombre" HeaderText="nombre" SortExpression="nombre"></asp:BoundField>
                    <asp:BoundField DataField="provincia" HeaderText="provincia" SortExpression="provincia"></asp:BoundField>
                </Columns>
            </asp:GridView>

            <asp:GridView ID="GridView2" runat="server" DataSourceID="XmlDataSource2"></asp:GridView>

            <asp:GridView ID="GridView3" runat="server"></asp:GridView>

            <asp:XmlDataSource ID="XmlDataSource1" runat="server" DataFile="~/Datos/Datos.xml"></asp:XmlDataSource>
            <asp:XmlDataSource ID="XmlDataSource2" runat="server" DataFile="~/Datos/Datos2.xml" TransformFile="~/Datos/datos2-trans.xslt"></asp:XmlDataSource>
        </div>
    </form>
</body>
</html>

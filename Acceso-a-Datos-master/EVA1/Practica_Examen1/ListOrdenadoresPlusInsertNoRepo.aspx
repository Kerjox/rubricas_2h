<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ListOrdenadoresPlusInsertNoRepo.aspx.cs" Inherits="Practica_Examen1.ListOrdenadores" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" ShowFooter="True">
                <Columns>
                    <asp:TemplateField HeaderText="ID">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("ID") %>' ID="TextBox1"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("ID") %>' ID="Label1"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:Button ID="insertButton" runat="server" Text="Insertar" OnClick="insertButton_Click"></asp:Button>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Marca">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Marca") %>' ID="TextBox2"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Marca") %>' ID="Label2"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="marca" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Modelo">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Modelo") %>' ID="TextBox3"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Modelo") %>' ID="Label3"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="modelo" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </form>
</body>
</html>

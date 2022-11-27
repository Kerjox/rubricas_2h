<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-13-InsertDeleteEdit.aspx.cs" Inherits="Prueba_Inicial.Form_13_InsertDeleteEdit" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" ShowFooter="True" AutoGenerateColumns="False" DataKeyNames="ID" CellPadding="4" DataSourceID="ObjectDataSource1" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True"></asp:CommandField>
                    <asp:TemplateField HeaderText="ID" SortExpression="ID">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("ID") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label1" runat="server" Text='<%# Bind("ID") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:Button ID="insertButton" runat="server" Text="Insertar" OnClick="insertButton_Click"></asp:Button>
                        </FooterTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Dni" SortExpression="Dni">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox2" runat="server" Text='<%# Bind("dni") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label2" runat="server" Text='<%# Bind("dni") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="dni" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Nombre" SortExpression="Nombre">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox3" runat="server" Text='<%# Bind("nombre") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label3" runat="server" Text='<%# Bind("nombre") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="nombre" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Provincia" SortExpression="Provincia">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox4" runat="server" Text='<%# Bind("provincia") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label4" runat="server" Text='<%# Bind("provincia") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="Provincia" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Date" SortExpression="Date">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox5" runat="server" Text='<%# Bind("date") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label5" runat="server" Text='<%# Bind("date") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="Date" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Sexo" SortExpression="Sexo">
                        <EditItemTemplate>
                            <asp:DropDownList ID="TextBox6" runat="server" SelectedValue='<%# Bind("sexo") %>'>
                                <asp:ListItem Value="" Text="---"></asp:ListItem>
                                <asp:ListItem Value="H" Text="Hombre"></asp:ListItem>
                                <asp:ListItem Value="M" Text="Mujer"></asp:ListItem>
                            </asp:DropDownList>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label6" runat="server" Text='<%# Bind("sexo") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:DropDownList ID="sexo" runat="server">
                                <asp:ListItem Value="" Text="---"></asp:ListItem>
                                <asp:ListItem Value="H" Text="Hombre"></asp:ListItem>
                                <asp:ListItem Value="M" Text="Mujer"></asp:ListItem>
                            </asp:DropDownList>
                        </FooterTemplate>
                    </asp:TemplateField>

                </Columns>
                <EditRowStyle BackColor="#999999" />
                <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
                <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                <SortedAscendingCellStyle BackColor="#E9E7E2" />
                <SortedAscendingHeaderStyle BackColor="#506C8C" />
                <SortedDescendingCellStyle BackColor="#FFFDF8" />
                <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
            </asp:GridView>

            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" SelectMethod="getPersonas" TypeName="Prueba_Inicial.App_Code.PersonaDataAccess" InsertMethod="insertPersonas" DeleteMethod="deletePersonas" UpdateMethod="updatePersonas">
                <DeleteParameters>
                    <asp:Parameter Name="ID" Type="UInt32"></asp:Parameter>
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="provincia" Type="UInt32"></asp:Parameter>
                    <asp:Parameter Name="date" Type="String"></asp:Parameter>
                    <asp:Parameter Name="sexo" Type="String"></asp:Parameter>
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="ID" Type="UInt32"></asp:Parameter>
                    <asp:Parameter Name="dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="provincia" Type="UInt32"></asp:Parameter>
                    <asp:Parameter Name="date" Type="String"></asp:Parameter>
                    <asp:Parameter Name="sexo" Type="String"></asp:Parameter>
                </UpdateParameters>
            </asp:ObjectDataSource>
        </div>
    </form>
</body>
</html>

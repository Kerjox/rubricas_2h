<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Pruebas.aspx.cs" Inherits="Prueba_Inicial.Pruebas" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" ShowFooter="True" AutoGenerateColumns="False" DataSourceID="ObjectDataSource1" DataKeyNames="ID" BackColor="White" BorderColor="#3366CC" BorderStyle="None" BorderWidth="1px" CellPadding="4">
                <Columns>
                    <asp:CommandField ShowEditButton="True" ShowDeleteButton="True"></asp:CommandField>
                    <asp:TemplateField HeaderText="ID" SortExpression="ID">
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
                    <asp:TemplateField HeaderText="Dni" SortExpression="Dni">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Dni") %>' ID="TextBox2"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Dni") %>' ID="Label2"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="DNI_TextBox" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Nombre" SortExpression="Nombre">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Nombre") %>' ID="TextBox3"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Nombre") %>' ID="Label3"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="Nombre_TextBox" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Provincia" SortExpression="Provincia">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Provincia") %>' ID="TextBox4"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Provincia") %>' ID="Label4"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="Provicia_TextBox" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Date" SortExpression="Date">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Date") %>' ID="TextBox5"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Date") %>' ID="Label5"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="Date_TextBox" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Sexo" SortExpression="Sexo">
                        <EditItemTemplate>
                            <asp:TextBox runat="server" Text='<%# Bind("Sexo") %>' ID="TextBox6"></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label runat="server" Text='<%# Bind("Sexo") %>' ID="Label6"></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:DropDownList ID="Seso_DropDown" runat="server">
                                <asp:ListItem Text="M" Value="M"></asp:ListItem>
                                <asp:ListItem Text="H" Value="H"></asp:ListItem>
                            </asp:DropDownList>
                        </FooterTemplate>
                    </asp:TemplateField>

                </Columns>
                <FooterStyle BackColor="#99CCCC" ForeColor="#003399" />
                <HeaderStyle BackColor="#003399" Font-Bold="True" ForeColor="#CCCCFF" />
                <PagerStyle BackColor="#99CCCC" ForeColor="#003399" HorizontalAlign="Left" />
                <RowStyle BackColor="White" ForeColor="#003399" />
                <SelectedRowStyle BackColor="#009999" Font-Bold="True" ForeColor="#CCFF99" />
                <SortedAscendingCellStyle BackColor="#EDF6F6" />
                <SortedAscendingHeaderStyle BackColor="#0D4AC4" />
                <SortedDescendingCellStyle BackColor="#D6DFDF" />
                <SortedDescendingHeaderStyle BackColor="#002876" />
            </asp:GridView>
            <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DeleteMethod="deletePersonas" InsertMethod="insertPersonas" SelectMethod="getPersonas" TypeName="Prueba_Inicial.App_Code.PersonaDataAccess" UpdateMethod="updatePersonas">
                <DeleteParameters>
                    <asp:Parameter Name="ID" Type="UInt32"></asp:Parameter>
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="Dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="Nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="Provincia" Type="UInt32"></asp:Parameter>
                    <asp:Parameter Name="Date" Type="String"></asp:Parameter>
                    <asp:Parameter Name="Sexo" Type="String"></asp:Parameter>
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="ID" Type="UInt32"></asp:Parameter>
                    <asp:Parameter Name="Dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="Nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="Provincia" Type="UInt32"></asp:Parameter>
                    <asp:Parameter Name="Date" Type="String"></asp:Parameter>
                    <asp:Parameter Name="Sexo" Type="String"></asp:Parameter>
                </UpdateParameters>
            </asp:ObjectDataSource>
        </div>
    </form>
</body>
</html>

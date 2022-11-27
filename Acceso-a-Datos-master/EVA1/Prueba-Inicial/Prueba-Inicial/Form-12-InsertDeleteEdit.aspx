<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Form-12-InsertDeleteEdit.aspx.cs" Inherits="Prueba_Inicial.Form_12_InsertSexo" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" ShowFooter="true" AutoGenerateColumns="False" CellPadding="4" DataKeyNames="id_persona" DataSourceID="SqlDataSource1" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                    <asp:TemplateField HeaderText="ID" InsertVisible="False" SortExpression="id_persona">
                        <EditItemTemplate>
                            <asp:Label ID="Label1" runat="server" Text='<%# Eval("id_persona") %>'></asp:Label>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label1" runat="server" Text='<%# Bind("id_persona") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:Button ID="insertButton" runat="server" Text="Insertar" OnClick="insertButton_Click"></asp:Button>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="dni" SortExpression="dni">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("dni") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label2" runat="server" Text='<%# Bind("dni") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="dni" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="nombre" SortExpression="nombre">
                        <EditItemTemplate>
                            <asp:TextBox ID="TextBox2" runat="server" Text='<%# Bind("nombre") %>'></asp:TextBox>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label3" runat="server" Text='<%# Bind("nombre") %>'></asp:Label>
                        </ItemTemplate>
                        <FooterTemplate>
                            <asp:TextBox ID="nombre" runat="server"></asp:TextBox>
                        </FooterTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="sexo" SortExpression="sexo">
                        <EditItemTemplate>
                            <asp:DropDownList ID="TextBox3" runat="server" SelectedValue='<%# Bind("sexo") %>'>
                                <asp:ListItem Value="" Text="---"></asp:ListItem>
                                <asp:ListItem Value="H" Text="Hombre"></asp:ListItem>
                                <asp:ListItem Value="M" Text="Mujer"></asp:ListItem>
                            </asp:DropDownList>
                        </EditItemTemplate>
                        <ItemTemplate>
                            <asp:Label ID="Label4" runat="server" Text='<%# Bind("sexo") %>'></asp:Label>
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
            
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConflictDetection="CompareAllValues" ConnectionString='<%$ ConnectionStrings:01-ExampleConnectionString %>' 
                DeleteCommand="DELETE FROM [personas] WHERE [id_persona] = @original_id_persona AND [dni] = @original_dni AND [nombre] = @original_nombre AND (([sexo] = @original_sexo) OR ([sexo] IS NULL AND @original_sexo IS NULL))" 
                InsertCommand="INSERT INTO [personas] ([dni], [nombre], [sexo]) VALUES (@dni, @nombre, @sexo)" 
                OldValuesParameterFormatString="original_{0}" 
                SelectCommand="SELECT [id_persona], [dni], [nombre], [sexo] FROM [personas]" 
                UpdateCommand="UPDATE [personas] SET [dni] = @dni, [nombre] = @nombre, [sexo] = @sexo WHERE [id_persona] = @original_id_persona AND [dni] = @original_dni AND [nombre] = @original_nombre AND (([sexo] = @original_sexo) OR ([sexo] IS NULL AND @original_sexo IS NULL))">
                <DeleteParameters>
                    <asp:Parameter Name="original_id_persona" Type="Int32"></asp:Parameter>
                    <asp:Parameter Name="original_dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="original_nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="original_sexo" Type="String"></asp:Parameter>
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="sexo" Type="String"></asp:Parameter>
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="sexo" Type="String"></asp:Parameter>
                    <asp:Parameter Name="original_id_persona" Type="Int32"></asp:Parameter>
                    <asp:Parameter Name="original_dni" Type="String"></asp:Parameter>
                    <asp:Parameter Name="original_nombre" Type="String"></asp:Parameter>
                    <asp:Parameter Name="original_sexo" Type="String"></asp:Parameter>
                </UpdateParameters>
            </asp:SqlDataSource>
        </div>
    </form>
</body>
</html>

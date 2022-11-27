<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Entity3.aspx.cs" Inherits="EF3.Entity3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="ID" DataSourceID="EntityDataSource1" BackColor="White" BorderColor="#3366CC" BorderStyle="None" BorderWidth="1px" CellPadding="4">
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Apellido" HeaderText="Apellido" SortExpression="Apellido"></asp:BoundField>
                    <asp:BoundField DataField="Sexo" HeaderText="Sexo" SortExpression="Sexo"></asp:BoundField>
                    <asp:BoundField DataField="Edad" HeaderText="Edad" SortExpression="Edad"></asp:BoundField>
                </Columns>
                <FooterStyle BackColor="#99CCCC" ForeColor="#003399"></FooterStyle>

                <HeaderStyle BackColor="#003399" Font-Bold="True" ForeColor="#CCCCFF"></HeaderStyle>

                <PagerStyle HorizontalAlign="Left" BackColor="#99CCCC" ForeColor="#003399"></PagerStyle>

                <RowStyle BackColor="White" ForeColor="#003399"></RowStyle>

                <SelectedRowStyle BackColor="#009999" Font-Bold="True" ForeColor="#CCFF99"></SelectedRowStyle>

                <SortedAscendingCellStyle BackColor="#EDF6F6"></SortedAscendingCellStyle>

                <SortedAscendingHeaderStyle BackColor="#0D4AC4"></SortedAscendingHeaderStyle>

                <SortedDescendingCellStyle BackColor="#D6DFDF"></SortedDescendingCellStyle>

                <SortedDescendingHeaderStyle BackColor="#002876"></SortedDescendingHeaderStyle>
            </asp:GridView>
            <asp:DetailsView ID="DetailsView1" runat="server" Height="50px" Width="125px" AutoGenerateRows="False" DataKeyNames="ID" DataSourceID="EntityDataSource1" OnItemInserted="DetailsView1_ItemInserted">
                <Fields>
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" SortExpression="Nombre"></asp:BoundField>
                    <asp:BoundField DataField="Apellido" HeaderText="Apellido" SortExpression="Apellido"></asp:BoundField>
                    <asp:BoundField DataField="Sexo" HeaderText="Sexo" SortExpression="Sexo"></asp:BoundField>
                    <asp:BoundField DataField="Edad" HeaderText="Edad" SortExpression="Edad"></asp:BoundField>
                    <asp:CommandField ShowInsertButton="True" />
                </Fields>
            </asp:DetailsView>
            <asp:EntityDataSource ID="EntityDataSource1" runat="server" ConnectionString="name=ColegioEntities" DefaultContainerName="ColegioEntities" EnableDelete="True" EnableFlattening="False" EnableInsert="True" EnableUpdate="True" EntitySetName="Alumnoes" EntityTypeFilter="Alumno"></asp:EntityDataSource>
        </div>
    </form>
</body>
</html>

({
    ponerFicha : function(component, event, helper) {

        var token = component.get("v.token");
        var coords = event.getParam("coords");

        var tablero = component.find("tablero").getElement();
        console.log(tablero);
        tablero.getElementsByTagName("tr")[coords[0]].getElementsByTagName("td")[coords[1]].innerHTML = token? "X" : "O";
        component.set("v.token", !token);
    }
})

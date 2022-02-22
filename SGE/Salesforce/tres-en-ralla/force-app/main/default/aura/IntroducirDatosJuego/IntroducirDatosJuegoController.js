({
    ponerFicha : function(component, event, helper) {
        
        var posX = component.find("posX").getElement().value;
        var posY = component.find("posY").getElement().value;
        var coords = [
            posX,
            posY
        ]

        var ponerFichaEvent =$A.get("e.c:PonerFichaEvent");
        
        ponerFichaEvent.setParams({"coords": coords});
        ponerFichaEvent.fire();
    }
})

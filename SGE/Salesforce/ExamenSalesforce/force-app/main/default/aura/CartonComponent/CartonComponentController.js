({
    checkCarton : function(component, event, helper) {

        var bola = event.getParam("bolaSacada");

        var carton = component.find("carton").getElement();

        for (var i = 0; i < carton.getElementsByTagName("td").length; i++) {
            
            var td = carton.getElementsByTagName("td")[i];

            if (td.innerHTML == bola && td.style.backgroundColor != "green") {
                
                td.style.backgroundColor = "red";
                td.style.color = "white";
                helper.checkPremios(carton);
            }
            
        }
    }
})

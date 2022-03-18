({
    jugar : function(component, event, helper) {

        var action = component.get("c.getRandomNumber");
        action.setParams({
            "min": 1,
            "max": 90
        });
        action.setCallback(this, function(response) {
            var state = response.getState();
            if (state === "SUCCESS") {

                var bola = response.getReturnValue();
                var sacarBolaEvent =$A.get("e.c:SacarBolaEvent");
                
                console.log({"bolaSacada": bola});
        
                sacarBolaEvent.setParams({"bolaSacada": bola});
                sacarBolaEvent.fire();
            }
        });
        $A.enqueueAction(action);
    }
})

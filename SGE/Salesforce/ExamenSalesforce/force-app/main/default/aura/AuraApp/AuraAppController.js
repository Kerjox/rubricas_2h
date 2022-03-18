({
    llamarApex : function(component, event, helper) {

        var action = component.get("c.getRandomNumber");
        action.setParams({
            "min": 1,
            "max": 90
        });
        action.setCallback(this, function(response) {
            var state = response.getState();
            if (state === "SUCCESS") {

                sacarBola(response.getReturnValue());
                var result = response.getReturnValue();
                //component.set("v.data", result);
            }
        });
        $A.enqueueAction(action);
    },

    sacarBola(bola){

        console.log({"bolaSacada": bola});
        var sacarBolaEvent =$A.get("e.c:SacarBolaEvent");
        
        sacarBolaEvent.setParams({"bolaSacada": bola});
        sacarBolaEvent.fire();
    }
})

({
    llamarApex : function(component, event, helper) {

        var action = component.get("c.getRandomNumber");
        action.setParams({
            "min": 1,
            "max": 10
        });
        action.setCallback(this, function(response) {
            var state = response.getState();
            if (state === "SUCCESS") {
                var result = response.getReturnValue();
                component.set("v.data", result);
                alert(result);
            }
        });
        $A.enqueueAction(action);
    }
})

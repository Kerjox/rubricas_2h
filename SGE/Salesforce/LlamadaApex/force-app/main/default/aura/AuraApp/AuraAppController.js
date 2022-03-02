({
    llamarApex : function(component, event, helper) {

        var action = component.get("c.getString");

        action.setCallback(this, function(response) {
            
            var state = response.getState();
            if (state === "SUCCESS") {
                var result = response.getReturnValue();
                alert(result);
            }
        
        });
        
        // Enqueue Action
        $A.enqueueAction(action);
    }
})

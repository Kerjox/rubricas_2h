({
    reset : function(component, event, helper) {

        const callbackMethod = component.get("v.onDataReady");
        callbackMethod.setParams({ "data":"reset" });
        $A.enqueueAction(callbackMethod);
    }
})

({
    myAction : function(component, event, helper) {

    },
    gestionarEvento : function(component, event){
        var message = event.getParam("message")
        component.set("v.variable2", message)
    }
})

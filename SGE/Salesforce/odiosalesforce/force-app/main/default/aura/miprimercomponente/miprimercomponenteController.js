({
    myAction : function(component, event, helper) {

    },
    holaMundo : function(component, event, helper){
        console.log("Me has hecho click")
        var mensaje = component.find("input2").get("v.value")
        var mensaje2 = component.find("msg").getElement().value
        alert(mensaje2)
        component.set("v.myvariable", "Hola Jairo")
        console.log(mensaje)
        var appEvent = $A.get("e.c:myEvent")
        console.log(appEvent)
        appEvent.setParams({"message" : "lo hizo un mago"})
        appEvent.fire()
    }
})

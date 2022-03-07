({
    checkMove : function(component, event, tableroArray) {
        var tablero = component.find("tablero").getElement();
        
        for (var i = 0; i < tablero.getElementsByTagName("tr").length; i++) {

            var lineaArray = [];
            for (var j = 0; j < tablero.getElementsByTagName("tr")[i].getElementsByTagName("td").length; j++) {
                lineaArray.push(tablero.getElementsByTagName("tr")[i].getElementsByTagName("td")[j].innerHTML);
            }
            tableroArray.push(lineaArray);
        }
        if((tableroArray[0][0] !== "-") && tableroArray[0][0] === tableroArray[0][1] && tableroArray[0][0] === tableroArray[0][2])
            alert("GANA " + tableroArray[0][0]);
        else if((tableroArray[1][0] !== "-") && tableroArray[1][0] === tableroArray[1][1] && tableroArray[1][0] === tableroArray[1][2])
            alert("GANA " + tableroArray[1][0]);
        else if((tableroArray[2][0] !== "-") && tableroArray[2][0] === tableroArray[2][1] && tableroArray[2][0] === tableroArray[2][2])
            alert("GANA " + tableroArray[2][0]);
        else if((tableroArray[0][0] !== "-") && tableroArray[0][0] === tableroArray[1][0] && tableroArray[0][0] === tableroArray[2][0])
            alert("GANA " + tableroArray[0][0]);
        else if((tableroArray[0][1] !== "-") && tableroArray[0][1] === tableroArray[1][1] && tableroArray[0][1] === tableroArray[2][1])
            alert("GANA " + tableroArray[0][1]);
        else if((tableroArray[0][2] !== "-") && tableroArray[0][2] === tableroArray[1][2] && tableroArray[0][2] === tableroArray[2][2])
            alert("GANA " + tableroArray[0][2]);
        else if((tableroArray[0][0] !== "-") && tableroArray[0][0] === tableroArray[1][1] && tableroArray[0][0] === tableroArray[2][2])
            alert("GANA " + tableroArray[0][0]);
        else if((tableroArray[0][2] !== "-") && tableroArray[0][2] === tableroArray[1][1] && tableroArray[0][2] === tableroArray[2][0])
            alert("GANA " + tableroArray[0][2]);
        
    }
})

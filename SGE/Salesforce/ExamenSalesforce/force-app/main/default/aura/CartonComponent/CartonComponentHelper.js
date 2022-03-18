({
    checkPremios : function(carton) {

        for (let i = 0; i < carton.getElementsByTagName("tr").length; i++) {
        
            let linea = carton.getElementsByTagName("tr")[i].getElementsByTagName("td");
            let cont = 0;

            for (let j = 0; j < linea.length; j++) {
                
                var td = carton.getElementsByTagName("tr")[i].getElementsByTagName("td")[j];
                
                if (td.style.backgroundColor == "red") {
                    
                    cont++;
                }
            }

            if (cont == linea.length) {
            
                for (let i = 0; i < linea.length; i++) {
            
                    const td = linea[i];
                        
                    td.style.backgroundColor = "green";
                    td.style.color = "white";
                }
            }
        }
    }
})

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
 
        fillTable();

        $('#dataForm').on('submit',function(e) {
            e.preventDefault();
            var nombre = $('#nombre').val();
            var descripcion = $('#descripcion').val();
            var id = $('#id').val();
            var esValido = validate(nombre,descripcion,id);

            if(esValido){
                if($('#select option:selected').text() === 'Crear'){
                    var values = $(this).serialize();
                    $.ajax({
                           url: "http://localhost:8080/EscuelitaREST/app/carrera?nombre="+nombre+"&descripcion="+descripcion,
                           type: "post",
                           data: values ,
                           success: function (response) {
                              alert('creacion exitosa');           
                           },
                           error: function(jqXHR, textStatus, errorThrown) {
                              console.log(textStatus, errorThrown);
                           }
                    });
                    clearTable();
                    fillTable(); 
                }
                else if($('#select option:selected').text() === 'Borrar'){
                    var values = $(this).serialize();
                    $.ajax({
                           url: "http://localhost:8080/EscuelitaREST/app/carrera?id="+id,
                           type: "delete",
                           data: values ,
                           success: function (response) {
                              alert('eliminacion exitosa');           
                           },
                           error: function(jqXHR, textStatus, errorThrown) {
                              console.log(textStatus, errorThrown);
                           }
                    });
                }
                else if($('#select option:selected').text() === 'Actualizar'){
                    var values = $(this).serialize();
                    $.ajax({
                           url: "http://localhost:8080/EscuelitaREST/app/carrera?id="+id+"&nombre="+nombre+"&descripcion="+descripcion,
                           type: "put",
                           data: values ,
                           success: function (response) {
                              alert('actualizacion exitosa');           
                           },
                           error: function(jqXHR, textStatus, errorThrown) {
                              console.log(textStatus, errorThrown);
                           }
                    });
                }            
                else if($('#select option:selected').text() === 'Buscar'){
                    var values = $(this).serialize();
                    var msg = $.ajax({
                           url: "http://localhost:8080/EscuelitaREST/app/carrera?id="+id,
                           type: "get",
                           async: false,
                           data: values ,
                           success: function (response) {
                              alert('busqueda exitosa');           
                           },
                           error: function(jqXHR, textStatus, errorThrown) {
                              console.log(textStatus, errorThrown);
                           }
                    }).responseText;
                    
                    clearTable();

                    var table = document.getElementById("table");
                    var tr = document.createElement("tr");
                    table.appendChild(tr);
                    var arr = msg.split('\t');
                    for(var j = 0; j < arr.length; j++){
                        var td = document.createElement("td");
                        td.innerHTML = arr[j];
                        tr.appendChild(td);   
                    }                  
                }
            }
            else{
                alert('hay campos necesarios vacios');
            }
        });
});

function validate(nombre,descripcion,id){
    if($('#select option:selected').text() === 'Crear'){
        if(!nombre || !descripcion) return false;
        else return true;
    }
    else if($('#select option:selected').text() === 'Actualizar'){
        if(!nombre || !descripcion || !id) return false;
        else return true;
    }
    else if($('#select option:selected').text() === 'Borrar'){
        if(!id) return false;
        else return true;
    }
    else if($('#select option:selected').text() === 'Buscar'){
        if(!id) return false;
        else return true;
    }       
}

function fillTable(){
    var msg = $.ajax({
        url: "http://localhost:8080/EscuelitaREST/app/carrera/all",
        type: "get",
        async: false,
    }).responseText;

    var arr = msg.split('\n');
    var table = document.getElementById("table");
    for(var i = 0; i < arr.length; i++){
        var tr = document.createElement("tr");
        table.appendChild(tr);
        var arr2 = arr[i].split('\t');
        for(var j = 0; j < arr2.length; j++){
            var td = document.createElement("td");
            td.innerHTML = arr2[j];
            tr.appendChild(td);   
        }
    }
}

function clearTable(){
    var table = document.getElementById("table");
    var arr = table.childNodes.length;
    for(var i = 0; i < arr ; i++){
        table.removeChild(table.childNodes[0]);  
    }
}


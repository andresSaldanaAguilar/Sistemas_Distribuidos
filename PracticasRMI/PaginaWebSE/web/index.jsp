<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Operaciones</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body style="background-color:#D8D8D8">
        <div class="container" style="padding-top: 10%;">
            <h1>Operaciones</h1>

            <form action="Servlet" method="post">

                <select id="combo" name="select" onChange="Cambiar()" class="form-control">
                    <option value="" selected="selected"></option>
                    <option value="1">Suma</option>
                    <option value="2">Resta</option>
                    <option value="3">Multiplicacion</option>
                    <option value="4">Division</option>
                    <option value="5">Promedio</option>
                    <option value="6">Desviacion</option>
                    <option value="7">Factorial</option>
                    <option value="8">Fibonacci</option>
                    <option value="9">Cuadrado</option>
                    <option value="10">Raiz Cuadrada</option>
                </select>
                <br/>
                <br/>
                <div id="numero1" name="numero1" style="visibility: hidden;" >
                    Operando 1<input type="text" id="x" name="x" class="form-control"/>
                </div>   
                <div id="numero2" name="numero2" style="visibility: hidden;" >
                    Operando 2 <input type="text" id="y" name="y" class="form-control"/>
                </div>   
                <br/>
                <div id="esp" name="esp" style="visibility: hidden;" >
                    <input type="text" id="area" name="area" class="form-control"></input>
                </div>   
                <br/>
                <br/>
                <input class="btn btn-success" type="submit"/>
            </form>
        </div>
    </body>
    <script language="javascript">

        function Cambiar()
        {
            var valor = combo.value;

            numero1.style.visibility = "hidden";
            numero2.style.visibility = "hidden";
            esp.style.visibility = "hidden";

            if (valor == 1 || valor == 2 || valor == 3 || valor == 4)
            {
                numero1.style.visibility = "visible";
                numero2.style.visibility = "visible";
            }
            if (valor == 5 || valor == 6)
            {
                esp.style.visibility = "visible";
            }
            if (valor == 7 || valor == 8 || valor == 9 || valor == 10)
            {
                numero1.style.visibility = "visible";
            }
        }

    </script>
</html>

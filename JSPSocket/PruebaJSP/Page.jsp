<%@ page import="java.io.*, java.net.*" %>
<HTML>
    <HEAD>
            <title>Inicio</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
            <link rel="stylesheet" href="Resources/font-awesome-4.7.0/css/font-awesome.css">   
            <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
            <link rel="stylesheet" href="Resources/Styles.css">  
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </HEAD>

    <BODY style="background-color:#D8D8D8">
        <% 
        String [] results = new String[10];
        String result = "";
        int n1=3, n2=13;
        try{
            int character;
            Socket socket = new Socket("127.0.0.1", 8765);

            
            OutputStream outSocket = socket.getOutputStream();

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String str = n1+","+n2+"\n";
            byte buffer[] = str.getBytes();
            outSocket.write(buffer);

            result = br.readLine();
            
            results = result.split(";");
            socket.close();
        }
        catch(java.net.ConnectException e){
        %>
            Debes correr primeramente el servidor
        <%
        }
        %>
        <div class="container"  style="padding:6% 0% 0% 0%;">
                <div class="panel panel-default" >
                     
                     <div class="panel-body">
                         <div class="container" style="padding:0% 0% 2% 17%">
                    
                         
                         <div style="float: left; padding-left: 10%">
                             <legend><h1>Resultados de la operacion de 3 y 13</h1></legend>
                             
                          
                                 <div class="row">
                                    <label class="form">Suma:</label>
                                    <label style="color:green"><%out.print(results[0]);%></label>
                                 </div>
                                 <div class="row">
                                     <label class="form">Resta:</label>
                                     <label style="color:green"><%out.print(results[1]);%></label>
                                 </div>
                                 <div class="row">
                                        <label class="form">Multiplicacion:</label>
                                        <label style="color:green"><%out.print(results[2]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Division:</label>
                                        <label style="color:green"><%out.print(results[3]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Paridad de <%out.print(n1);%>:</label>
                                        <label style="color:green"><%out.print(results[4]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Maximo:</label>
                                        <label style="color:green"><%out.print(results[5]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Desviacion estandar:</label>
                                        <label style="color:green"><%out.print(results[6]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Promedio:</label>
                                        <label style="color:green"><%out.print(results[7]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Factorial de <%out.print(n1);%>:</label>
                                        <label style="color:green"><%out.print(results[8]);%></label>
                                </div>
                                <div class="row">
                                        <label class="form">Fibonacci hasta <%out.print(n1);%>:</label>
                                        <label style="color:green"><%out.print(results[9]);%></label>
                                </div>
                             </div>
                         </div>
                         </div>
                     </div>
                </div>
    </BODY>
</HTML>
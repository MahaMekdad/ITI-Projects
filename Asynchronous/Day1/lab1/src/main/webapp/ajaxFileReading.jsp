<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="jquery-1.9.1.min.js"></script>
</head>
<body onload="setInterval('renderTable()', 5000)">
    <div>
        <form METHOD ="POST" name="ajaxFile" action="">
            <div>
                <input type="text" name="txtField" id="txtField" size="100">
            </div>
            <br>
            <div>
                <input type="button" value="Submit" onclick="readFile()">
            </div>
        </form>
    </div>
    <br>
    <div>
        <form name="ajaxLogin">
            <div>
                <label>Username:</label>
                <input type="text" name="unameField" id="unField" onblur="checkUsername()">
                <label id="verification" style="display: inline"></label>
            </div>
            <br>
            <div>
                <label>Password:</label>
                <input type="text" name="passField" id="passField">
            </div>
            <br>
            <div>
                <input type="button" value="Submit" onclick="readFile()">
            </div>
        </form>
    </div>
    <br>
    <div id="tableResult"></div>
    <script>
        let fileReq = null;
        let unReq = null;
        let tableReq = null;
        function checkUsername(){
            //console.log("inside the check username");
            unReq = getXMLHttpReq();
            unReq.onreadystatechange = handleCheckUnameReq;
            var un = document.getElementById("unField").value;
            unReq.open("GET", "loginServlet?un=" + un + "&time="+new Date().getTime(), true);
            unReq.send(null);
        }
        function handleCheckUnameReq(){
            if(unReq.readyState === 4 && unReq.status === 200){
                $("#verification").empty();
                var node = document.createTextNode(unReq.responseText);
                document.getElementById("verification").appendChild(node);
            } else {
                document.getElementById("verification").appendChild(document.createTextNode(unReq.status));
            }
        }

        function readFile(){
            fileReq = getXMLHttpReq();
            fileReq.onreadystatechange = handleFileReq;
            fileReq.open("GET", "simpleTxtFile.txt?time=" + new Date().getTime(), true);
            fileReq.send(null);
        }
        function handleFileReq(){
            if(fileReq.readyState === 4){
                if(fileReq.status === 200){
                    document.getElementById("txtField").value = "Received: " + fileReq.responseText;
                    //console.log(document.getElementById("txtField").value);
                } else {
                    document.ajaxFile.txtField.value ="Failed: " + fileReq.status;
                }
            }
        }
        function getXMLHttpReq(){
            if(window.XMLHttpRequest){
                return new XMLHttpRequest();
            } else if(window.ActiveXObject){
                return new ActiveXObject(Microsoft.XMLHTTP);
            }
        }

        function renderTable(){
            tableReq = getXMLHttpReq();
            tableReq.onreadystatechange = handleRenderTableReq;
            tableReq.open("GET", "innerHTML.txt?time=" + new Date().getTime(), true);
            tableReq.send(null);
        }
        function handleRenderTableReq(){
            if (tableReq.readyState== 4 && tableReq.status== 200){
                document.getElementById("tableResult").innerHTML= tableReq.responseText;
                console.log(document.getElementById("tableResult").innerHTML= tableReq.responseText)
            }
        }
    </script>
</body>
</html>
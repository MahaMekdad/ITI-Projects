<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous">
    </script>
    <script src="jquery-1.9.1.min.js"></script>
</head>
<body onload="setInterval('loadChat()', 3000)" style='text-align: center; margin-top: 50px; background-image:url("original.jpg")'>
    <div>
        <form METHOD ="GET" action="" style="align-content: center">
            <div>
                <input type="text" placeholder="Enter Your Name" name="nameField" id="nameField" size="40" style="border-radius: 5px">
            </div>
            <br>
            <div>
                <input type="text" placeholder="Type In Your Message" name="msgField" id="msgField" size="40" style="border-radius: 5px">
            </div>
            <br>
            <div>
                <input type="button" value="Send" onclick="addMsg()" class="btn btn-info">
            </div>
        </form>
    </div>
    <br>
    <div style='text-align: center; margin-right: 50px; margin-left: 50px'>
        <table id="chat" border="1" style='text-align: center;' class="table table-dark">
            <tr>
                <th>Sender</th>
                <th>Message</th>
            </tr>
        </table>
    </div>
    <script>
        var globalCounter = 0;
        function addMsg(){
            let jsonMsg = {"name": $("#nameField").val(), "msg": $("#msgField").val()}
            $.get("msgServlet?c="+globalCounter, jsonMsg, ajaxCallBack);
            function ajaxCallBack(responseJson, status, xhr){
                if(status === "success"){
                    console.log("send succeeded")
                }
            }
            // $.ajax({url:'msgServlet?c='+globalCounter, type:'GET', contentType:'application/json', data:jsonMsg, dataType:'json',
            //         success:function (data){
            //             console.log("back from send " + data)
            //             //let m = jQuery.parseJSON(data)
            //             // $.each(data, function (key, value){
            //             //     //console.log(key + " " + value);
            //             //     //console.log(value.name + " KEYVAL " + value.msg);
            //             //     $('#chat tr:last').after(`<tr><td>\${value.name}</td><td>\${value.msg}</td></tr>`);
            //             //     globalCounter += 1;
            //             // })
            //         }
            // })
        }
        function loadChat(){
            $.post('msgServlet',{c : globalCounter}, ajaxCallBack)
        }
        function ajaxCallBack(responseJson, status, xhr){
            //console.log(globalCounter + " ---> gb")
            //console.log(responseJson + " EH")
            if(status === "success" && responseJson != ""){
                let msgs = jQuery.parseJSON(responseJson)
                //console.log(responseJson + " EH BA@AA")
                $.each(msgs, function (key, value){
                    $('#chat tr:last').after(`<tr><td>\${value.name}</td><td>\${value.msg}</td></tr>`);
                    globalCounter += 1;
                })
            }
        }
    </script>
</body>
</html>
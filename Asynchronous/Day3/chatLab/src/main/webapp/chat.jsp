<%--
  Created by IntelliJ IDEA.
  User: maha
  Date: 15/03/2021
  Time: 6:12 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous">
    </script>
    <script src="jquery-1.9.1.min.js"></script>
</head>
<body onload="connect();"
      style="margin-top: 50px; background-image:url('linear-purple-gradient-blue-1920x1080-c2-9932cc-191970-a-270-f-14.png')">
<div class="container">
    <div class="row">
        <div class="col-8">
            <div class="border border-secondary" style="background-color: lightgrey; border-radius: 6px">
                <div id="msgsContainer"></div>
            </div>
            <div style="padding-top: 5px">
                <input type="text" name="txtField" id="txtField" placeholder="Enter Your Message" size="92"
                       style="border-radius: 6px; height: 39px;">
                <input type="button" name="sendBtn" id="sendBtn" value="Send" onclick="send()" class="btn btn-primary">
                <input type="button" name="logoutBtn" id="logoutBtn" value="Logout" onclick="closes()"
                       class="btn btn-danger">
            </div>
        </div>
        <div class="col-4">
            <div id="online" class="border border-secondary"
                 style="background-color: lightseagreen; border-radius: 6px"></div>
        </div>
    </div>
</div>
<script>
    var xmlReq = null;
    var closeReq = null;
    function send() {
        xmlReq = getXMLHttpReq();
        xmlReq.onreadystatechange = handleSendMsgReq;
        xmlReq.open("post", "webChatServlet", true);
        xmlReq.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        var data = JSON.stringify({
            "msg": document.getElementById("txtField").value,
            "name": "<%=request.getParameter("uname")%>",
            "gender": "<%=request.getParameter("gender")%>"
        })
        console.log(data)
        //xmlReq.send("msg=" + document.getElementById("txtField").value, "&name=" <%=request.getParameter("uname")%>, "&gender=" <%=request.getParameter("gender")%>);
        xmlReq.send("data=" + data);
    }

    function handleSendMsgReq() {
        if (xmlReq.readyState === 4 && xmlReq.status === 200) {
            console.log("succeeded")
        } else {
            console.log("failed")
        }
    }

    function getXMLHttpReq() {
        if (window.XMLHttpRequest) {
            return new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            return new ActiveXObject(Microsoft.XMLHTTP);
        }
    }

    var eventSource = null;

    function connect() {
        if(typeof (Worker) !== "undefined"){
            var worker = new Worker("webWorker.js")
            worker.postMessage()
        }
        worker.onmessage = function (event){

        }
        if (window.EventSource !== undefined) {
            console.log("before");
            eventSource = new EventSource("webChatServlet?name=<%=request.getParameter("uname")%>&gender=<%=request.getParameter("gender")%>"); // Get
            console.log("after " + eventSource);
            eventSource.readyState = handleEventSourceStats

            eventSource.onmessage = function (event) {
                // if(typeof (Worker) !== "undefined"){
                //
                // }
                console.log("inside the onmessage");
                console.log(event.lastEventId);
                console.log(event.data)
                var data = JSON.parse(event.data);
                $.each(data, function (key, value) {
                    var br = $("<br>");
                    var $label = $("<label>").text(value.sender);
                    var $label2 = $("<label>").text(value.msg);
                    var img = $('<img id="img">');
                    var photoSrc = (value.gender === "female") ? "female.jpeg" : "male.jpeg"
                    img.attr('src', photoSrc);
                    img.attr('width', 50);
                    img.attr('height', 50);
                    $("#msgsContainer").append(img, $label, ":    ", $label2, br)
                })
            }
            eventSource.addEventListener("userstatus", function (event) {
                console.log("inside the userstatus event!")
                console.log(event.data)
                var onlineUsers = JSON.parse(event.data)
                $("#online").empty()
                //let onlineUsers = JSON.parse(JSON.stringify(msgObj))
                $.each(onlineUsers, function (key, value) {
                    var br = $("<br>");
                    var username = $("<label>").text(value.name);
                    var status = $("<label>").text(value.status);
                    var img = $('<img id="img">');
                    var photoSrc = (value.gender === "female") ? "female.jpeg" : "male.jpeg"
                    img.attr('src', photoSrc);
                    img.attr('width', 50);
                    img.attr('height', 50);
                    $("#online").append(img, username, "   ", status, br)
                })
            }, false)
        } else {
            console.log("failed to get a event source")
        }
    }
    function closes(){
        closeReq = getXMLHttpReq();
        closeReq.onreadystatechange = handleCloseReq;
        closeReq.open("post", "webChatServlet", true);
        closeReq.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        var udata = JSON.stringify({
            "username": "<%=request.getParameter("uname")%>"
        })
        closeReq.send("name=" + udata);
        console.log("here removing the user to close")
    }
    function handleCloseReq(){
        if (closeReq.readyState == 4 && closeReq.status == 200) {
            console.log(closeReq.responseText)
            console.log("removing the user succeeded")
            eventSource.close()
            window.location.href = "index.jsp"
        } else {
            console.log("removing the user failed")
        }
    }
    function handleEventSourceStats(){
        if (eventSource.readyState === 2) {
            console.log("succeeded")
        }
    }
</script>
</body>
</html>

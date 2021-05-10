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
    <script src="helper.js"></script>
    <script src="jquery-1.9.1.min.js"></script>
</head>
<body onload="connect(); setInterval('getContacts()', 3000)" style="margin-top: 50px; background-image:url('linear-purple-gradient-blue-1920x1080-c2-9932cc-191970-a-270-f-14.png')">
    <div class="container">
        <div class="row">
            <div class="col-8">
                <div class="border border-secondary" style="background-color: lightgrey; border-radius: 6px">
                    <div id="msgsContainer"></div>
                </div>
                <div style="padding-top: 5px">
                    <input type="text" name="txtField" id="txtField" placeholder="Enter Your Message" size="92" style="border-radius: 6px; height: 39px;">
                    <input type="button" name="sendBtn" id="sendBtn" value="Send" onclick="send()" class="btn btn-primary">
                    <input type="button" name="logoutBtn" id="logoutBtn" value="Logout" onclick="closes()" class="btn btn-danger">
                </div>
            </div>
            <div class="col-4">
                <div id="online" class="border border-secondary" style="background-color: lightseagreen; border-radius: 6px"></div>
            </div>
        </div>
    </div>
    <script>
        var wsocket
        function connect(){
            console.log("inside connect 1")
            wsocket = new WebSocket("ws://localhost:9191/asyncDay2chatLab/webChatServlet?name=<%=request.getParameter("uname")%>&gender=<%=request.getParameter("gender")%>")
            wsocket.onopen = Open
            wsocket.onmessage = Message
            //wsocket.onclose = closes();
        }
        function Open(){
            console.log("Connection Established")
            //wsocket.send("yakhtty");
        }
        function send(){
            msg = $("#txtField").val();
            wsocket.send(msg)
        }
        function closes(){
            console.log("here closing")
            wsocket.close()
            window.location.href = "index.jsp"
        }
        function Message(evt){
            let msgObj = JSON.parse(evt.data)
            console.log(evt.data)
            if(Array.isArray(msgObj) && msgObj != ""){
                console.log("evt.data")
                $("#online").empty()
                let onlineUsers = JSON.parse(JSON.stringify(msgObj))
                $.each(onlineUsers, function (key, value){
                    var br = $("<br>");
                    var username = $("<label>").text(value.name);
                    var status = $("<label>").text(value.status);
                    var img = $('<img id="img">');
                    var photoSrc = (value.gender === "female")? "female.jpeg" : "male.jpeg"
                    img.attr('src', photoSrc);
                    img.attr('width', 50);
                    img.attr('height', 50);
                    $("#online").append(img, username, "   ", status, br)
                })
            } else{
                var br = $("<br>");
                var $label = $("<label>").text(msgObj.sender);
                var $label2 = $("<label>").text(msgObj.msg);
                var img = $('<img id="img">');
                var photoSrc = (msgObj.gender === "female")? "female.jpeg" : "male.jpeg"
                img.attr('src', photoSrc);
                img.attr('width', 50);
                img.attr('height', 50);
                $("#msgsContainer").append(img, $label,":    ", $label2, br)
            }
        }
        function getContacts(){
            wsocket.send("getContacts")
        }
    </script>
</body>
</html>

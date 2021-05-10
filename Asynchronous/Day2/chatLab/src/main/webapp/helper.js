var wsocket
function connect(){
    console.log("inside connect 1")
    wsocket = new WebSocket("ws://localhost:9191/asyncDay2chatLab/webChatServlet?name="+$("#uname").val())

    wsocket.onopen = Open
    console.log(wsocket)
    window.localStorage.setItem("ws", wsocket)
}
function Open(){
    console.log("Connection Established")
}
function send(){
    var ws = window.localStorage.getItem("ws")
    //wsocket = new WebSocket("ws://localhost:9191/asyncDay2chatLab/webChatServlet?name="+$("#uname").val())
    msg = $("#txtField").val();
    ws.send(msg)
}
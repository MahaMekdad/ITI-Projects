//
// this.onmessage = function () {
//     if (window.EventSource !== undefined) {
//         console.log("before");
//         eventSource = new EventSource("webChatServlet?name=<%=request.getParameter("uname")%>&gender=<%=request.getParameter("gender")%>"); // Get
//         console.log("after " + eventSource);
//         eventSource.readyState = handleEventSourceStats
//         eventSource.onmessage = function (event) {
//             console.log("inside the onmessage");
//             console.log(event.lastEventId);
//             console.log(event.data)
//             var data = JSON.parse(event.data);
//             $.each(data, function (key, value) {
//                 var br = $("<br>");
//                 var $label = $("<label>").text(value.sender);
//                 var $label2 = $("<label>").text(value.msg);
//                 var img = $('<img id="img">');
//                 var photoSrc = (value.gender === "female") ? "female.jpeg" : "male.jpeg"
//                 img.attr('src', photoSrc);
//                 img.attr('width', 50);
//                 img.attr('height', 50);
//                 var obj = {
//                     type: "msgs",
//                     br: br,
//                     senderLabel: $label,
//                     msgLabel : $label2,
//                     img : img
//                 }
//                 this.postMessage('data: ' + obj)
//                 //$("#msgsContainer").append(img, $label, ":    ", $label2, br)
//             })
//         }
//         eventSource.addEventListener("userstatus", function (event) {
//             console.log("inside the userstatus event!")
//             console.log(event.data)
//             var onlineUsers = JSON.parse(event.data)
//             $("#online").empty()
//             //let onlineUsers = JSON.parse(JSON.stringify(msgObj))
//             $.each(onlineUsers, function (key, value) {
//                 var br = $("<br>");
//                 var username = $("<label>").text(value.name);
//                 var status = $("<label>").text(value.status);
//                 var img = $('<img id="img">');
//                 var photoSrc = (value.gender === "female") ? "female.jpeg" : "male.jpeg"
//                 img.attr('src', photoSrc);
//                 img.attr('width', 50);
//                 img.attr('height', 50);
//                 $("#online").append(img, username, "   ", status, br)
//             })
//         }, false)
//     } else {
//         console.log("failed to get a event source")
//     }
// }
var counter;

function timedCount(){
    counter += 1;
    postMessage(counter)
    setTimeout("timedCount()", 500)
}
this.onmessage = function (event){
    counter = event.data;
    timedCount();
}

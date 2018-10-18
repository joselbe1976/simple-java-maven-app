
var socket;

function onMessage(event) {
    
	readMessage();
    
}

function formSubmit() {
	
	var messgToSend = document.getElementById("textBox");
    socket.send(messgToSend.value);
    sendMessage();
    
}

function Open() {
    socket = new WebSocket("ws://localhost:8080/backendmovilidad/teams");
    socket.onmessage = onMessage;
}

function Close() {
    socket.close();
}
function readMessage(){
	
    var data = event.data;
    var texto = document.createTextNode(data);
    
    var span = document.createElement("span");
    span.appendChild(texto);
    
    var divSpan = document.createElement("div");
    divSpan.classList.add("row");
    divSpan.appendChild(span);

    var chatBox = document.getElementById("chatBox");
    chatBox.appendChild(divSpan);
	
}

function sendMessage(message){

    var texto = document.createTextNode(document.getElementById("textBox").value);
    
    var span = document.createElement("span");
    span.appendChild(texto);
    
    var divSpan = document.createElement("div");
    divSpan.classList.add("row");
    divSpan.appendChild(span);
    //divSpan.textAlign = "right";
    span.style.cssFloat = "right"
    span.textAlign = "right";
    

	
    
}


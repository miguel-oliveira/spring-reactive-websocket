let myWebSocket = new WebSocket("ws://localhost:8080/my-web-socket");
myWebSocket.onmessage = (message) => {
    console.log(message);
};

myWebSocket.onerror = (error) => {
    console.log(error);
};
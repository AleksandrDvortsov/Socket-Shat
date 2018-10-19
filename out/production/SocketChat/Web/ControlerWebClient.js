var webSocket = null;




    webSocket = new WebSocket("ws://localhost:10000");

    webSocket.onopen = function (event) {
    };
    webSocket.onmessage = function (ev) {

        alert("7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777");
    };
    webSocket.onclose = function (event) {
    };




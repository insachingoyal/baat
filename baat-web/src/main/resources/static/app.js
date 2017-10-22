$(document).ready(function () {
    $('connect-button').click(function () {
        var ws = new WebSocket("ws://" + location.hostname + ":8082/baat-ws");

        ws.onmessage = function (event) {
            $("#messages").append("<p>" + event.data + "</p>");
        };

        ws.onclose = function () {
            console.log("Socket closed");
        };

        ws.onopen = function () {
            console.log("Connected");
            ws.send(("#from-user").val());
        };
    });

    $('send-button').click(function () {
        if (ws) {
            ws.send(("#from-user").val());
        }
    });
});

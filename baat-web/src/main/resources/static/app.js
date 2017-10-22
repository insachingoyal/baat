$(document).ready(function () {
    $('#connect-button').click(function () {
        var ws = new WebSocket("ws://" + location.hostname + ":8082/baat-ws");

        ws.onmessage = function (event) {
            $("#messages").append("<p>" + event.data + "</p>");
        };

        ws.onclose = function () {
            console.log("Socket closed");
        };

        ws.onopen = function () {
            console.log("Connected");
            ws.send($("#from-user").val());
        };
    });

    $('#send-button').click(function () {
        var fromUserToken = $("#from-user").val();
        var toUserToken = $("#to-user").val();
        var newMessage = $("#new-message").val();
        var chatMessage = JSON.stringify({
            "fromUserToken": fromUserToken,
            "toUserToken": toUserToken,
            "message": newMessage
        });

        $.ajax({
            contentType: 'application/json',
            data: chatMessage,
            dataType: 'json',
            success: function (data) {
            },
            error: function () {
            },
            processData: false,
            type: 'PUT',
            url: "http://" + location.hostname + ":8083/"
        });
    });
});

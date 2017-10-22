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
        var userToken = $("#from-user").val();
        var recipientUserId = $("#to-user").val();
        var textMessage = $("#new-message").val();
        var chatMessage = JSON.stringify({
            "senderUserToken": userToken,
            "recipientUserId": recipientUserId,
            "textMessage": textMessage
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

$(document).ready(function () {

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        success: function (userInfo) {
            updateUserDetails(userInfo);
            createWebSocket(userInfo.id);
            populateUserList();
        },
        error: function (error) {
            $('#error-message').text(error)
        },
        processData: false,
        type: 'GET',
        url: "http://" + location.hostname + ":8081/userForToken/" + Cookies.get("X-Auth-Token")
    });

    function updateUserDetails(userInfo) {
        $('#user-details').text("Hi " + userInfo.fullName + "!");
    }

    function createWebSocket(userId) {
        var ws = new WebSocket("ws://" + location.hostname + ":8083/baat-ws");

        ws.onmessage = function (event) {
            $("#messages").append("<p>" + event.data + "</p>");
        };

        ws.onclose = function () {
            console.log("Socket closed");
        };

        ws.onopen = function () {
            ws.send(userId);
            console.log("Connected");
        };
    }

    function populateUserList() {
        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            success: function (userInfos) {
                for (var i = 0; i < userInfos.length; i++) {
                    var userInfo = userInfos[i];
                    $("#user-list").append("<div><a class='btn btn-link' id='user-" + userInfo.id + "' data-user-id='" + userInfo.id + "'>" + userInfo.fullName + "</a></div>")
                }
            },
            error: function (error) {
                $('#error-message').text(error)
            },
            processData: false,
            type: 'GET',
            url: "http://" + location.hostname + ":8081/users/"
        });
    }

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
            url: "http://" + location.hostname + ":8084/"
        });
    });
});

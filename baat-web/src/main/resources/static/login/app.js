$(document).ready(function () {
    $('#login-button').click(function () {
        var userName = $("#username").val();
        var password = $("#password").val();
        var userCredentials = JSON.stringify({
            "userName": userName,
            "password": password
        });

        $.ajax({
            contentType: 'application/json',
            data: userCredentials,
            dataType: 'json',
            success: function (data) {
            },
            error: function () {
            },
            processData: false,
            type: 'PUT',
            url: "http://" + location.hostname + ":8081/authenticate"
        });
    });
    $('#signup-button').click(function () {
        window.location = "http://" + location.hostname + ":8082/signup"
    });
});

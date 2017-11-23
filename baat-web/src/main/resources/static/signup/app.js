$(document).ready(function () {
    $('#signup-button').click(function () {
        var email = $("#email").val();
        var name = $("#name").val();
        var password = $("#password").val();
        var signupRequest = JSON.stringify({
            "email": email,
            "name": name,
            "password": password
        });

        $.ajax({
            contentType: 'application/json',
            data: signupRequest,
            dataType: 'json',
            success: function (data) {
                console.log(data)
            },
            error: function (error) {
                $('#error-message').text(error.responseText)
            },
            processData: false,
            type: 'PUT',
            url: "http://" + location.hostname + ":8081/signup"
        });
    });
});

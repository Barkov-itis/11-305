<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
</head>
<body>
<script>

    function sendUser(firstName, lastName, email, csrf) {
        let data = {
            "firstName": firstName,
            "lastName": lastName,
            "email": email
        };

        $.ajax({
            type: "POST",
            url: "/ajax",
            data: JSON.stringify(data),
            success: function (response) {
                alert("Все супер")
            },
            headers: {"X-CSRF-TOKEN": csrf},
            dataType: "json",
            contentType: "application/json"
        });
    }
</script>
<div>
    <input type="text" id="first_name" placeholder="Имя">
    <input type="text" id="last_name" placeholder="Второе имя">
    <input type="text" id="email" placeholder="Email">
    <input type="hidden" id="csrf" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button onclick="sendUser(
        $('#first_name').val(),
        $('#last_name').val(),
        $('#email').val(),
        $('#csrf').val()
    )">Отправить</button>
</div>
</body>
</html>
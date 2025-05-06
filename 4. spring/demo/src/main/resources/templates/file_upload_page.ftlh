<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <title>Document</title>
    <script>
        function sendFile() {
            let formData = new FormData();
            let files = ($('#file'))[0]['files'];
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file)
            });

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost:8080/files/' + response;
                    $('#photo').append('<img src = "' + fileUrl + '"/>')
                })
                .fail(function () {alert('Error')});
        }
    </script>
</head>
<body>
<div>
    <input type="file" id="file" name="file" placeholder="Имя файла..."/>
    <input type="hidden" id="file_hidden">
    <button onclick="sendFile()">Загрузить файл</button>
</div>
<div id="photo"></div>
</body>
</html>
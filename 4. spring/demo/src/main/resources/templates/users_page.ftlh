<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>email</th>
        </tr>
        <#list usersList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
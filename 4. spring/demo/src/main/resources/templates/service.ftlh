<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
</head>
<body>
<script>
    function renderTable(services, table) {

        let innerHtml = '<tr>\n' +
            '                <th>id</th>' +
            '                <th>name</th>' +
            '                <th>cost</th>' +
            '                <th>date</th>' +
            '            </tr>';

        for (let i = 0; i < services.length; i++) {
            innerHtml += '<tr>';
            innerHtml += '  <td>' + services[i]['id'] + '</td>';
            innerHtml += '  <td>' + services[i]['name'] + '</td>';
            innerHtml += '  <td>' + services[i]['cost'] + '</td>';
            innerHtml += '  <td>' + services[i]['date'] + '</td>';
            innerHtml += '</tr>';
        }

        table.html(innerHtml);
    }
</script>
<div>
    <#list countList as services>
        <script>
            let refetch${services_index} = () => {
                <#--alert("${services_index}");-->
                $.ajax({
                    type: "GET",
                    url:"papers/service/search?page=${services_index}",
                    success: function (response) {
                        renderTable(response, $('table'))
                    },
                    dataType: "json",
                    contentType: "application/json"
                })
            }
        </script>
        <button class="button" onclick="refetch${services_index}()">${services_index + 1}</button>
    </#list>
</div>
<div>
    <table id="table"></table>
</div>
</body>
</html>
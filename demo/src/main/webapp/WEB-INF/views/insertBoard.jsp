<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-06
  Time: 오전 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 삽입</title>
</head>
<body>
    <form action="/api/board">
        title : <input type="text" name = "title"><br>
        categoryId : <input type="text" name = "categoryId"><br>
        content : <textarea name = "content" cols = "50" rows = "10"></textarea><br>
        <input type="submit" id = "insertBoardButton" value = "게시글 저장">
    </form>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script>
        $("#insertBoardButton").click((event) => {
            event.preventDefault();
            const target = event.target;

            const form = target.parentElement;
            const url = form.action;

            const title = $("input[name = 'title']").val();
            const content = $("input[name = 'content']").val();
            const categoryId = $("input[name = 'categoryId']").val();

            const data = {
                title : title,
                content: content,
                categoryId : categoryId
            }

            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(data),
                success: function(response){
                    alert(response.result)
                    location.href = "/board/list"
                },
                error: function (req, status, error) {
                    alert("error")
                },
                dataType: "json",
                contentType : "application/json"
            });
        })
    </script>
</body>
</html>

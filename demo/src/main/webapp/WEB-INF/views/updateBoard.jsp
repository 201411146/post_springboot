<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-06
  Time: 오전 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>
</head>
<form action="/api/board">
    게시물 번호 : <span class = "form__board-num">${id}</span><br>
    제목 : <input type="text" name = "title"><br>
    카테고리 : <input type="text" name = "categoryId"><br>
    내용 : <textarea name = "content" cols = "50" rows = "10"></textarea><br>
    <input type="submit" id = "updateBoardButton" value = "게시글 저장">
</form>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
    (function getBoard(){
        const url = "/api/board/" + ${id};

        $.ajax({
            type : "GET",
            url : url,
            success : function(board){
                const titleElem = $("input[name = 'title']");
                const categoryIdElem = $("input[name = 'categoryId']");
                const contentElem = $("textarea[name = 'content']");

                titleElem.val(board.title)
                categoryIdElem.val(board.categoryId)

                if(board.content != null)
                    contentElem.val(board.content);
            },
            error : function(){
                alert("게시물을 불러오는데 실패했습니다.");
                location.href = "/boardList";
            }
        })
    })();

    $("#updateBoardButton").click((event) => {
        event.preventDefault();
        const target = event.target;

        const form = target.parentElement;
        const url = form.action;

        const title = $("input[name = 'title']").val();
        const content = $("textarea[name = 'content']").val();
        const categoryId = $("input[name = 'categoryId']").val();

        const data = {
            id : ${id},
            title : title,
            content: content,
            categoryId : categoryId
        }


        $.ajax({
            type: "PUT",
            url: url,
            data: JSON.stringify(data),
            success: function(response){
                alert(response.result)

                if(response.result === "success"){
                    location.href = "/board/list"
                }
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

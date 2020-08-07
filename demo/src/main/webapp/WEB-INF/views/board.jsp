<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-07
  Time: 오전 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>board</title>
</head>
<body>
    <div class = "board">
        게시물 번호 : <span class = "board__boardNum"></span><br>
        제목 : <span class = "board__title"></span><br>
        카테고리 : <span class = "board__categoryId"></span><br>
        최근 수정일 : <span class = "board__modifyDate"></span><br>
        내용 : <textarea readonly class = "board__content" name="content" cols="50" rows="10"></textarea><br> <!-- readonly 속성을 주어 수정이 불가하도록 함 -->
        <button onclick="location.href = '/board/update/${id}'">게시글 수정</button>
    </div>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script>
        (function getBoard(){
            const url = "/api/board/" + ${id};

            $.ajax({
                type : "GET",
                url : url,
                success : function(board){
                    const titleElem = $(".board__title");
                    const categoryIdElem = $(".board__categoryId");
                    const modifyDateElem = $(".board__modifyDate");
                    const contentElem = $(".board__content");
                    const boardNum = $(".board__boardNum");

                    boardNum.text(board.id);
                    titleElem.text(board.title)
                    categoryIdElem.text(board.categoryId)
                    modifyDateElem.text(board.modifyDate);

                    if(board.content != null)
                        contentElem.text(board.content);
                },
                error : function(){
                    alert("게시물을 불러오는데 실패했습니다.");
                    location.href = "/boardList";
                }
            })
        })();
    </script>

</body>
</html>

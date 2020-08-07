<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-06
  Time: 오전 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ page isELIgnored="true"%> <!-- 템플릿 문자열을 사용하기 위해 el ignore-->--%>

<html>
<head>
    <title>게시판</title>
</head>
<body>
    <span class = "board-num">전체 글(0)</span><br><br>

    <div class = "board-container"></div><br>
    <div class = "paging"></div>

    <button onclick="location.href='/board/insert'">게시글 작성</button>


    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        (function getboards(){
            const url = "/api/boards?start=${start}"
            let totalBoardNum = 0;

            $.ajax({
                type : "GET",
                url : url,
                success : function(response){
                    const container = $(".board-container");
                    const pagingElem = $(".paging");

                    totalBoardNum = response.totalCount;

                    for(let board of response.boardList){
                        const title = board.title;
                        const createDate = board.createDate;
                        const boardNum = board.id;
                        container.append(`${'${boardNum}'} <a href = "/board/${'${boardNum}'}">${'${title}'}</a> ${'${createDate}'}<br>`)
                    }

                    for(let i = 1; i <= response.pagingCount; i++){
                        pagingElem.append(`<a href="/board/list?start=${'${i}'}">${'${i}'}</a> `);
                    }

                },
                complete : function(){
                    const totalBoardElem = $(".board-num");

                    totalBoardElem.text(`전체 글(${totalBoardNum})`)
                }
            })
        })();

    </script>
</body>
</html>

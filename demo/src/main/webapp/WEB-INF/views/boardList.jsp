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

    <form onsubmit="searchBoards()">
        <input type="text" name = "search">
        <select class = "select-search" name="select">
            <option value="title" id = "title">제목</option>
            <option value="category_id" id = "categoryId">카테고리</option>
            <option value="content" id = "content">내용</option>
        </select>

    </form>

    <div class = "board-container"></div><br>
    <div class = "paging"></div><br>

    <button onclick="location.href='/board/insert'">게시글 작성</button>


    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        (function(){
            const selectValue = '${select}';
            const searchValue = '${search}';
            let url;

            if (selectValue !== "" && searchValue !== "")
                url = `/api/boards?start=${start}&select=${'${selectValue}'}&search=${'${searchValue}'}`
            else
                url = `/api/boards?start=${start}`;

            getboards(url);
        })();

        function getboards(url, select, search){
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
                        let pageUrl

                        if(select != undefined && search != undefined)
                            pageUrl = `<a href="/board/list?start=${'${i}'}&select=${'${select}'}&search=${'${search}}'}">${'${i}'}</a> `;
                        else
                            pageUrl= `<a href="/board/list?start=${'${i}'}">${'${i}'}</a> `;

                        pagingElem.append(pageUrl);
                    }

                },
                complete : function(){
                    const totalBoardElem = $(".board-num");

                    totalBoardElem.text(`전체 글(${'${totalBoardNum}'})`)
                }
            })
        }

    </script>
</body>
</html>

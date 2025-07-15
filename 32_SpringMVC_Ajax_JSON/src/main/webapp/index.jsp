<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>

<div id="container">
	<h1>게시판 프로그램</h1>
	<hr>
	<p>
		<a href="login.do">로그인 페이지로 이동(GET)</a>
	</p>
	<hr>
	<h2>Ajax 요청 처리</h2>
	<p><a href="javascript:getJsonBoardList()">JSON 데이터 가져오기(게시글 전체 목록)</a></p>
	게시글번호 : <input type="number" name="seq" value="1" id="seq">
	<p><a href="javascript:getJsonBoard()">게시글 데이터 1개 조회(JSON)</a></p>
	<hr>
	<div id="myDiv">
	받은 데이터 출력(보여주기)
	</div>
	
<script>
	function getJsonBoardList() {
		alert("getJsonBoardList() 실행~~");
		$.ajax("getJsonBoardList.do", {
			method: "get",
			//data: "searchCondition=TITLE&searchKeyword=test",
			
			dataType: "json",
			success: function(respData){
				alert("성공~~");
				console.log(respData);
				
				let dispHtml = "<ul>";
				for (const board of respData) {
					dispHtml += "<li>";
					dispHtml += board.seq + ", ";
					dispHtml += board.title + ", ";
					dispHtml += board.writer + ", ";
					dispHtml += board.content + ", ";
					dispHtml += board.regdate + ", ";
					dispHtml += board.cnt;
					dispHtml += "</li>";
				}
				
				dispHtml += "</ul>";
				$("#myDiv").html(dispHtml);
			},
			error: function(){
				alert("실패!!!");
			}
		});
		
	}
</script>	
<script>
	function getJsonBoard() {
		alert("getJsonBoard() 실행~~");
		const seq = Number($("#seq").val());
		//const vo = { seq : seq};
		const vo = {};
		vo.seq = seq;
		console.log(vo);
		console.log("JSON.stringify(vo) : " + JSON.stringify(vo));
		
		$.ajax("getJsonBoard.do", {
			method: "POST",
			data: JSON.stringify(vo), // 서버쪽으로 전달하는 데이터(JSON 형식)
			contentType: "application/json", // 서버로 전송하는 컨텐츠 유형(JSON)
			
			dataType: "json", // 서버로 부터 응답받을 데이터 형식
			success: function(respData) {
				alert("성공~~~");
				console.log(respData);
			},
			error: function(){
				alert("실패!!!");
			}
			
		});
	}
</script>
</div>

</body>
</html>











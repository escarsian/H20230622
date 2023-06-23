<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <jsp:include page="header.jsp"></jsp:include>
	<h3>상세화면 (boardOne.jsp).</h3>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("board");
	%>
	<%
	if (vo == null) {
	%>
	<p>조회된 결과가 없습니다.</p>
	<%
	} else {
	%>
	<form name="myfrm" action="modifyFrom.do" method="post">
		<input type="hidden" name="bno" value="<%=vo.getBrdNo()%>"> <!-- 파라미터 이름 bno -->
		<table class="table">

			<tr>
				<th>제목</th>
				<td><input type="text" name="title"
					value="<%=vo.getBrdTitle()%>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"
					value="<%=vo.getBrdWriter()%>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="30" rows="10"><%=vo.getBrdContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">수정</button>
					<button type="button">삭제</button>
			</tr>
		</table>
	</form>
	<%
	}
	%>
	<br>
	<a href="boardList.do">목록으로 이동.</a>
	
	<script>
	console.log(this);
	 document.querySelector('form[name="myFrm"] button[type="button"]')
	 		 .addEventListener('click', function (e) {
		 console.log(e);
		 document.forms.myFrm.action = "boardRemove.do";
		 document.forms.myFrm.submit();
		 
		 //window.location.href = "boardRemove.do?bno=3"
	 });
	</script>
    <jsp:include page="footer.jsp"></jsp:include>
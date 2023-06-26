<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <jsp:include page="header.jsp"></jsp:include>
	<h3>상세화면 (boardOne.jsp).</h3>
	
	<c:choose>
	<c:when test="${board == null }">
	<p>조회된 결과가 없습니다.</p>
	</c:when>
	<c:otherwise>
	<form name="myfrm" action="modifyFrom.do" method="post">
		<input type="hidden" name="bno" value="${board.brdNo}">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"
					value="${board.brdTitle}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"
					value="${board.brdWriter}>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="30" rows="10">${board.brdContent}</textarea></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			<c:choose>
				<c:if test="${loginId eq board.brdWriter }">
					<button type="submit">수정</button>
					<button type="button">삭제</button>
				</c:if>
				<c:if test="${loginId ne board.brdWriter }">
					<button type="submit" disabled>수정</button>
					<button type="button" disabled>삭제</button></td>
				</c:if>
			</c:choose>
			</tr>
		</table>
	</form>
	</c:otherwise>
	</c:choose>
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
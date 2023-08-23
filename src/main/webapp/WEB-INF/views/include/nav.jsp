<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="nav">
	<ul id="top-ul">
		<li id="top-li">
			<c:if test="${sessionScope.userId ne null }"> 
				<a href="/user/mypage.do?userId=${userId }">마이페이지</a>
			</c:if>
			<c:if test="${sessionScope.userId eq null }" >
				<a href="/user/login.do">로그인</a>
			</c:if>
		</li>
		<li id="top-li"><a href="/board/list.do?currentPage=1">게시판</a></li>
		<li id="top-li"><a href="/board/eventPage.do">이벤트</a></li>
		<li id="top-li"><a href="#">상점</a></li>
	</ul>
</div>
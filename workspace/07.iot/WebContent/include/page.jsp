<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<meta charset="UTF-8">
	<div class="page_list" style="text-align: center;">
	<!-- 이전/처음  -->

		<c:if test="${page.curBlock gt 1 }">
			<a class="page_first" title="처음" onclick="go_page(1)">처음</a>
			<a class="page_prev" title="이전" 
			onclick="go_page(${page.beginPage - page.blockPage})">
			이전</a>
		</c:if>
	
		<c:forEach begin="${page.beginPage}" end="${page.endPage}" var="no">
			<!-- 현재 페이지   o-->
			<c:if test="${no eq page.curPage}">
				<span class="page_on">${no}</span>
			</c:if>
			<!--현재 페이지 x  -->
			<c:if test="${no ne page.curPage}">
				<span class="page_off" onclick="go_page(${no})">${no}</span>
			</c:if>
		</c:forEach>
		
		<!-- 다음/마지막  -->
		<c:if test="${page.curBlock lt page.totalBlock}">
			<a class="page_next" title='다음' onclick="go_page(${page.endPage+1})">다음</a>
			<a class="page_last" title='마지막' onclick="go_page(${page.totalPage})">마지막</a>
		</c:if>
	</div>
	
	<script type="text/javascript">
	function go_page(page) {
		$('[name=curPage]').val (page);
		$('form').submit();
	};
	</script>
	
<%@ include file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
	</head>
	<body>
		<sec:authorize access="isAuthenticated()">
			<a href="${contextPath }/j_spring_security_logout">logout</a>
		</sec:authorize>
		
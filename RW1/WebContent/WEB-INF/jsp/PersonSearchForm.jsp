<%@ include file="common/header.jsp" %>

Person Search Form

<form:form modelAttribute="person" action="search" method="post">
	<table>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td><button type="submit">Search</button></td>
			<td><button type="reset">reset</button></td>
		</tr>
	</table>
</form:form>

<%@ include file="common/footer.jsp" %>
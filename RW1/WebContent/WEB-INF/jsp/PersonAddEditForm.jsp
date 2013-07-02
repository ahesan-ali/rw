<%@ include file="common/header.jsp" %>
	Person Add Edit Form
	
<form:form modelAttribute="person" action="save" method="post">
	<%-- <form:input path="id" /> --%>
	<table>
		<tr>
			<td><form:label path="firstName">First Name</form:label></td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td><form:label path="gender">Gender</form:label></td>
			<td><form:input path="gender" /></td>
		</tr>
		<tr>
			<td><form:label path="dob">Date of Birth</form:label></td>
			<td><form:input path="dob" /></td>
		</tr>
		<tr>
			<td><button type="submit">Save</button></td>
			<td><button type="reset">Reset</button></td>
		</tr>
	</table>
</form:form>

<%@ include file="common/footer.jsp" %>
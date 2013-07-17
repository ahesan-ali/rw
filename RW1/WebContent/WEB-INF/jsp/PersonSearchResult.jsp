<%@ include file="common/taglib.jsp" %>

<table>
	<c:forEach items="${persons}" var="person">
		<tr>
			<td>First Name</td>
			<td>${person.firstName}</td>
		</tr>
	</c:forEach>
</table>

<%-- <display:table name="personList" requestURI="getPersons" >
    <display:column property="id" title="ID" sortable="true" style="width:80px" />
    <display:column property="firstName" title="firstName" sortable="true" style="width:300px "/>
    <display:column property="lastName" title="lastName" sortable="true"  style="width:200px"/>
    <display:column property="gender" title="gender" sortable="true"  style="width:200px" />
    <display:column property="dob" title="dob" sortable="true" style="width:180px"/>
</display:table> --%>
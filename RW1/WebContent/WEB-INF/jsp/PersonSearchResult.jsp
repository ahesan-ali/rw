<%@ include file="common/taglib.jsp" %>

<display:table name="persons" requestURI="" pagesize="10"  >
    <display:column property="id" title="Id" sortable="true" />
    <display:column property="firstName" title="FirstName" sortable="true" />
    <display:column property="lastName" title="LastName" sortable="true" />
    <display:column property="gender" title="Gender" sortable="true" />
    <display:column property="dob" title="Date Of Birth" sortable="true" />
</display:table>
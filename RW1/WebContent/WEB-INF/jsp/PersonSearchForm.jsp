<%@ include file="common/header.jsp" %>

<script>

	
	jQuery.fn.serializeObject = function() {
		var arrayData, objectData;
		arrayData = this.serializeArray();
		objectData = {};

		$.each(arrayData, function() {
			var value;

			if (this.value != null) {
				value = this.value;
			} else {
				value = '';
			}

			if (objectData[this.name] != null) {
				if (!objectData[this.name].push) {
					objectData[this.name] = [ objectData[this.name] ];
				}

				objectData[this.name].push(value);
			} else {
				objectData[this.name] = value;
			}
		});

		return objectData;
	};

	$(document).ready(function() {
		$("form#person").submit(function() {
			try {
				var formData = $(this).serializeObject();
				console.log(JSON.stringify(formData, null, '\t'));
				
				var url = $(this).attr("action");
				
				$.ajax({
					
				});
				
				console.log("url = " + url);
			} catch (e) {
				console.log(e.toString());
			}
			return false;
		});
	});
</script>

Person Search Form

<form:form modelAttribute="person" action="search" method="post">
	<table>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit">Search</button></td>
		</tr>
	</table>
</form:form>

<div id="personSearchResults">
</div>

<%@ include file="common/footer.jsp" %>
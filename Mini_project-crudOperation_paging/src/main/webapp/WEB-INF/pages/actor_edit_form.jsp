<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color: re;text-align: center">Actor Details Edit page page</h1>
<frm:form modelAttribute="actor">

	<table align="center" bgcolor="cyan">
		<tr>
			<td>Actor id::</td>
			<td><frm:input type="text" path="aid" readonly="true" /></td>
		</tr>
		
		<tr>
			<td>Actor Name::</td>
			<td><frm:input type="text" path="aname"/></td>
		</tr>
		
		<tr>
			<td>Actor address::</td>
			<td><frm:input type="text" path="addrs"/></td>
		</tr>
		
		<tr>
			<td>Actor fee::</td>
			<td><frm:input type="text" path="fee"/></td>
		</tr>
		
		
		<tr>
			<td>Actor category::</td>
			<td><frm:input type="text" path="category"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value=EditActor></td>
			<td><input type="reset" value="cancel"/></td>
		</tr>
		
		
	</table>
	
	
	
	
</frm:form>
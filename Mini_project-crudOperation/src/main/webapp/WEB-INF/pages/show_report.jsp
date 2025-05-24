<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1 style="color: red;text-align: center;">Actors page</h1>

<c:choose>
	<c:when test="${!empty listActors }">
		<table border="1" align="center" bgcolor="yellow">
		<tr bgcolor="green">
			<th>Actorid</th>
			<th>Actorname </th>
			<th>acotr address</th>
			<th>fee</th>
			<th>category</th>
			<th>Operation</th>
			
		</tr>
		<c:forEach var="actor" items="${listActors}">
		<tr>
			<td> ${actor.aid}</td>
			<td>${actor.aname}</td>
			<td>${acotr.addrs}</td>
			<td>${actor.category}</td>
			<td>${actor.fee}</td>
			<td>
			<a href="edit?no=${actor.aid}" onclick=" return confirm('Inserted data successfully')" ><img src="images/edit.png"width="50px" height="50px"/></a>
			
			&nbsp;&nbsp;&nbsp;
			<a href="delete?no=${actor.aid}" onclick= " return confirm('r u sure that u want to delete record?')" ><img src="images/delete.jpeg" width="50px" height="50px" /></a>
			
			</td>
			
			
		</tr>
			
		</c:forEach>
		
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align: center;">No record found</h1>
		
	
	</c:otherwise>
			
</c:choose>

<br>
<c:if test="${!empty resultMsg}">
				<h1 style="color: green;text-align: center;">${resultMsg}</h1>
				
</c:if>
				


<br>


<h1 style="text-align: center"><a href="register"><img src="images/add.png" width="200" height="200">Register</a></h1>
<br><br>


<h1 style="text-align: center"><a href="./"><img src="images/Home1.jpeg" width="200" height="200">Home</a></h1>


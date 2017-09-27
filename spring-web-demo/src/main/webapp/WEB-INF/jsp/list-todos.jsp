
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
	<table class="table table-striped">
		<caption>Yours todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target date</th>
				<th>Is it Done</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${todos}" var="todo">

				<tr>
					<td>${todo.desc }</td>
					<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
					<td>${todo.done}</td>
					<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id }">Update</a>
					<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id }">Delete</a>
				</tr>

			</c:forEach>

		</tbody>

	</table>
	<div><a class="button" href="/add-todos"> add a todos</a></div>
	</div>
<%@ include file="common/footer.jspf" %>
	

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c3feb606cd.js"
	crossorigin="anonymous"></script>
<title>Document</title>
<style type="text/css">
.container, .row {
	padding: 30px 0;
}

.btn-delete, .btn-update {
	width: 49%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<a type="button" class="btn btn-primary btn-lg btn-block"
			href="<%=application.getContextPath()%>/add">Créer un article </a>
		<div class="row">

			<c:forEach items="${ articles }" var="article" varStatus="status">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<a href="#"></a> <a href="#"><img
							src="http://placehold.it/350x150" width="100%" height="150" /></a>
						<div class="card-body">
							<h4 class="card-title">
								<a
									href="<%=application.getContextPath()%>/article?id=${article.getId()}"><c:out
										value="${ article.getId() }${ article.getTitle() }" /></a>
							</h4>
							<h6>Par : ${ article.getAutor().getName() } ${ article.getAutor().getSurname() }
							</h6>
							<p class="card-text">
								<c:out value="${ article.getDescription() }" />
							</p>
						</div>
						<div class="card-footer">
							<p>
								Écris le :
								<c:out value="${ article.getDate() }" />
							</p>
						</div>
						<div class="card-footer">
							<a
								href="<%=application.getContextPath()%>/article?id=${article.getId()}"
								class="btn btn-primary"><i class="fab fa-readme"></i> Lire
								le post</a>
						</div>
						<div class="card-footer">
							<a
								href="<%=application.getContextPath()%>/update?id=${article.getId()}"
								class="btn btn-primary btn-update"><i class="fas fa-edit"></i>
								Modifier</a> <a
								href="<%=application.getContextPath()%>/delete?id=${article.getId()}"
								class="btn btn-danger btn-delete"><i class="fas fa-edit"></i>
								Delete</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>
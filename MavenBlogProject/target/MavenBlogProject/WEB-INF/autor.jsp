<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="fr">
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
<title>Auteur ${autor.getId() }</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<h1 class="display-4 text-center"><u>Article(s) �cris par ${ autor.getName() }</u></h1>
	
	<div class="container">
	<c:if test="${empty autorArticle}">
	<div class="alert alert-warning" role="alert">
  L'utilisateur n'a pas �cris d'article pour le moment, nous vous invitons donc � revenir plus tard. 
</div>
	</c:if>
	<div class="row">
	<c:forEach items="${ autorArticle }" var="autorArticle" varStatus="status">
		<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
					 <a href="<%=application.getContextPath()%>/article?id=${ autorArticle.getId() }"><img
							src="http://placehold.it/350x150" width="100%" height="150" /></a>
						<div class="card-body">
							<h4 class="card-title">
								<a
									href="<%=application.getContextPath()%>/article?id=${ autorArticle.getId() }">${ autorArticle.getTitle() }</a>
							</h4>
							<h6>Par : ${ autorArticle.getAutor().getName() } ${ autorArticle.getAutor().getSurname() }
							</h6>
							<p class="card-text">${ autorArticle.getDescription() }</p>
						</div>
						<div class="card-footer">
							<p>
								�cris le : ${ autorArticle.getDate() }
							</p>
						</div>
						<div class="card-footer">
							<a
								href="<%=application.getContextPath()%>/article?id=${ autorArticle.getId() }"
								class="btn btn-primary"><i class="fab fa-readme"></i> Lire
								l'article</a>
						</div>
					</div>
				</div>
</c:forEach>
	
	
	</div> 
	</div>

<c:if test="${!empty autorArticle}">
<jsp:include page="footer.jsp" />
	</c:if>
	
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
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
<title>Ajout d'un article</title>
<style type="text/css">
.container {
  padding : 30px 0;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="container">

		<form method="post">
			<div class="form-group">
				<label for="article_title">Titre (30 caractères max) <span class="text-danger">*</span> </label> <input
					type="text" name="article_title" id="article_title"
					class="form-control" placeholder="Titre de l'article..."
					maxlength="30" required="required"/>
			</div>
			<div class="form-group">
				<label for="article_content">Description (200 caractères
					max) <span class="text-danger">*</span> </label>
				<textarea type="text" class="form-control" name="article_description"
					id="article_content" rows="2" maxlength="200" required="required"></textarea>
			</div>
			<div class="form-group">
				<label for="article_content">Contenu <span class="text-danger">*</span></label>
				<textarea type="text" class="form-control" name="article_content"
					id="article_content" rows="5" required="required"></textarea>
			</div>
			<input type="submit"/>
		</form>
	</div>

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
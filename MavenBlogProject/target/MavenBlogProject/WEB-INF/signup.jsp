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
<title>Créer un compte</title>
<style type="text/css">
.form-label-group {
	padding-bottom: 15px;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Créer un compte</h5>
						<hr>
						<form method="POST">
						<div class="${!empty form.errors ? 'alert alert-danger' : ''}" role="alert">
						${form.result}
								</div>
							<div class="form-group">
								<div class="row">
									<div class="col">
										<input type="text" class="form-control" placeholder="Prénom"
											id="name" name="name" size="20" maxlength="20" value="<c:out value="${param.name}"/>">
											<span class="erreur"><small class="text-danger"> ${form.errors['name']}</small></span>
									</div>
									<div class="col">
										<input type="text" class="form-control" placeholder="Nom"
											id="surname" name="surname" size="20" maxlength="20" value="<c:out value="${param.surname}"/>">
										<span class="erreur"><small class="text-danger"> ${form.errors['surname']}</small></span>
									</div>
								</div>
							</div>
							<div class="form-group">
								<input type="text" id="email" name="email" size="20"
									maxlength="60" class="form-control" placeholder="Email" value="<c:out value="${param.email}"/>">
								<span class="erreur"><small class="text-danger"> ${form.errors['email']}</small></span>
							</div>
							<div class="form-group">
								<input type="password" id="password" name="password" size="20"
									maxlength="20" class="form-control" placeholder="Mot de passe">
								<small id="passwordHelpInline" class="text-muted"> Doit
									contenir 4 à 20 caractères. </small> 
									<span class="erreur"><small class="text-danger"> ${form.errors['password']}</small></span>
							</div>
							<div class="form-group">
								<input type="password" id="confirmation" name="confirmation"
									size="20" maxlength="20" class="form-control"
									placeholder="Confirmation du mot de passe">
									 <span class="erreur"><small class="text-danger"> ${form.errors['confirmation']}</small></span>
							</div>

							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Créer</button>
								 
						</form>

					</div>
				</div>
			</div>
		</div>
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
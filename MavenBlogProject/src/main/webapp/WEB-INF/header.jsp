<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Navbar -->
<nav class="mb-1 navbar navbar-expand-lg navbar-dark default-color bg-dark sticky-top">

<a class="navbar-brand" href="<%=application.getContextPath()%>/">Blog Java</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
    aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
    <ul class="navbar-nav mr-auto">
    
      <li class="nav-item active">
        <a class="nav-link"  href="<%=application.getContextPath()%>/articles">Articles</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link"  href="<%=application.getContextPath()%>/autors">Auteurs</a>
      </li>
      
    </ul>
    <ul class="navbar-nav ml-auto nav-flex-icons">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right dropdown-default"
          aria-labelledby="navbarDropdownMenuLink-333">
           <c:if test="${empty sessionScope.autorSession}">
                    <a class="dropdown-item" href="<%=application.getContextPath()%>/signup">
                        Créer un compte</a>
                        <div class="dropdown-divider"></div>
                </c:if>
           <c:if test="${empty sessionScope.autorSession}">
                    <a class="dropdown-item" href="<%=application.getContextPath()%>/login"> Se connecter</a>
                </c:if>
                <c:if test="${!empty sessionScope.autorSession}">
                    <a  class="dropdown-item" href="<%=application.getContextPath()%>/disconnection">Déconnexion</a>
                </c:if>
        </div>
      </li>
    </ul>
  </div>
</nav>

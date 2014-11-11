<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyager &#124; ${model.user.username}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li>Home</li> &bull;
				<li>Profile</li> &bull;
				<li>Submit</li> &bull;
				<li>Search</li>
			</ul>
		</nav>
	</header>
	<article class="bodyContainer">
		<h1>Welcome, ${model.user.username}!</h1>

	</article>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.recipe.book.model.Recipe" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Book Home</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Additional CSS styling for the page */
        .navbar-custom {
            background-color: #4CAF50;
        }
        .navbar-brand, .nav-link {
            color: white !important;
        }
        .recipe-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 16px;
            margin: 16px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
        }
        .recipe-card:hover {
            transform: scale(1.05);
        }
        .recipe-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <!-- Navbar with Search Bar, Login, and Register buttons -->
    <nav class="navbar navbar-expand-lg navbar-custom">
        <a class="navbar-brand" href="#">Recipe Book</a>
        <form class="form-inline my-2 my-lg-0" action="/api/recipe/meal/{mealType}" method="GET">
            <input class="form-control mr-sm-2" type="search" placeholder="Search Recipes" aria-label="Search" name="query">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="btn btn-primary mr-2" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-secondary" href="/register">Register</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="container my-4">
        <h2 class="text-center mb-4">Explore Our Recipes</h2>
        
        <!-- Recipe Cards Grid -->
        <div class="row">
            <c:forEach var="recipe" items="${recipes}">
                <div class="col-md-4 mb-4">
                    <div class="recipe-card card">
                        <img src="${recipe.imageUrl}" alt="${recipe.name}" class="recipe-image card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${recipe.name}</h5>
                            <p class="card-text"><strong>Cuisine:</strong> ${recipe.cuisine}</p>
                            <p class="card-text"><strong>Type:</strong> ${recipe.mealType}</p>
                            <p class="card-text">${recipe.description}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Include Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

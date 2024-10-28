<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Book</title>
    <style>
        /* Basic styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        /* Navbar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
        }
        
        .navbar a {
            color: #fff;
            text-decoration: none;
            margin-right: 10px;
        }

        /* Container and Grid */
        .container {
            padding: 20px;
        }
        
        .recipe-grid {
            display: flex;
            flex-wrap: wrap;
            gap: 16px;
        }
        
        /* Recipe card */
        .recipe-card {
            width: calc(33.33% - 20px); /* Adjust width for 3 columns */
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
            display: flex;
            flex-direction: column;
        }
        
        .recipe-card:hover {
            transform: scale(1.03);
        }

        .recipe-card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
        }

        .recipe-card h3 {
            font-size: 1.2em;
            margin: 10px;
        }

        .recipe-card p {
            font-size: 0.9em;
            color: #555;
            margin: 10px;
        }

        /* Logout button */
        .logout-btn {
            background-color: #f44336;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            float: right;
        }

        .logout-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <!-- Navbar with Logout Button -->
    <div class="navbar">
        <h2>Recipe Book</h2>
        <a class="logout-btn" href="/logout">Logout</a>
    </div>

    <!-- Page Content -->
    <div class="container">
        <h2>Available Recipes</h2>
		<a href="${pageContext.request.contextPath}recipes">View All Recipes</a>


        <!-- Recipe Cards Grid -->
        <div class="recipe-grid">
            <c:forEach var="recipe" items="${recipes}">
                <div class="recipe-card">
                    <img src="${recipe.imageUrl}" alt="${recipe.name}">
                    <h3>${recipe.name}</h3>
                    <p><strong>Cuisine:</strong> ${recipe.cuisine}</p>
                    <p><strong>Type:</strong> ${recipe.mealType}</p>
                    <p>${recipe.description}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>

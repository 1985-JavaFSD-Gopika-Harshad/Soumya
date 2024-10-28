<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>Add New Recipe</h1>
<form action="/api/recipe/" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"><br>
    Description: <textarea name="description"></textarea><br>
    Cuisine: <input type="text" name="cuisine"><br>
    Meal Type: <input type="text" name="mealType"><br>
    Ingredients: <input type="text" name="ingredients"><br>
    Instructions: <textarea name="instructions"></textarea><br>
    Image: <input type="file" name="image"><br>
    <button type="submit">Save Recipe</button>
</form>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pl">
<head>
    <title>Book listing</title>
</head>
<body>
<h1>Listing książek</h1>
<p>Aktualny czas: ${time}</p>
<p>Książek łącznie: ${listing.count}</p>
<p style="color: blue">${result}</p>
<form action="/books" method="post">
    <label for="name">Tytuł</label><input type="text" id="name" name="name" />
    <label for="author">Autor</label><input type="text" id="author" name="author" />
    <input type="submit" value="Dodaj" />
</form>
<c:choose>
    <c:when test="${listing.count > 0}">
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Tytuł</th>
                <th>Autor</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${listing.books}" var="book">
                    <tr>
                        <td><c:out value="${book.id}" /></td>
                        <td><c:out value="${book.title}" /></td>
                        <td><c:out value="${book.author}" /></td>
                        <td><a href="/books/delete/${book.id}"
                               onclick="return confirm('Czy na pewno usunąć książkę o id ${book.id}?')">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Brak książek w bazie. Dodaj jakieś.</p>
    </c:otherwise>
</c:choose>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pl">
<head>
    <title>Book listing</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>Listing książek</h1>
<p>Aktualny czas: <span id="time"></span></p>
<p>Książek łącznie: <span id="count"></span></p>
<p style="color: blue" id="result"></p>
<form id="form" action="" method="post">
    <label for="name">Tytuł</label><input type="text" id="name" name="name" />
    <label for="author">Autor</label><input type="text" id="author" name="author" />
    <input id="submit" type="button" value="Dodaj" />
</form>
<table id="datatable" style="display: none">
    <thead>
    <tr>
        <th>Id</th>
        <th>Tytuł</th>
        <th>Autor</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
<p id="nodata">Brak książek w bazie. Dodaj jakieś.</p>
<script>
    $(document).ready(
        function() {
            var removeBook = function(book) {
                if (confirm('Czy na pewno usunąć książkę o id ' + book.id + '?')) {
                    $.ajax({url: '/api/books/' + book.id, type: 'DELETE'})
                        .done(function () { $("#result").text("Książka o id " + book.id + " została usunięta.");})
                        .done(loadListing);
                }
            };
            var addBook = function(book) {
                $("#datatable > tbody")
                    .append("<tr id='row-" + book.id + "'><td>" + book.id + "</td><td>" + book.title + "</td><td>"
                    + book.author + "</td><td><a href='javascript: void(0)'>Usuń</a></td></tr>");
                $("#row-" + book.id + " a").on('click', function() {removeBook(book);});
            };
            var reloadTable = function(json) {
                $("#count").text(json.count);
                if (json.count) {
                    $("#datatable").show();
                    $("#nodata").hide();
                    $("#datatable > tbody").html("");
                    $("input[name='name']").val("");
                    $("input[name='author']").val("");
                    json.books.forEach(addBook);
                } else {
                    $("#datatable").hide();
                    $("#nodata").show();
                }
            };
            var loadListing = function() {
                $.get({url: "/api/books", dataType: "json"}).done(reloadTable);
            };
            var sendForm = function() {
                var data = JSON.stringify({
                    title: $("input[name='name']").val(),
                    author: $("input[name='author']").val()
                });
                $.ajax({
                    url: "/api/books",
                    type: 'POST',
                    data: data,
                    contentType:"application/json; charset=utf-8",
                    dataType: "json"})
                    .done(function() { $("#result").text("Książka została dodana."); })
                    .done(loadListing);
            };
            var init = function() {
                $("#submit").on('click', sendForm);
                setInterval(function () { $("#time").text(new Date()); }, 1000);
                loadListing();
            };

            init();
        }
    );
</script>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="NoteServlet">
        <label>Title: </label>
        <input type="text" name="title" value="${Note.getTitle()}">
        <br>
        <label>Contents: </label>
        <textarea name="content" cols="25" rows="15">${Note.getContents()}</textarea>
        <br>
        <input type="submit" name="sub" value="Save">
        </form>
    </body>
</html>

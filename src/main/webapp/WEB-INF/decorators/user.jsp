<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><sitemesh:write property="title"/> | BookStore</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">
    <style>
        body { min-height: 100vh; display: flex; flex-direction: column; background: #f6f7fb; }
        main { flex: 1; }
        .book-cover { width: 100%; aspect-ratio: 3 / 4; object-fit: cover; }
    </style>
    <sitemesh:write property="head"/>
</head>
<body>
<%@ include file="/WEB-INF/includes/header.jspf" %>

<main class="container py-4">
    <sitemesh:write property="body"/>
</main>

<%@ include file="/WEB-INF/includes/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

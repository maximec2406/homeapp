<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="bean" scope="request" type="ru.homeapp.web.AddBookCompleteBean" />
<html>
<head>
    <title>Part added</title>
</head>
<body>
<h1>Part has been added successfully.</h1>
<div>
    <p>Part ID: ${bean.partId}</p>
    <p>Title: ${bean.title}</p>
    <p>Supplier: ${bean.supplierName}</p>
</div>

<p>
    <a href="/">Home</a>
</p>
</body>
</html>

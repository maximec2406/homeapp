<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="indexBean" type="ru.homeapp.web.IndexBean" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <tbody>

        <c:forEach var="book" items="${indexBean.books}">
            <tr>
                <td>${book.name}</td>
                <%--<td>--%>
                    <%--<c:if test="${part.legacy}">Legacy</c:if>--%>
                <%--</td>--%>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <p>
        <a href="/add-book">Add book...</a>
    </p>
</div>
</body>
</html>

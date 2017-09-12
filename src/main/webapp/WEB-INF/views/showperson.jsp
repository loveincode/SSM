<%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>person list</title>
    </head>
    <body>
        <table>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
            <c:forEach items="${persons}" var="person">
                <tr>
                    <td>${person.name }</td>
                    <td>${person.age }</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
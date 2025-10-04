<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: My Best
  Date: 2025/10/04
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>List flight</h3>
    <table border="1">
        <thead>
        <tr>
            <th>No</th>
            <th>Flight Id</th>
            <th>Flight Name</th>
            <th>Starting Point</th>
            <th>Destination</th>
            <th>Departure Date</th>
            <th>Travel Time</th>
            <th>Time Unit</th>
            <th>Travel Image</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listFlight}" var="fight" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${loop.flightId}</td>
                <td>${loop.fightName}</td>
                <td>${loop.startingPoint}</td>
                <td>${loop.destination}</td>
                <td>${loop.departureDate}</td>
                <td>${loop.travelTime}</td>
                <td>${loop.TimeUnit}</td>
                <td><img src="${flight.image}" width="100" height="100" alt="${fight.flightName}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${flight.status == 0}">Hủy bỏ</c:when>
                        <c:when test="${flight.status == 1}">Đang thực hiện</c:when>
                        <c:when test="${flight.status == 2}">Hoàn thành</c:when>
                        <c:otherwise>Unknown</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href= "<%=request.getContextPath()%>/flightController/initCreate">Create new Flight..."</a>
</body>
</html>

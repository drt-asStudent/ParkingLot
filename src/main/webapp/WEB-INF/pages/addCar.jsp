<%--
  Created by IntelliJ IDEA.
  User: dan_t
  Date: Tue, 25-Nov-25
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>unTitled</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/AddCar">
<label for="license_plate">License Plate</label>
    <input type="text" name="license_plate" id="license_plate">

<label for="parking_slot">Parking Slot</label>
    <input type="text" name="parking_slot" id="parking_slot">

<label for="ownner_id">Owner ID</label>
    <select type="text" name="ownner_id" id="ownner_id">
        <option value="">Choose...</option>
    </select>
</form>
</body>
</html>

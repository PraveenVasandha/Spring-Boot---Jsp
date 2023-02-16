<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="POST" action="edit-team-leader" model="tlDto">

    <input type="hidden" path="id" name="id" value="${tlDto.id}" />
 <%--   <td><form:hidden path="id"/></td>--%>
    <div>

        <input type="text" placeholder="Name" path="name" name="name" value="${tlDto.name}">
        <br>
        <br>
        <input type="text" placeholder="EmailId" path="emailId" name="emailId" value="${tlDto.emailId}">
        <br>
        <br>
        <input type="text" placeholder="Age" path="age" name="age" value="${tlDto.age}">
        <br>
        <br>
        <input type="text" placeholder="OfficeName" path="officeName" name="officeName" value="${tlDto.officeName}">
        <br>
        <br>
        <input type="text" placeholder="Country" path="country" name="country" value="${tlDto.country}">
        <br>
        <br>
        <input type="text" placeholder="State" path="state" name="state" value="${tlDto.state}">
        <br>
        <br>
        <input type="text" placeholder="District" path="district" name="district" value="${tlDto.district}">
        <br>
        <br>
        <input type="text" placeholder="Village" path="village" name="village" value="${tlDto.village}">
        <br>
        <br>
        <input type="text" placeholder="Pincode" path="pincode" name="pincode" value="${tlDto.pincode}">
        <br>
        <br>
        <button type="submit" class="btn btn-primary  btn-md">Submit</button>
    </div>

</form>
</body>
</html>
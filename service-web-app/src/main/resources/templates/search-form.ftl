<@layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>My Service</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <div align="center">

        <form action="/admin/search" method="post" modelAttribute="searchForm" id="searchForm" name="searchForm">

            <label for="search">Search</label>
            <input id="search" type="text" name="search" placeholder="Search by e-mail or afm "/>
            <input type="submit" value="search"/>

        </form>
    </div>

    <h2 align="center">${errorMessage!""}</h2>
    <#if customer??>

            <h2 class="well">Customer Info</h2>
            <div class="col-lg-12 well">
                <div class="row">
                    <form action="/admin/search/update" method="post" id="userDetails" name="userDetails">
                        <div class="col-sm-12">
                            <input id="userId" name="userId" type="hidden" value="${customer.userId}" class="form-control" required readonly>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Users's ID</label>
                                 <input id="userId" name="userId" type="text" value="${customer.userId}" placeholder="Enter ID Here.." class="form-control" required>
                                </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>First Name</label>
                                 <input id="firstName" name="firstName" type="text" value="${customer.firstName}" placeholder="Enter First Name Here.." class="form-control" required>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Last Name</label>
                                    <input id="lastName" name="lastName" type="text" value="${customer.lastName}" placeholder="Enter Last Name Here.." class="form-control" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Tax ID</label>
                                    <input id="afm" name="afm" type="text" value="${customer.afm}" placeholder="Enter Tax ID Here.." class="form-control" required>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Plate Number</label>
                                    <input id="plates" name="plates" type="text" value="${customer.plates}" placeholder="Enter Plate Number Here.." class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input id="address" name="address" type="text" value="${customer.address}" placeholder="Enter Address Here.." class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email Address</label>
                                <input id="email" name="email" type="text" value="${customer.email}" placeholder="Enter Email Address Here.." class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input id="pass" name="password" type="password" value="${customer.password}" placeholder="Enter Password Here.." class="form-control" required>
                            </div>
                            <div class="form-group">
                                <br><label>Role</label> &emsp;
                                <input name="role" type="radio" value="USER" checked> Customer &emsp;
                                <input name="role" type="radio" value="ADMIN"> Admin<br>
                            </div>
                            <button type="submit" class="btn btn-lg btn-info" OnClick="updateFunction()">Update</button>
                            <button type="submit" class="btn btn-lg btn-info" OnClick="deleteFunction()">Delete</button>
                        </div>
                    </form>
                </div>
            </div>
    </#if>
</div>

<script language="JavaScript">
    function updateFunction() {
        document.forms["userDetails"].action = "/admin/search/update";
    }

    function deleteFunction() {
        document.forms["userDetails"].action = "/admin/search/delete";
    }
</script>

</body>
</html>
</@layout>
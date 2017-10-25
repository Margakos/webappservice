<@layout>
        <!DOCTYPE html>
<html lan="en">
<head>
    <title>My Service</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>


<div align="center">

    <form action="/admin/search" method="post" modelAttribute="searchForm" id="searchForm" name="searchForm">

        <label for="search">Search</label>
        <input id="search" type="text" name="search" placeholder="search"/>
        <input type="submit" value="search"/>

    </form>

    <h2>${errorMessage!""}</h2>
    <#if customer??>

    <h3>Results</h3>


    <form action="/admin/search/update" method="post" id="userDetails" name="userDetails" >

    <label for="id"> Id:</label>
    <input id="id" type="text" name="userId" value="${customer.userId}" readonly="readonly" />
</br>
<label for="afm">Afm:</label>
<input id="afm" type="text" name="afm" value="${customer.afm}" />
</br>

<label for="password">Password:</label>
<input id="password" type="text" name="password" value="${customer.password}" />
</br>

<label for="firstName">First Name:</label>
<input id="firstName" type="text" name="firstName" value="${customer.firstName}"/></br>

<label for="lastName"> Last Name:</label>
<input id="lstName" type="text" name="lastName" value="${customer.lastName}" /></br>

<label for="email">Email:</label>
<input id="email" type="text" name="email" value="${customer.email}" /></br>

<label for="address">Address:</label>
<input id="address" type="text" name="address" value="${customer.address}" /></br>

<label for="role">Role:</label>
<input id="role" type="text" name="role" value="${customer.role}" />

<button  type="submit"  OnClick="updateFunction()">Update</button>
<button  type="submit" OnClick="deleteFunction()">Delete</button>
        </form>

        </#if>

        </div>

</body>

<script language="JavaScript">

         function updateFunction(){
        document.forms["userDetails"].action="/admin/search/update";
        }
        function deleteFunction(){
        document.forms["userDetails"].action="/admin/search/delete";
        }



        </script>
        </html>
</@layout>
<@layout>
        <!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html lan="en">
<head>
    <title>My Service</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1></h1>
<h2>${message!""}</h2>
<h2>${errorMessage!""}</h2>

<div align="center">
    <form action="/admin/search/update" method="post" modelAttribute="updateUser" id="updateUser" name="updateUser">


        <label for="firstName">First Name</label>
        <input id="firstName" type="text" name="firstName" value="${customer.firstName}" placeholder="enter the first name" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>

        <label for="lastName">Last Name</label>
        <input id="lastName" type="text" name="lastName" value="${customer.lastName}" placeholder="enter the last name" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>

        <label for="email">Email</label>
        <input id="email" type="text" name="email" value="${customer.email}" placeholder="enter the email" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>

        <label for="address">Address</label>
        <input id="address" type="text" name="address" value="${customer.address}" placeholder="enter the address" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>

        <label for="pass">Password</label>
        <input id="pass" type="password" name="password" value="${customer.password}" placeholder="enter the password" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>

        <label for="afm">AFM</label>
        <input id="afm" type="password" name="afm" value="${customer.afm}" placeholder="enter the afm" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>

        <label for="plates">Plates</label>
        <input id="plates" type="text" name="plates" value="${customer.plates}" placeholder="enter the plate" required=true/>
        <#list spring.status.errorMessages as error>
        <span>${error}</span>
        </#list>
</br></br>


<#--bind this field with the registration form fields-->
<@spring.bind "createUser.role"/>
<label for="role">Role</label>
<select id="role" name="Role">
<option value="ADMIN" label="admin"/>
<option value="USER" label="user"/>
</select>
<#--<input id="role" type="text" name="type" placeholder="enter the type" value="${createRepair.type!""}" required=true/>-->
<#--dispay validation error message here for this field-->
<#list spring.status.errorMessages as error>
<span>${error}</span>
        </#list>

<#list spring.status.errorMessages as error>
<span>${error}</span>
        </#list>
<input type="submit" value="create"/>
        </form>
        </div>

        </body>
        </html>
        </@layout>
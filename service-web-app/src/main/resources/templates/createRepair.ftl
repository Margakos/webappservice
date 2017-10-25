<@layout>
        <!DOCTYPE html>
<#import "/spring.ftl" as spring/>

<html lan="en">
<head>
    <title>My Service</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>



<h2>${message!""}</h2>
<h2>${errorMessage!""}</h2>



<div class="container">
<form action="/admin/create/repair" method="post" id="createRepair" name="createRepair">

    <#--bind this field with the registration form fields-->
    <@spring.bind "createRepair.type"/>
    <label for="type">Type</label>
    <select id="type" name="Type">
        <option value="Small" label="small"/>
        <option value="Large" label="large"/>
    </select>
    <#--<input id="type" type="text" name="type" placeholder="enter the type" value="${createRepair.type!""}" required=true/>-->
    <#--dispay validation error message here for this field-->
    <#list spring.status.errorMessages as error>
    <span>${error}</span>
</#list>

<@spring.bind "createRepair.userId"/>
<label for="userId">User ID</label>
<input id="userId" type="number" name="userId" placeholder="enter the type"  required=true/>
<#--dispay validation error message here for this field-->
<#list spring.status.errorMessages as error>
<span>${error}</span>
</#list>


<@spring.bind "createRepair.description"/>
<label for="description">Description</label>
<input id="description" type="text" name="description" placeholder="enter the description"required=true/>
<#list spring.status.errorMessages as error>
<span>${error}</span>
        </#list>

<@spring.bind "createRepair.cost"/>
<label for="cost">Cost</label>
<input id="cost" type="text" name="cost" placeholder="enter the cost"required=true/>
<#list spring.status.errorMessages as error>
<span>${error}</span>
        </#list>

<@spring.bind "createRepair.arriveDate"/>
<label for="arriveDate">Arrive Date</label>
<input id="arriveDate" type="datetime-local" name="arriveDate" placeholder="enter the arrive date"required=true/>
<#list spring.status.errorMessages as error>
<span>${error}</span>
        </#list>

<@spring.bind "createRepair.status"/>
<label for="status">Status</label>
<select id="status" name="Status">
<option value="Pending" label="pending"/>
<option value="inProgress" label="in Progress"/>
<option value="Completed" label="completed"/>
</select>
<#list spring.status.errorMessages as error>
<span>${error}</span>
        </#list>




<input type="submit" value="create"/>
        </form>


        </div>

        </body>
        </html>
        </@layout>





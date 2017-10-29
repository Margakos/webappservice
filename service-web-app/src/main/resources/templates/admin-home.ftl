<@layout>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<h2 style="color:red"> ${errorMessage!""}</h2>

<h2 style="color:green">${message!""}</h2>

<div class="container">
    <h2 class="well"> Your upcoming Repairs</h2>

<#if repairs??>
<div class="well">
    <table class="table">
        <thead>
            <tr>
                <th>Repair ID</th>
                <th>Type</th>
                <th>Cost</th>
                <th>Description</th>
                <th>Arrival Date</th>
                <th>Status</th>
                <th>User ID</th>
            </tr>
        </thead>
        <tbody>
            <#list repairs as myRepair>
            <tr>
                <td>${myRepair.id}</td>
                <td>${myRepair.type}</td>
                <td>${myRepair.cost}</td>
                <td>${myRepair.description}</td>
                <td>${myRepair.arriveDate}</td>
                <td>${myRepair.status}</td>
                <td>${myRepair.userId}</td>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
    </div>
<#else>

</#if>


</div>
</body>
</html>
</@layout>
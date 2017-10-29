<@layout>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<h2 style="color:red"> ${errorMessage!""}</h2>

<h2 style="color:green">${message!""}</h2>

<div class="container">
    <h2> Your upcoming Repairs</h2>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-8">
            <form name="createRepair" action="/admin/home" method="post">

            </form>
     <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
<#if repairs??>
    <h3>Retrieved repairs:</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Repair's ID</th>
            <th>Type</th>
            <th>Cost</th>
            <th>Description</th>
            <th>Arrival Date</th>
            <th>Status</th>
            <th>User's ID</th>

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


                    </form>
                </td>
            </tr>
            </#list>
    </table>
<#else>

</#if>


</div>
</body>
</html>
</@layout>
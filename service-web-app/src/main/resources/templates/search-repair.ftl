<@layout>
<!DOCTYPE html>
<html lan="en">
<head>
    <title>My Service</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>



<div class="container">
    <h2> Your upcoming Repairs</h2>
        <div class="row">
    <h2 style="color:red">${errorMessage!""}</h2>
       <div class="col-sm-4 col-sm-offset-8">
    <form action="/admin/search/repair" method="post"  name="repairSearch" id="repairSearch">
           <!-- /input-group -->
                </div>
        <label for="arriveDate">Search before Date: </label>
        <input id="arriveDate" type="datetime-local" name="arriveDate" placeholder=""/>
        <input type="submit" value="search"/>

    </form>
      <br/><br/>
    <div class="container">

        <h2 style="color:red">${errorMessage!""}</h2>
         <div class="row">
            <div class="col-sm-4 col-sm-offset-8">
        <form action="/admin/search/repair/between" method="post"  name="repairSearchBetween" id="repairSearchBetween">

            <label for="arriveDate1">From</label>
            <input id="arriveDate1" type="datetime-local" name="first" placeholder=""/>

            <label for="arriveDate2">To</label>
            <input id="arriveDate2" type="datetime-local" name="last" placeholder=""></input>
            <input type="submit" value="search"/>

        </form>
          <!-- /input-group -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
<#if myRepairs??>



    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Cost</th>
            <th>Arrive Day</th>
            <th>Type</th>
            <th>Status</th>
            <th>Edit</th>
            <th>Update</th>
        </tr>
        </thead>

        <tbody>
        <#list myRepairs as repair>
        <tr>
            <td>${repair.getId()}</td>
            <td>${repair.getDescription()}</td>
            <td>${repair.getCost()}</td>
            <td>${repair.getArriveDate()}</td>
            <td>${repair.getType()}</td>
            <td>${repair.getStatus()}</td>
            <form method="POST" action="/admin/repair/delete/${repair.id}">
            <td><input type="submit" value="DELETE"></input></td>
            </form>
            <form method="GET" action="/admin/update/repair/${repair.id}">
            <td><input type="submit" value="UPDATE"></input></td>
            </form>

    </td>
        </tr>




    </#list>
    </table>

</#if>

</div>
</body>
</html>
</@layout>
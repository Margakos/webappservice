<@layout>
        <!DOCTYPE html>

<html lan="en">
<head>
    <title>My Service</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>


<div align="center">
    <form action="/admin/update/repair" method="post"  id="createRepair" name="createRepair">

        <input type="hidden" name="id" value="${createRepair.id}"/>

        <label for="cost">Cost</label>
        <input id="cost" type="text" name="cost" placeholder="enter the cost" value="${createRepair.cost}" required=true/>
    <br/><br/>

<label for="description">Description</label>
<input id="description" type="text" name="description" value="${createRepair.description}" placeholder="enter the description of repair" required=true/>
</br></br>

<label for="date">Date</label>
<input id="date" type="datetime-local" name="arriveDate" value="${createRepair.arriveDate}" placeholder="Enter the started day of service" required=true/>
        <br/><br/>

<label for="type">Type</label>
<select id="type" name="Type">
<option value="Small" label="small"/>
<option value="Large" label="large"/>
</select>
<br/><br/>
<label for="userId">User ID</label>
<input id="userId" type="number" name="userId" value="${createRepair.userId}" placeholder="enter the type"  required=true/>

<label for="status">Status</label>
<select id="status" name="Status">
<option value="Pending" label="pending"/>
<option value="inProgress" label="in Progress"/>
<option value="Completed" label="completed"/>
</select>
        <br/><br/>



<input type="submit" value="update"/>
        </form>


        </div>

        </body>
        </html>
        </@layout>
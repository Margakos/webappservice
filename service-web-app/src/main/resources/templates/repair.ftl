<@layout>
<!DOCTYPE html>

<html lan="en">
<head>
<title>My Service</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>


<div align="center">
<form action="/admin/create/repair" method="post"  id="createRepair" name="createRepair">

<label for="cost">Cost</label>
<input id="cost" type="text" name="cost" placeholder="enter the cost" required=true/>
</br></br>

<label for="description">Description</label>
<input id="description" type="text" name="description" placeholder="enter the description of repair" required=true/>
</br></br>

<label for="date">Date</label>
<input id="date" type="date" name="date" placeholder="Enter the started day of service" required=true/>
</br></br>

<label for="address">Address</label>
<input id="address" type="text" name="address" placeholder="enter the address" required=true/>
</br></br>



<input type="submit" value="create"/>
</form>


</div>

</body>
</html>
</@layout>
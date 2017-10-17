<!DOCTYPE html>

<html lan="en">
<head>
<title>My Service</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>


<div align="center">
<form action="/" method="post" modelAttribute="userRegistration" id="userCreation" name="userCreation">

<label for="firstName">First Name</label>
<input id="firstName" type="text" name="firstName" placeholder="enter the first name" required=true/>
</br></br>

<label for="lastName">Last Name</label>
<input id="lastName" type="text" name="latsName" placeholder="enter the last name" required=true/>
</br></br>

<label for="email">Email</label>
<input id="email" type="text" name="email" placeholder="enter the email" required=true/>
</br></br>

<label for="address">Address</label>
<input id="address" type="text" name="address" placeholder="enter the address" required=true/>
</br></br>

<label for="pass">Password</label>
<input id="pass" type="password" name="password" placeholder="enter the password" required=true/>
</br></br>

<label for="afm">AFM</label>
<input id="afm" type="password" name="password" placeholder="enter the afm" required=true/>
</br></br>

<label for="plates">Plates</label>
<input id="plates" type="text" name="plates" placeholder="enter the plates" required=true/>
</br></br>



<input type="submit" value="create"/>
</form>


</div>

</body>
</html>
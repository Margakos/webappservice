<!DOCTYPE html>

<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

<div class="container container-table">
    <div class="row vertical-center-row">
<div class="col-md-4 inputGroupContainer" align="center">

<form action="/" method="post" id="loginForm" name="loginForm">
</br>
<label for="username">Username</label>
<input id="username" class="form-control input-sm"  id="ex2" type="email" name="username" placeholder="Enter your email" required=true/>
</br></br>
<label for="password">Password</label>
<input id="password" class="form-control input-sm" id="ex2" type="password" name="password" placeholder="Enter your password " required=true/>
</br></br>
<input type="submit" class="btn btn-info" value="Sing In"/>
</form>
</div>

<div align="center">
<h2>${message!""}</h2>
<h2 style="color: red">${errorMessage!""}</h2>
</div>
</div>
</div>
</div>
</body>


</html>
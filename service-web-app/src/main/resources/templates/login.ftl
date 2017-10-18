<!DOCTYPE html>

<html>
<head>
</head>
<body>


<div align="center">

<form action="/login" method="post" id="loginForm" name="loginForm">
</br>
<label for="username">Username</label>
<input id="username" type="email" name="username" placeholder="Enter your email" required=true/>
</br></br>
<label for="password">Password</label>
<input id="password" type="password" name="password" placeholder="Enter your password " required=true/>
</br></br>
<input type="submit" value="submit"/>
</form>
</div>

<div align="center">
<h2>${message!""}</h2>
<h2 style="color: red">${errorMessage!""}</h2>
</div>

</body>


</html>
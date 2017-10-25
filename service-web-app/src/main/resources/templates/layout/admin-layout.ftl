<#macro layout>

<!doctype html>
<html lan="en">
<head>
<meta charset="UTF-8">
<title>Auto Service</title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<nav class="navbar navbar-default">
  <div class="container">
     <div id="navbar" class="college navbar-collapse">
        <ul class="nav navbar-nav">
          <li><a href="/admin/home">Home</a></li>
          <li><a href="/admin/create">New customer</a></li>
          <li><a href="/admin/create/repair">Create new repair</a></li>
          <li><a href="/admin/search">Search</a></li>
          <li><a href="/logout">Logout</a></li>

        </ul>

     </div>
   </div>
  </nav>
<div class="container">
  <h3>Administrator Page</h1>
  <#nested>
  </div>
</body>

</head>

</html>
</#macro>
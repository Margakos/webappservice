<@layout>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>My Service</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h2>${message!""}</h2>
            <h2>${errorMessage!""}</h2>

            <h2 class="well">New Customer</h2>
            <div class="col-lg-12 well">
                <div class="row">
                    <form action="/admin/create" method="post" modelAttribute="createUser" id="createUser" name="createUser">
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>First Name</label>
                                    <input id="firstName" name="firstName" type="text" placeholder="Enter First Name Here.." class="form-control" required>
                                   <#if error??>
                                    <#list error as errors>
                                        <span>${error}</span>
                                    </#list>
                                </#if>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Last Name</label>
                                    <input id="lastName" name="lastName" type="text" placeholder="Enter Last Name Here.." class="form-control" required>
                                        <#if error??>
                                        <#list error as errors>
                                        <span>${error}</span>
                                    </#list>
                                </#if>
                        </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label>Tax ID</label>
                                    <input id="afm" name="afm" type="text" placeholder="Enter Tax ID Here.." class="form-control" required>
                                        <#if error??>
                                        <#list error as errors>
                                        <span>${error}</span>
                                    </#list>
                                </#if>
                            </div>
                                <div class="col-sm-6 form-group">
                                    <label>Plate Number</label>
                                    <input id="plates" name="plates" type="text" placeholder="Enter Plate Number Here.." class="form-control" required>
                                        <#if error??>
                                        <#list error as errors>
                                        <span>${error}</span>
                                    </#list>
                                </#if>
                               </div>
                                </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input id="address" name="address" type="text" placeholder="Enter Address Here.." class="form-control" required>
                                    <#if error??>
                                    <#list error as errors>
                                    <span>${error}</span>
                                </#list>
                            </#if>
                             </div>
                            <div class="form-group">
                                <label>Email Address</label>
                                <input id="email" name="email" type="text" placeholder="Enter Email Address Here.." class="form-control" required>
                                    <#if error??>
                                    <#list error as errors>
                                    <span>${error}</span>
                                </#list>
                            </#if>
                           </div>
                            <div>
                                <label>Password</label>
                                <input id="pass" name="password" type="password" placeholder="Enter Password Here.." class="form-control" required>
                                    <#if error??>
                                    <#list error as errors>
                                    <span>${error}</span>
                                </#list>
                            </#if>
                            </div>
                            <div class="form-group">
                                <br><label>Role</label> &emsp;
                                <input name="role" type="radio" value="USER" checked> Customer &emsp;
                                <input name="role" type="radio" value="ADMIN"> Admin<br>
                            </div>
                            <button type="submit" class="btn btn-lg btn-info">Create</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
</@layout>
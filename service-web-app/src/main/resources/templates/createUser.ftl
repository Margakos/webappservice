<#import "/spring.ftl" as spring/>




<h2>${message!""}</h2>
<h2>${errorMessage!""}</h2>



<div class="container">
<form action="/admin/create" method="post" id="createUser" name="createUser">

<#--bind this field with the registration form fields-->
 <@spring.bind "createUser.firstName"/>
<label for="firstName">First Name</label>
<input id="firstName" type="text" name="firstName" placeholder="enter the first name" required=true/>
<#--dispay validation error message here for this field-->
 <#list spring.status.errorMessages as error>
        <span>${error}</span>
 </#list>

<@spring.bind "createUser.lastName"/>
<label for="lastName">Last Name</label>
<input id="lastName" type="text" name="lastName" placeholder="enter the last name"required=true/>
<#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

<@spring.bind "createUser.email"/>
<label for="email">Email</label>
<input id="email" type="text" name="email" placeholder="enter the email"required=true/>
<#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

<@spring.bind "createUser.address"/>
<label for="address">Address</label>
<input id="address" type="text" name="address" placeholder="enter the address"required=true/>

<@spring.bind "createUser.password"/>
<label for="pass">Password</label>
<input id="pass" type="password" name="password" placeholder="enter the password"required=true/>

<@spring.bind "createUser.afm"/>
<label for="afm">AFM</label>
<input id="afm" type="password" name="afm" placeholder="enter the afm"required=true/>
<#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

<@spring.bind "createUser.plates"/>
<label for="plates">Plates</label>
<input id="plates" type="text" name="plates" placeholder="enter the plates"required=true/>
<#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>

<@spring.bind "createUser.role"/>
<label for="role">Role</label>
<input id="role" type="text" name="role" placeholder="enter the role of the user"required=true/>
<#list spring.status.errorMessages as error>
        <span>${error}</span>
    </#list>



<input type="submit" value="create"/>
</form>


</div>



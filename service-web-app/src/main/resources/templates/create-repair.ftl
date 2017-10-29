<@layout>
<!DOCTYPE html>
    <#import "/spring.ftl" as spring/>

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

            <h2 class="well">Create Repair</h2>
            <div class="col-lg-12 well">
                <div class="row">
                    <form action="/admin/create/repair" method="post" id="createRepair" name="createRepair">
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <@spring.bind "createRepair.userId"/>
                                    <label>User Id</label>
                                    <input id="userId" name="userId" type="text" placeholder="Enter User Id Here.." class="form-control" required>
                                    <#list spring.status.errorMessages as error>
                                        <span>${error}</span>
                                    </#list>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <@spring.bind "createRepair.type"/>
                                    <label>Service Type</label><br>
                                    <input name="type" type="radio" value="Small" checked> Small &emsp; &emsp;
                                    <input name="type" type="radio" value="Large"> Large<br>
                                    <#list spring.status.errorMessages as error>
                                        <span>${error}</span>
                                    </#list>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <@spring.bind "createRepair.arriveDate"/>
                                    <label>Arrival</label>
                                    <input id="arriveDate" name="arriveDate" type="datetime-local" placeholder="Enter Arrival Date Here.." class="form-control" required>
                                    <#list spring.status.errorMessages as error>
                                        <span>${error}</span>
                                    </#list>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <@spring.bind "createRepair.status"/>
                                    <label>Status</label>
                                    <select id="status" name="Status" class="form-control">
                                        <option value="Pending">Pending</option>
                                        <option value="inProgress">In Progress</option>
                                        <option value="Completed">Completed</option>
                                    </select>
                                    <#list spring.status.errorMessages as error>
                                        <span>${error}</span>
                                    </#list>
                                </div>
                            </div>
                            <div class="form-group">
                                <@spring.bind "createRepair.description"/>
                                <label>Description</label>
                                <textarea id="description" name="description" type="textarea" placeholder="Enter Description Here.." class="form-control" maxlength="200" rows="4" required></textarea>
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                            <div class="form-group">
                                <@spring.bind "createRepair.cost"/>
                                <label>Cost</label>
                                <input id="cost" name="cost" type="text" placeholder="Enter Cost Here.." class="form-control" required>
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                            <button type="submit" class="btn btn-lg btn-info">Add Repair</button>
                        </div>

                    </form>
                </div>
            </div>

        </div>
        <script language="JavaScript">
            function passId() {
                document.forms["createRepair"].getElementById("userId").value = "";
            }
        </script>

    </body>
</html>
</@layout>


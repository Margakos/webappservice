<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
        <title>Auto Service</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
        <style>
            @import "font-awesome.min.css";
            @import "font-awesome-ie7.min.css";

            body, html {
                height: 100%;
                background-repeat: no-repeat;
                background-image: url("/REPAIR.png");
                background: rgb(185, 210, 224); /* Old browsers */
                background: -moz-radial-gradient(center, ellipse cover, rgba(185, 210, 224, 1) 0%, rgba(187, 214, 228, 1) 0%, rgba(186, 211, 225, 1) 15%, rgba(186, 211, 225, 1) 38%, rgba(169, 199, 215, 1) 68%, rgba(169, 199, 215, 1) 68%, rgba(169, 199, 215, 1) 82%, rgba(158, 191, 208, 1) 100%); /* FF3.6-15 */
                background: -webkit-radial-gradient(center, ellipse cover, rgba(185, 210, 224, 1) 0%, rgba(187, 214, 228, 1) 0%, rgba(186, 211, 225, 1) 15%, rgba(186, 211, 225, 1) 38%, rgba(169, 199, 215, 1) 68%, rgba(169, 199, 215, 1) 68%, rgba(169, 199, 215, 1) 82%, rgba(158, 191, 208, 1) 100%); /* Chrome10-25,Safari5.1-6 */
                background: radial-gradient(ellipse at center, rgba(185, 210, 224, 1) 0%, rgba(187, 214, 228, 1) 0%, rgba(186, 211, 225, 1) 15%, rgba(186, 211, 225, 1) 38%, rgba(169, 199, 215, 1) 68%, rgba(169, 199, 215, 1) 68%, rgba(169, 199, 215, 1) 82%, rgba(158, 191, 208, 1) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#b9d2e0', endColorstr='#9ebfd0', GradientType=1); /* IE6-9 fallback on horizontal gradient */

            }

            body {
                padding-top: 20px;
                padding-bottom: 20px;
            }

            .header,
            .marketing,
            .footer {
                padding-right: 15px;
                padding-left: 15px;
            }

            .header {
                border-bottom: 1px solid #e5e5e5;
            }

            .header h3 {
                padding-bottom: 19px;
                margin-top: 0;
                margin-bottom: 0;
                line-height: 40px;
            }

            /* Custom page footer */
            .footer {
                padding-top: 19px;
                color: #777;
                border-top: 1px solid #e5e5e5;
            }

            /* Customize container */
            @media (min-width: 768px) {
                .container {
                    max-width: 730px;
                }
            }

            .container-narrow > hr {
                margin: 30px 0;
            }

            /* Main marketing message and sign up button */
            .jumbotron {
                text-align: center;
                border-bottom: 1px solid #e5e5e5;
            }

            .jumbotron .btn {
                padding: 14px 24px;
                font-size: 21px;
            }

            /* Supporting marketing content */
            .marketing {
                margin: 40px 0;
            }

            .marketing p + h4 {
                margin-top: 28px;
            }

            /* Responsive: Portrait tablets and up */
            @media screen and (min-width: 768px) {
                /* Remove the padding we set earlier */
                .header,
                .marketing,
                .footer {
                    padding-right: 0;
                    padding-left: 0;
                }

                /* Space out the masthead */
                .header {
                    margin-bottom: 30px;
                }

                /* Remove the bottom border on the jumbotron for visual effect */
                .jumbotron {
                    border-bottom: 0;
                }
            }
        </style>
    </head>
</head>
<body>
<nav class="navbar navbar-default">
            <div class="container">
                <div id="navbar" class="college navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/user/home">Home</a></li>
                        <li><a href="/user/home">Imidiate Help</a></li>
                        <li><a href="/user/home">My Vehicle</a></li>
                        <li><a href="/user/home">Contact</a></li>
                        <li><a href="/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

<h2 style="color:red"> ${errorMessage!""}</h2>

<h2 style="color:green">${message!""}</h2>

<div class="container">
    <h2> Your upcoming Repairs</h2>
    <div class="row">
    <div class="col-sm-4 col-sm-offset-8">
            <form  action="/user/home" method="post" name="createUser" id="createUser">

            </form>
  <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
<#if repairs??>
    <h3>Retrieved repairs:</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Repair's ID</th>
            <th>Type</th>
            <th>Cost</th>
            <th>Description</th>
            <th>Arrival Date</th>
            <th>Status</th>
            <th>User's ID</th>
        </tr>
        </thead>
        <tbody>
            <#list repairs as repair>
            <tr>
                <td>${repair.id!""}</td>
                <td>${repair.type!""}</td>
                <td>${repair.cost!""}</td>
                <td>${repair.description!""}</td>
                <td>${repair.arriveDate!""}</td>
                <td>${repair.status!""}</td>
                <td>${repair.userId!""}</td>

                </form>
                </td>
            </tr>
            </#list>
            </table>
</#if>

</div>
</body>
</html>


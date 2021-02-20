<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>

   <style><style><%@include file="/static/bootstrap/css/bootstrap.min.css"%></style>
<style><%@include file="/static/css/index.css"%></style>
<script type="text/javascript"><%@include file="/static/bootstrap/js/bootstrap.min.js"%></script>
<script type="text/javascript"><%@include file="/static/bootstrap/jquery-3.5.1.min.js"%></script>
</head>

<body>
    <div class="container-fluid rootmen">
        <div class="form fr1">
           
            <h1 class="text-center"><i class="fa fa-user-plus fa-2x" aria-hidden="true"></i></h1>
            <h1 class="text-center">Registration</h1><br>
            <div class="row" >
                <div class="form-group col-sm-6">
                    <label for="">USER NAME:</label>
                    <input type="text" class="form-control ctrl" name="" id="" aria-describedby="helpId"
                        placeholder="Username ?">
                </div>
                <div class="form-group col-sm-6">
                    <label for="">PASSWORD:</label>
                    <input type="text" class="form-control ctrl" name="" id="" aria-describedby="helpId"
                        placeholder="Password ?"> <br>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="">FULL NAME :</label>
                    <input type="text" class="form-control ctrl" name="" id="" aria-describedby="helpId"
                        placeholder="Full name ?">
                </div>
                <div class="form-group col-sm-6">
                    <label for="">EMAIL:</label>
                    <input type="text" class="form-control ctrl" name="" id="" aria-describedby="helpId"
                        placeholder="Email ?"> <br>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-outline-light btn-login" style="width: 300px;" type="button">CREATE</button>
               </div>
        </div>
</body>

</html>
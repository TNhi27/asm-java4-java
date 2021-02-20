<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

			
    <!-- modal share video -->
        	<div data-backdrop="static" class="modal fade" id="share-video" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                 
                    <h5 class="modal-title" id="exampleModalLongTitle">SHARE VIDEO</h5>
                    <button onclick="rep()" type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    
                </div>
                <div  id="formx" class="modal-body">
              
                     <form  id="form" action="/Java4_ASM_PC00653/share-video" method="post" >
                      	<input name="idVideo" id="idshare" hidden value="">
                        <input type="text" name="email" id="" class="form-control" placeholder="Email" aria-describedby="helpId"> <br>
                        <input type="text" name="mess" id="" class="form-control" placeholder="Title" aria-describedby="helpId"> <br> <hr>
                        <button onclick="rep()" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button onclick="share()" type="submit" class="btn btn-primary">Share</button>
                    </form>
                </div>
               
            </div>
        </div>
    </div>

    <!--modal quen mk-->
    <div class="modal fade" id="modal-quen-mk" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">FORGOT PASSWORD</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="" method="GET">
                        <input type="text" name="" id="" class="form-control" placeholder="Email"
                            aria-describedby="helpId"> <br>
                        <hr>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Retrieve</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <!--modal cap nhat tai khoan-->
    <div class="modal fade" id="modal-cap-nhat-tk" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">EDIT PROFILE</h5>
                    <button onclick="rep()" type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div id="ta" class="modal-body">
                    <form  id="edit-pro" action="/Java4_ASM_PC00653/edit-profile" method="POST" enctype="multipart/form-data">
                        <label for="">Username</label>
                        <input value="" type="text" name="username" id="" class="form-control" placeholder="Username"
                            aria-describedby="helpId"> <br>
                            <label for="">Password</label>
                        <input value="" type="password" name="password" id="" class="form-control" placeholder="Password"
                            aria-describedby="helpId"> <br>
                            <label for="">Full name</label>
                        <input value="" type="text" name="fullname" id="" class="form-control" placeholder="Full name"
                            aria-describedby="helpId"> <br>
                            <label for="">Email</label>
                        <input value="" type="text" name="email" id="" class="form-control" placeholder="Email"
                            aria-describedby="helpId"> <br>
                        <hr>
                        <button onclick="rep()" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button onclick="edit()" type="submit" class="btn btn-primary">UPDATE</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <!--modal doi mk-->
    <div class="modal fade" id="modal-doi-mk" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">CHANGE PASSWORD</h5>
                    <button onclick="rep()" type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                <div id="tb">
                </div>
                    <form id="form-changepw" action="" method="">
                       	
                        <label for="">MAT KHAU CU</label>
                        <input type="password" name="pwc" id="" class="form-control" placeholder=""
                            aria-describedby="helpId"> <br>
                            <label for="">MAT KHAU MOI </label>
                        <input type="password" name="pwm" id="" class="form-control" placeholder=""
                            aria-describedby="helpId"> <br>
                            <label for="">NHAP LAI MAT KHAU</label>
                        <input type="password" name="rpw" id="" class="form-control" placeholder=""
                            aria-describedby="helpId"> <br>
                            
                        <hr>
                        <div class="text-right">
                        <button onclick="rep()" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button onclick="changePass()" type="submit" class="btn btn-primary">UPDATE</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    
   

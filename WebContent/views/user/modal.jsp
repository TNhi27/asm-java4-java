<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <script type="text/javascript">
 	
 	function forgotPassword() {
 		
        email =$("input[name=email1]").val();
        user =$("input[name=user1]").val();
   		
        $.ajax({
               type: "POST",
               url: "showpassword",
               data: {
 					user:user,
             	  	email:email
             	 
               },
             
               async: false,
               success: function (data) {
             	 $("#formForgot").html(data)
               }
           });
     	  event.preventDefault();
	}
 	
 	function sendCode() {
 		
        code =$("input[name=code]").val();
        email = $("input[name=emailToSend]").val();
        pass = $("input[name=passToSend]").val();
       
        $.ajax({
               type: "POST",
               url: "send-code",
               data: {
 					code:code,
             	 	email:email,
             	 	pass:pass
               },
             
               async: false,
               success: function (data) {
             	 $("#formForgot").html(data)
               }
           });
     	 
	}
 </script>
			
    <!-- modal share video -->
    
    <c:if test="${sessionScope.user == null }">
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
              
                    <h1>Ban chua dang nhap</h1>
                </div>
               
            </div>
        </div>
    </div>
    
    </c:if>
    <c:if test="${sessionScope.user != null }">
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
                      	<input name="idVideo" id="id-video" hidden value="">
                        <input type="text" name="email" id="" class="form-control" placeholder="Email" aria-describedby="helpId"> <br>
                        <input type="text" name="mess" id="" class="form-control" placeholder="Title" aria-describedby="helpId"> <br> <hr>
                        <button onclick="rep()" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button onclick="share()" type="submit" class="btn btn-primary">Share</button>
                    </form>
                </div>
               
            </div>
        </div>
    </div>
    </c:if>
        	

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
                <div id="formForgot"  class="modal-body">
                    <form  action="" method="POST">
                        <input type="text" name="user1" id="" class="form-control" placeholder="User Name"
                            aria-describedby="helpId"> <br>
                        <input type="text" name="email1" id="" class="form-control" placeholder="Email"
                            aria-describedby="helpId"> <br>
                        <hr>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button onclick="forgotPassword()" class="btn btn-primary">Retrieve</button>
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
    
   

 
window.onload = function() {
   $.ajax({
                    type: "GET",
                    url: "edit-profile",
                    async: false,
                    success: function (data) {
   					
   					$("#edit-pro").html(data)
                  	
                    }
	});
}

$(document).ready(function () {
	
            $(window).bind('scroll', function () {
                var navHeight = $(window).height() - 600;
                if ($(window).scrollTop() > navHeight) {
                    $('.navbar').addClass('fixed');
                }
                else {
                    $('.navbar').removeClass('fixed');
                }
            })
 });
       
 function show(val) {
    	var idvideo = document.getElementById("idshare")
    	idvideo.value=val
    	
		
	}
    
    function rep() {
    	$("#tb").remove();
    	$("input[name=email]").val("") 
    	$("input[name=mess]").val("")
    	$("input[name=pwc]").val("") 
    	$("input[name=pwm]").val("") 
    	$("input[name=rpw]").val("")   
    	
	}
    function edit() {
    	
     	id =$("input[name=username]").val();
   		password =$("input[name=password]").val();
        email =$("input[name=emailu]").val();
        fullname =$("input[name=fullname]").val();
   		
        $.ajax({
               type: "POST",
               url: "edit-profile",
               data: {
             	  	id :id,
   				password:password,
   				fullname:fullname,
             	  	email:email,
             	 
               },
             
               async: false,
               success: function (data) {
             	 $("#ta").before(data)
               }
           });
     	  event.preventDefault();
     	
	}
	
    function share() {
    	
       	 id = $("#id").val();
            email =$("input[name=email]").val();
            mess =$("input[name=mess]").val();
             $.ajax({
                 type: "POST",
                 url: "share-video",
                 data: {
               	  id :id,
               	  email:email,
               	  mess:mess
                 },
               
                 async: false,
                 success: function (data) {
               	 $("#formx").before(data)
                 }
             });
       	  event.preventDefault();
       
	}
	function changePass() {
    	
     	pwc =$("input[name=pwc]").val();
   		pwm =$("input[name=pwm]").val();
        rpw =$("input[name=rpw]").val();
       
   		
        $.ajax({
               type: "POST",
               url: "change-password",
               data: {
             	  	pwc :pwc,
   					pwm:pwm,
             	  	rpw:rpw,
             	 
               },
             
               async: false,
               success: function (data) {
             	 $("#tb").html(data)
               }
           });
     	  event.preventDefault();
     	
	}
    

    $('#share-video').modal({
	    backdrop: 'static',
	    keyboard: false
	})
	$('#modal-cap-nhat-tk').modal({
	    backdrop: 'static',
	    keyboard: false
	})
    $(document).ready(function () {
    	$('.carousel').carousel({
            interval: 2000
        });
    	
    	
       
    });
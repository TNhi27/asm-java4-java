 function getByUser(videoID) {
    	
     	
   		
       $.ajax({
				type:"POST",
			  data: {
				idnow:videoID
			},
			  url: "change-video"
			}).done(function(data) {
			  // If successful
			 $("#userfav").html(data)
			}).fail(function(jqXHR, textStatus, errorThrown) {
			  alert("that bai")
			  console.log(textStatus + ': ' + errorThrown);
			})
     	  event.preventDefault();
     	
	}
	
	function getByShare(videoID) {
    	
     	
   		
       $.ajax({
				type:"GET",
			  data: {
				idShare:videoID
			},
			  url: "share-report"
			}).done(function(data) {
			  // If successful
			 $("#share-table").html(data)
			}).fail(function(jqXHR, textStatus, errorThrown) {
			  alert("that bai")
			  console.log(textStatus + ': ' + errorThrown);
			})
     	  event.preventDefault();
     	
	}
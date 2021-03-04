
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

  

        <div class="slide">
            <div id="my-carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://cdnimg.vietnamplus.vn/t620/uploaded/pcfo/2019_09_30/3009_abominable.jpg" alt="">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://i.chungta.vn/2017/12/22/LogoFPT-2017-copy-3042-1513928399.jpg" alt="">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#my-carousel" data-slide="prev" role="button">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#my-carousel" data-slide="next" role="button">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>


        <!--hien thi danh sach video-->
       
        <div class="row row-video">
            <c:forEach var="video" items="${videos }">
            <c:url var="uriLike" value="/like-video">
            	<c:param name="id" value="${video.id }"></c:param>
            </c:url>
            <c:url var="urict" value="/chi-tiet">
            	<c:param name="id" value="${video.id }"></c:param>
            </c:url>
        	<c:url var="uriShare" value="/share-video">
            	<c:param name="ma" value="${video.id }"></c:param>
            </c:url>
        		
        	
         
         			
            <div class="col-sm-4">
                	<div class="card">
						<a href="${urict }">
							<img class="card-img-top" width="100%" height="200px" src="<c:url value = '/static/file/${video.poster }' />" alt="">
						</a>
                    <div class="card-body">
                        <h5 class="card-title">${video.title } <span class="badge badge-info">${video.views }</span></h5>
                        <p class="card-text">${video.description }</p>
                    </div>
                    <div class="card-footer text-right">                    
                       	<a href="${uriLike }"><button class="btn btn-primary"  type="submit">Like
                       	<c:set var="f" value=""></c:set>
                       	<c:forEach var="fav" items="${fav }">
        					<c:choose>
        						<c:when test="${video.id == fav.video.id }"> <c:set var="f" value="color:red"></c:set> </c:when>
        					</c:choose>
         				</c:forEach> 
                       	<i class="fa fa-heart" style="${f}"  aria-hidden="true"></i>
						</button></a>
						
                        <button	onclick="show(this.value)" class="btn btn-primary" type="button" data-toggle="modal" data-target="#share-video" value="${video.id }">Share
                            <i class="fa fa-share" aria-hidden="true"></i>
                        </button>
             
                    </div>
                </div>
            </div>
      
        		
        	</c:forEach>
		</div> 
       
       
       
       
    
     <c:import url="/views/user/modal.jsp"></c:import>

  
   

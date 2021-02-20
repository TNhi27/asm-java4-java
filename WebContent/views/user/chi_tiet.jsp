<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    
      
        <c:url var="uriLike" value="/like-video">
            	<c:param name="id" value="${video.id }"></c:param>
        </c:url>

        <div class="row ">
            <div class="col-sm-6">
                <div class="card">
                    <img height="200px" class="card-img-top" src="<c:url value = '/static/file/${video.poster }' />" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${video.title }</h5>
                        <p class="card-text">${video.description }</p>
                    </div>

                    <div class="card-footer text-right">
                        <a href="${uriLike }"><button class="btn btn-primary" type="button">
                            <span class="badge badge-light">${video.views }</span>
                            Like
                            <c:set var="f"></c:set>
                            <c:forEach var="fav" items="${fav }">
                            	<c:if test="${fav.video.id == video.id }"> <c:set var="f" value="color:red"></c:set> </c:if>
                            </c:forEach>
                            <i class="fa fa-heart" style="${f}"  aria-hidden="true"></i>
                        </button></a>
                        <button onclick="show(this.value)" value="${video.id }" class="btn btn-primary" data-toggle="modal" data-target="#share-video"
                            type="button">Share
                            <i class="fa fa-share" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
            </div>
            
            <!-- danh sach video da xem-->
            <div class="col-sm-6">
            <c:forEach var="v" items="${seen }">
            
            <c:url var="urict" value="/chi-tiet"> 
            	<c:param name="id" value="${v.id }"></c:param>
            </c:url>
            	 <div class="danhsach">
                    <div class="row video">
                        <a class="col-sm-9" href="${urict }"><img src="<c:url value = '/static/file/${v.poster }' />" alt=""></a>
                        <div class="col-sm-3 vd-title">
                            <h5><a href="${urict }">${v.title }</a></h5>
                            <p>${v.description }</p>
                        </div>
                    </div>                  
                </div>
            </c:forEach>
            </div>
        </div>
    
   


  <c:import url="/views/user/modal.jsp"></c:import> 

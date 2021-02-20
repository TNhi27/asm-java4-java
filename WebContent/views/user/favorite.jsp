<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

		<c:if test=" ${ check}">
			<c:out value="ban">ban</c:out>
		</c:if>
   
        <div class="row">
		<c:forEach var="fa" items="${favorite }">
			<c:url var="uriLike" value="/like-video">
            	<c:param name="id" value="${fa.video.id }"></c:param>
            </c:url>
            <c:url var="urict" value="/chi-tiet">
            	<c:param name="id" value="${fa.video.id }"></c:param>
            </c:url>
			<div class="col-sm-4">
                <div class="card">
                   <a href="${urict }">
						<img class="card-img-top" src="<c:url value = '/static/file/${fa.video.poster }' />" alt="">
					</a>
					 <div class="card-body">
                        <h5 class="card-title">${fa.video.title } <span class="badge badge-info">${f.video.views }</span></h5>
                        <p class="card-text">${fa.video.description }</p>
                    </div>
                    <div class="card-footer text-right">
                        	<a href="${uriLike }"><button class="btn btn-primary"  type="submit">Liked
                            <i class="fa fa-heart text-danger" aria-hidden="true"></i>
						</button></a>
						
                         <button onclick="show(this.value)" value="${fa.video.id }" class="btn btn-primary" data-toggle="modal" data-target="#share-video"
                            type="button">Share
                            <i class="fa fa-share" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
            </div>
		</c:forEach>     
        </div>
        <c:import url="/views/user/modal.jsp"></c:import>
        
    
    

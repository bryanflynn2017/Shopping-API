<%@include file=".\includes\adminHeader.jsp" %>

<%@include file=".\includes\adminNavigation.jsp" %>

<div class="container-fluid">

<% 
	if(view == null) {
		view = "postlist";
	}

	if(view.equals("postlist")){%>
		<%@include file=".\includes\postList.jsp" %>
	<%}else if(view.equals("postadd")){ %>
		<%@include file=".\includes\postAdd.jsp" %>
	<%}else if(view.equals("postedit")){ %>
		<%@include file=".\includes\postEdit.jsp" %>	
	<%}else{ %>
	<%@include file=".\includes\dashboard.jsp" %>
	<%}%>
		
</div><!-- /.container-fluid -->

<%@include file=".\includes\adminFooter.jsp" %>
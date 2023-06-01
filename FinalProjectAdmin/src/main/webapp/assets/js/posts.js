function listPosts(){
	
	$.ajax({
		url: "../FinalProjectAPI/rest/posts/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
	
			if (value.postContent.length > 150){
				value.postContent = value.postContent.substring(0,150) + "...";
			}
    		
			var lstResults = "<tr><td><a href ='./index.jsp?view=postedit&edit="+value.postID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a></td>" +
	        "<td>"+value.postID+"</td><td>"+value.postTitle+"</td><td>"+value.postText+"</td>"+
			"<td>"+value.postDate+"</td></tr>";
       		
       		if($("#postBody").text()){
    			document.getElementById('postBody').innerHTML += lstResults;
    		}
    	});
	});
}

function addPost(){
	
	var postTitle = $("#postTitle").val();
	var postText = $("#postText").val();
	var postDate = $("#postDate").val();
	
	var parms = { postTitle:postTitle, postText:postText, postDate:postDate };

	$.ajax({
		url: "./rest/posts/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	alert(response.message)
	});
}

function updatePost(){
	
	var postTitle = $("#postTitle").val();
	var postText = $("#postText").val();
	
	var parms = { postID:postID, postTitle:postTitle, postText:postText, postDate:postDate };

	$.ajax({
		url: "./rest/posts/",
		type: 'PUT',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){
		
    	window.location = "./index.jsp?view=postlist";
	});
}

function getPost(postID){
		
		$.ajax({
			url: "../FinalProjectAPI/rest/posts/"+postID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#postTitle").val(response.postTitle);
	    	$("#postText").val(response.postText);
	    	$("#postDate").val(response.postDate);

		});
	}
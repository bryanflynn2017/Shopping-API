$(document).ready(function(){

	getAllPosts();
	
	view = getQueryStringVariable('view');
	
	if(view == 'postedit'){
		postID = getQueryStringVariable('edit');
		getPost(postID);
	}
});

var getQueryStringVariable = function ( field, url ) {
	var href = url ? url : window.location.href;
	var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
	var string = reg.exec(href);
	return string ? string[1] : null;
};

function getAllPosts(){
	
	$.ajax({
		url: "../FinalProjectAPI/rest/posts",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var lstResults = "<tr><td>"+value.postID+"</td><td>"+value.postTitle+"</td><td>"+value.postText+"</td><td>"+value.postDate+"</td></tr>";
       		
    		document.getElementById('postBody').innerHTML += lstResults;
    	});
	});
	
}

function addPost(){
	
	var postTitle = $("#postTitle").val();
	var postText = $("#postText").val();
	var postDate = $("#postDate").val();
	
	var parms = { postTitle:postTitle, postText:postText };

	$.ajax({
		url: "../FinalProjectAPI/rest/posts",
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
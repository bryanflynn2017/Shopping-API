<h1 class="page-header">Add Post</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="postTitle">Title</label>
    <input type="text" class="form-control" id="postTitle" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="postText">Text</label>
    <input type="text" class="form-control" id="postText" required>
</div>
 <div class="form-group">
 <span>
     <button class="btn btn-primary"  type="submit" onclick="addPost()" id="postAdd" data-toggle="tooltip" title="Add Post">Add Post</button>
 </span>

 <span>
     <input class = "btn btn-link" type="button" onclick="window.history.back()" value="Cancel" data-toggle="tooltip" title="Cancel">
   </span>
</div>
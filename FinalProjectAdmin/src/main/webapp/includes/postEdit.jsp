<h1 class="page-header">Edit Post</h1>

<div class="form-group col-xs-12 col-md-6">
        <label for="postTitle">Title</label>
        <input type="text" class="form-control" id="postTitle" value="" required autofocus>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="postText">Text</label>
    <input class="form-control" id="postText" required></input>
</div>


<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick=updatePost(); data-toggle="tooltip" title="Save Changes">Save Changes</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>
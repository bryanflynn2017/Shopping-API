package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import service.PostService;

@Path("/posts")
public class PostsAPI {
	
	@GET
	//@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listPosts() {
		
		JSONArray posts = PostService.listPosts();
		
		
		return posts.toString();
		
	}
	
	@PUT
	//@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updatePost(String inputParms) {
		
		//System.out.println("key: "+apiKey);
		
		try {
			JSONObject result = PostService.updatePost(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {

			e.printStackTrace();
			
			return "updatePostAPI failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getPost(@PathParam("id") Integer id) {
		
		JSONObject article = PostService.getPost(id);
		
		
		return article.toString();
		
	}
	
	@POST
	//@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addPost(String inputParms) {

		
		try {
			JSONObject result = PostService.addPost(new JSONObject(inputParms));
			return result.toString();
		} catch (JSONException e) {

			e.printStackTrace();
			
			return "addPostAPI failed";
		}
		
	}
	
	@DELETE
	//@Path("/delete/")
	@Produces("application/json")
	@Consumes("application/json")
	public String deletePost(String inputParms) {

		
		try {
			JSONObject result = PostService.deletePost(new JSONObject(inputParms));
			return result.toString();
		} catch (JSONException e) {

			e.printStackTrace();
			
			return "deletePostAPI failed";
		}
		
	}
	
}

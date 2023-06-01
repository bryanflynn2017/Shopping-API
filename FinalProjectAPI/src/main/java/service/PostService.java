package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Post;

public class PostService {

	public static JSONArray listPosts() {
		
		JSONArray posts = new JSONArray();
		
		Post post = new Post();
		posts = post.listPosts();
		
		return posts;
	}

	public static JSONObject updatePost(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			int postID = inputParms.getInt("postID");
			String postTitle = inputParms.getString("postTitle");
			String postText = inputParms.getString("postText");
			
			Post post = new Post();
			post.setPostID(postID);
			post.setPostTitle(postTitle);
			post.setPostText(postText);
			
			message = post.updatePost();
		
			result.put("message", message);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getPost(int id) {
		
		JSONObject postID = new JSONObject();
		
		Post post = new Post();
		post.setPostID(id);
		
		postID = post.getPost();
		
		return postID;
	}
	
	public static JSONObject addPost(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			String postTitle = inputParms.getString("postTitle");
			String postText = inputParms.getString("postText");

		
		Post post = new Post();
		post.setPostTitle(postTitle);
		post.setPostText(postText);
		
		message = post.addPost();
		
		
			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject deletePost(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			int postID = inputParms.getInt("postID");
			
			Post post = new Post();
			post.setPostID(postID);
			
			message = post.deletePost();
		
		
			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}

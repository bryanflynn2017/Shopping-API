package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Post {
	
	int postID;
	String postTitle;
	String postText;
	Date postDate;

	public Post() {
		
	}
	
	public Post(int postID, String postTitle, String postText, 	Date postDate) {
		this.postID = postID;
		this.postTitle = postTitle;
		this.postText = postText;
		this.postDate = postDate;
	}
	
	public JSONArray getAllPosts() {
		
		JSONObject postJSONObject = null;
		JSONArray postsJSONArray = new JSONArray();
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			Statement stmt = connection.createStatement(
					java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
			
			String postsQuery = "SELECT * " +
			  		"FROM FinalProjectDB.dbo.posts WITH (NOLOCK) ";
				
				java.sql.ResultSet postsResults = stmt.executeQuery(postsQuery);
	
				while(postsResults.next()){
					
					postJSONObject = new JSONObject();
					
					String postID = postsResults.getString("postID").trim();
					String postTitle = postsResults.getString("postTitle").trim();
					String postText = postsResults.getString("postText").trim();
					String postDate = postsResults.getString("postDate").trim();
					
					postJSONObject.put("postID", postID);
					postJSONObject.put("postTitle", postTitle);
					postJSONObject.put("postText", postText);
					postJSONObject.put("postDate", postDate);
					
					postsJSONArray.put(postJSONObject);

				}
				
				System.out.println(postsJSONArray);

		    
			//Close Connections
			try { if (postsResults != null) postsResults.close(); } catch (Exception e) {}; 
	    	try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
		
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return postsJSONArray;
	}
	
	public JSONArray listPosts() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();	
		
		String sqlString = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.posts WITH (NOLOCK) ";
			
		FinalSQLQuery sqlQuery = new FinalSQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
			
	}
	
	public String updatePost() {
		
		String message = "Post Updated!";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String updatePost = "UPDATE "+mssqlConnection.getDatabase()+".dbo.Posts SET " +
					"postTitle=IsNull(NullIf(?,''),postTitle), " +
					"postText=IsNull(NullIf(?,''),postText) " +
					"WHERE postID="+postID+"";
			
			PreparedStatement ps = connection.prepareStatement(updatePost);
			
			ps.setString(1, postTitle);
			ps.setString(2, postText);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
		 
	}
	
	public JSONObject getPost() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();		
		String sqlString = "SELECT * " +
		  		"FROM "+mssqlConnection.getDatabase()+".dbo.posts WITH (NOLOCK) " +
				"WHERE postID = "+postID+"";
			

	FinalSQLQuery sqlQuery = new FinalSQLQuery();
	sqlQuery.setSqlString(sqlString);
	
	return sqlQuery.getQuery();

}


	public String addPost() {
	
		String message = "Post Added!";
		
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addPost = "INSERT "+mssqlConnection.getDatabase()+".dbo.posts " +
					"(postTitle, postText, postDate) VALUES (?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addPost);
			
			Date date = new Date();
			
			ps.setString(1, postTitle);
			ps.setString(2, postText);
			ps.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
	
		return message;
		 
	}
	
	public String deletePost() {
		
		String message = "Post " + postID + " Deleted!";
		
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String delete = "DELETE FROM "+mssqlConnection.getDatabase()+".dbo.posts " +
			"WHERE postID=" + postID;
			
			PreparedStatement ps = connection.prepareStatement(delete);
			
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
		return message;
		 
	}

	// Getters and Setters
	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	
}

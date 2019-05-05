package model;

public class Post {
	String catagory = "";
	String title = "";
	String text = "";
	String mediaURL = "";
	String upVotes = "";
	String userName = "";
	String subReddit = "";
	String mediaType = "";
	int postID = 0;
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public String getUpVotes() {
		return upVotes;
	}
	public void setUpVotes(String upVotes) {
		this.upVotes = upVotes;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSubReddit() {
		return subReddit;
	}
	public void setSubReddit(String subReddit) {
		this.subReddit = subReddit;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	
}
package com.tap.model;

import java.util.Date;

public class Post {
	
	private int id;
    private String title;
    private String content;
    private byte[] image;
    private byte[] video;
    private Date date;
    private int userId;
    
    public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int id, String title, String content, byte[] image, byte[] video, Date date, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.video = video;
		this.date = date;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    

}

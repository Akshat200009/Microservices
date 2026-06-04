package com.UserService.Entities;

import jakarta.persistence.Entity;

@Entity
public class Ratings {
	
	private int ratingid;
	private int userid;
	private int hotelid;
	private int rating;
	private String feedback;

	public int getRatingid() {
		return ratingid;
	}

	public void setRatingid(int ratingid) {
		this.ratingid = ratingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


}

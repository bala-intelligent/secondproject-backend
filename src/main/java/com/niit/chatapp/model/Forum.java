package com.niit.chatapp.model;

import javax.persistence.*;
import java.sql.*;
@Entity
public class Forum {
	
@Id
 private int forumid;
private String forumname;
private Time postedtime;
private Date posteddate;
private String commentid;
private String forumapproved;
private int ratingid;
public int getForumid() {
	return forumid;
}
public void setForumid(int forumid) {
	this.forumid = forumid;
}
public String getForumname() {
	return forumname;
}
public void setForumname(String forumname) {
	this.forumname = forumname;
}
public Time getPostedtime() {
	return postedtime;
}
public void setPostedtime(Time postedtime) {
	this.postedtime = postedtime;
}
public Date getPosteddate() {
	return posteddate;
}
public void setPosteddate(Date posteddate) {
	this.posteddate = posteddate;
}
public String getCommentid() {
	return commentid;
}
public void setCommentid(String commentid) {
	this.commentid = commentid;
}
public String getForumapproved() {
	return forumapproved;
}
public void setForumapproved(String forumapproved) {
	this.forumapproved = forumapproved;
}
public int getRatingid() {
	return ratingid;
}
public void setRatingid(int ratingid) {
	this.ratingid = ratingid;
}

}

package com.niit.Model;

public class Message
{
private int id;
private String message;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Message()
{
	
}
public Message(String message,int id)
{
	this.message=message;
	this.id=id;
}
}

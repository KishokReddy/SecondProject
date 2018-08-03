package com.niit.Model;

import java.util.Date;

public class OutputMessage extends Message
{
private Date time;

public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}
public OutputMessage(Message message,Date time)
{
	super(message.getMessage(),message.getId());
	this.time=time;
}
}

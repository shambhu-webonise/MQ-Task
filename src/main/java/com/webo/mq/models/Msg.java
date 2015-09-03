package com.webo.mq.models;

import java.io.Serializable;
import java.util.List;

public class Msg implements Serializable {
	private static final long serialVersionUID = 4881156638391360490L;
	private String qName;
	private List<String> messages;

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}

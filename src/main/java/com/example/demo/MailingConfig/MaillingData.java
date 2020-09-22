package com.example.demo.MailingConfig;

import java.util.List;

import javax.validation.constraints.Email;

import com.example.demo.Beans.Document;

public class MaillingData {

    private String name;
    @Email
    private String email;
    private String feedback;
    private String object;
    private List<Document> documents;
    
    
    
    
    
    public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

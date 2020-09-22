package com.example.demo.Beans;

public class AuthenticationResponse {
    private String token;
    private Role role;
    
    

    public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token, Role role) {
		
		this.token = token;
		this.role = role;
	}

	public String getToken() {
        return token;
    }

	public Role getRole() {
		return role;
	}
}

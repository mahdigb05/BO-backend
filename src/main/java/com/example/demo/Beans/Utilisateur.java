package com.example.demo.Beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.lang.NonNull;

@Entity
public class Utilisateur extends Personne {

    @NonNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Column(nullable = false)
    private String password;
    
    @Column(columnDefinition =" tinyint(1) default 1")
    private boolean active;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String tel, String email, long matricule, @NonNull Role role, String password) {
        super(nom, prenom, tel, email, matricule);
        this.role = role;

        this.password = password;

    }

    public boolean isActive() {
        return active;
    }

    @NonNull
    public Role getRole() {
        return role;
    }

    public void setRole(@NonNull Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public void setActive(boolean active) {
		this.active = active;
	}
    
    
}

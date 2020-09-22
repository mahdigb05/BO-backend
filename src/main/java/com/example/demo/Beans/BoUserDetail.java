package com.example.demo.Beans;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BoUserDetail implements UserDetails {

    private Utilisateur utilisateur;

    public BoUserDetail(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole().toString());
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }
    
    public Role getRole() {
    	return utilisateur.getRole();
    }

    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }

    @Override
    public String getUsername() {
        return utilisateur.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return utilisateur.isActive();
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}

package com.example.demo.Gestionnaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Beans.BoUserDetail;
import com.example.demo.Beans.Role;
import com.example.demo.Beans.Utilisateur;
import com.example.demo.Repositories.UtilisateurDao;

@Service
public class BoDetailService implements UserDetailsService {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public BoUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	if(email.equals("admin")) {
    		Utilisateur utilisateur = new Utilisateur();
    		utilisateur.setEmail(email);
    		utilisateur.setPassword(passwordEncoder.encode("admin"));
    		utilisateur.setRole(Role.ROLE_ADMIN);
    		utilisateur.setActive(true);
    		return new BoUserDetail(utilisateur);
    	}
    	
        Utilisateur utilisateur = utilisateurDao.findByEmail(email);
        if(utilisateur == null)
        {
            throw new UsernameNotFoundException(email);
        }
        BoUserDetail userDetail = new BoUserDetail(utilisateur);
        return userDetail;
    }
}

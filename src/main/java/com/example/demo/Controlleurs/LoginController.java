package com.example.demo.Controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.AuthenticationRequest;
import com.example.demo.Beans.AuthenticationResponse;
import com.example.demo.Beans.BoUserDetail;
import com.example.demo.Gestionnaires.BoDetailService;
import com.example.demo.Utils.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BoDetailService boDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
    	
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword())
            );

        }catch (BadCredentialsException e)
        {
            throw new BadCredentialsException("cet utilisateur n'existe pas");
        }
        final BoUserDetail userDetail = boDetailService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetail);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt, userDetail.getRole());
        return new ResponseEntity<>(authenticationResponse,HttpStatus.OK);
    }

}

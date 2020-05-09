package com.foody.controller;

import com.foody.config.JwtTokenUtil;
import com.foody.entity.JwtResponse;
import com.foody.entity.User;
import com.foody.service.JwtUserDetailsService;
import com.foody.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody User user) throws Exception {
        authenticate(user.getUsername(), user.getPassword());

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getUsername());
        System.out.println("THIS IS THE USER" +userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println("THIS IS THE TOKEN" +token);
//
        return ResponseEntity.ok(new JwtResponse(token));
    }
//
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PutMapping(value = "/updateUserInfo/{id}")
    public ResponseEntity<?> updateUserInfo(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok().body(jwtUserDetailsService.update(id, user));
    }

//    @DeleteMapping(value = "/deleteUser/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }
//
}

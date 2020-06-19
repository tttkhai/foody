package com.foody.controller;

import com.foody.config.JwtTokenUtil;
import com.foody.entity.JwtResponse;
import com.foody.entity.User;
import com.foody.repository.UserRepository;
import com.foody.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody User user) throws Exception {
        authenticate(user.getUsername(), user.getPassword());
        final User authenticatedUser = userRepository.findUserByUserName(user.getUsername());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Map map = new HashMap<>();
        map.put("token", token);
        map.put("user", authenticatedUser);
        return ResponseEntity.ok().body(map);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> updateUserInfo(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok().body(jwtUserDetailsService.updateUser(id, user));
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        jwtUserDetailsService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(jwtUserDetailsService.getUser(id));
    }

    @PostMapping(value = "/newUser")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user) {
        User existing_user = userRepository.findUserByUserName(user.getUsername().toString());
        if(existing_user==null){
            return ResponseEntity.ok().body(jwtUserDetailsService.save(user));
        }
        else{
            return ResponseEntity.status(409).body("Duplicate username");
        }
    }
}

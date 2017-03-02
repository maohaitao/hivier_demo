package com.bikemanage.rest;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import com.bikemanage.common.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.URI_API)
public class UserController {
    
    /**
     * Get the authenticated user info.
     * 
     * @param principal
     * @return 
     */
    @RequestMapping("/me")
    public ResponseEntity<Map<String, Object>> user(Principal principal) {
        
        Map<String, Object> map = new HashMap<>();
//        map.put("username", principal.getName());
        System.out.println("-----user----");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
   
}

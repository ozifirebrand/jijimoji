package africa.semicolon.jijimoji.controllers;


import africa.semicolon.jijimoji.dtos.requests.RegisterListerRequest;
import africa.semicolon.jijimoji.exceptions.JijimojiException;
import africa.semicolon.jijimoji.services.ListerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListerController {
    private ListerService listerService;

    @PostMapping("/api/lister")
    public ResponseEntity<?> register(@RequestBody RegisterListerRequest request){
        try{
            return new ResponseEntity<>(listerService.registerLister(request), HttpStatus.CREATED);
        }
        catch (JijimojiException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public String hello() {
        return "This tutorial is the best. All hail the great Kristijan.";
    }
}

//todo field setter and constructor injection are the various types of injection


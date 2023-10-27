package com.example.musicmservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/type")
public class TypeRestAPI {


    @Autowired
    private TypeService typeService;

    private String title = "hello from Type api";


    @RequestMapping("helloType")
    public String sayHallo() {
        System.out.println(title);
        return title;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("addType")
    public ResponseEntity<Type> createCandidat(@RequestBody Type type) {
        return new ResponseEntity<>(typeService.addType(type), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Type> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Type type) {
        return new ResponseEntity<>(typeService.updateType(id, type),
                HttpStatus.OK);


    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<String> deleteType(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(typeService.deleteType(id), HttpStatus.OK);
    }



    @GetMapping("/allTypes")
    @ResponseBody
    public List<Type> getAllTypes(){
        return  typeService.retrieveAllTypes();
    }




}

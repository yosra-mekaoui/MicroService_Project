package com.example.musicmservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/music")
public class MusicRestAPI {


    @Autowired
    private MusicService musicService;


    private String title = "hello from Music api";


    @RequestMapping("hello")
    public String sayHallo() {
        System.out.println(title);
        return title;
    }


    @PostMapping(value = "/addMusic/{idType}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Music addMusic(@RequestBody Music music, @PathVariable(value = "idType") int idType) {
        return musicService.addMusic(music, idType);
    }


    @GetMapping("/music/{id}")
    public Music getMusicById(@PathVariable Integer id) {
        return musicService.getMusicById(id);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteType(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(musicService.deleteMusic(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Music> updateCandidat(@PathVariable(value = "id") int id,
                                               @RequestBody Music music) {

        return new ResponseEntity<>(musicService.updateMusic(id, music),
                HttpStatus.OK);


    }







}

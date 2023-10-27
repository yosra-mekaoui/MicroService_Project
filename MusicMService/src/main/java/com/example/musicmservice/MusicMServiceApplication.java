package com.example.musicmservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class MusicMServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicMServiceApplication.class, args);
    }

//
//    @Autowired
//    private  MusicRepository musicRepository;
//
//    @Autowired
//    private  TypeRepository typeRepository;
//
//
//    @Bean
//    ApplicationRunner init(){
//
//        return (args) -> {
//            //save
//
//            // Créez une instance de Type
//            Type type = new Type("t1", new HashSet<>()); // Initialisez un ensemble vide de musiques
//
//           // Créez des instances de Music
//            Music music1 = new Music("Title1", "Album1", "audio1.mp3",type);
//            Music music2 = new Music("Title2", "Album2", "audio2.mp3",type);
//
//            // Ajoutez les objets Music à l'ensemble musics de Type
//            type.getMusics().add(music1);
//            type.getMusics().add(music2);
//
//
//
//            typeRepository.save(type);
//
//            musicRepository.save(music1);
//            musicRepository.save(music2);
//
//            //fetch
//            typeRepository.findAll().forEach(System.out::println);
//            musicRepository.findAll().forEach(System.out::println);
//
//        };


}



package com.example.musicmservice;


import org.springframework.data.jpa.repository.JpaRepository;



public interface MusicRepository extends JpaRepository<Music,Integer> {
}

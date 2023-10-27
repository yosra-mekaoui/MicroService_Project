package com.example.musicmservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {



    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private TypeRepository typeRepository;




    public Music addMusic(Music m) {
        return musicRepository.save(m);
    }



//    public Music addMusic(Music music, int typeId) {
//
//        Type type = typeRepository.findById(typeId).orElse(null);
//
//        if (type == null) {
//            // Gérer le cas où le type avec l'ID spécifié n'a pas été trouvé
//            throw new RuntimeException("Type introuvable pour l'ID spécifié : " + typeId);
//        }
//
//        music.setType(type);
//
//        return musicRepository.save(music);
//    }


    public Music addMusic(Music music, int typeId) {
        Type type = typeRepository.findById(typeId).orElse(null);

        music.setType(type);
        return musicRepository.save(music);
    }


    public Music getMusicById(Integer id) {
        return musicRepository.findById(id).orElse(null);
    }


    public String deleteMusic(int id) {
        if (musicRepository.findById(id).isPresent()) {
            musicRepository.deleteById(id);
            return "music supprimé";
        } else
            return "music non supprimé";
    }

    public Music updateMusic(int id, Music newCandidat) {

        if (musicRepository.findById(id).isPresent()) {

            Music existingCandidat = musicRepository.findById(id).get();

//            Type nvtype= typeRepository.findById(newCandidat.getType().getId()).orElse(null);

            existingCandidat.setTitle(newCandidat.getTitle());
            existingCandidat.setAudio(newCandidat.getAudio());
            existingCandidat.setAlbum(newCandidat.getAlbum());

//            existingCandidat.setType(nvtype);


            return musicRepository.save(existingCandidat);
        } else

            return null;

    }






}

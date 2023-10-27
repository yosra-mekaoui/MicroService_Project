package com.example.musicmservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {


    @Autowired
    private TypeRepository typeRepository;


    public Type addType(Type type){

        return typeRepository.save(type);
    }



//    public Type updateType(int id, Type newType) {
//
//        if (typeRepository.findById(id).isPresent()) {
//
//            Type existingType = typeRepository.findById(id).get();
//
//            existingType.setName(newType.getName());
//
//
//            return typeRepository.save(existingType);
//        } else
//            return null;
//
//    }


    public Type updateType(int id, Type newCandidat) {

        if (typeRepository.findById(id).isPresent()) {

            Type existingCandidat = typeRepository.findById(id).get();

            existingCandidat.setName(newCandidat.getName());
            existingCandidat.setMusics(newCandidat.getMusics());

            return typeRepository.save(existingCandidat);
        } else

            return null;

    }




    public String deleteType(int id) {
        if (typeRepository.findById(id).isPresent()) {
            typeRepository.deleteById(id);
            return "type supprimé";
        } else
            return "type non supprimé";
    }

//
//    public List<Type> retrieveAllTypes() {
//        return  typeRepository.findAll();
//    }
//


    public List<Type> retrieveAllTypes() {
        List<Type> types = typeRepository.findAll();
        return types;
    }




}

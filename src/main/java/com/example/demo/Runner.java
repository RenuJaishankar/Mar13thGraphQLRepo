package com.example.demo;


import com.example.demo.Repository.AnimalRepository;
import com.example.demo.Repository.ArcadeGameRepository;
import com.example.demo.GraphQL.GraphQLDataFetchers;
import com.example.demo.Model.Animal;
import com.example.demo.Model.ArcadeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


//CommandLineRunner lets you write instructions for the program at the start of runtime
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ArcadeGameRepository arcadeGameRepository;


    @Autowired
    AnimalRepository animalRepository;


    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;
    // this run method will resolve at the start of your programs runtime

        @Override
    public void run(String... args) throws Exception {
          arcadeGameRepository.save(new ArcadeGame("Pac-man",1));
        arcadeGameRepository.save(new ArcadeGame("Ms.Pacman",1));
        arcadeGameRepository.save(new ArcadeGame("Pong",2));
        ArcadeGame game = new ArcadeGame("pong 1",2);
        // this code block turns our repository into a workable list
        GraphQLDataFetchers.arcadeGameList = StreamSupport
                .stream(arcadeGameRepository.findAll().spliterator(),false)

                .collect(Collectors.toList());
        System.out.println(game.getId());
        Animal testAnimal = new Animal(4,  "Wolf");


        animalRepository.save(new Animal(0,"Snake"));
        animalRepository.save(new Animal(4,"Cat"));


            animalRepository.save(testAnimal);

        // this code block turns our repository into a workable list
        GraphQLDataFetchers.animalList = StreamSupport
                .stream(animalRepository.findAll().spliterator(),false)

                .collect(Collectors.toList());

           System.out.println("Data Saved!");
            System.out.println(testAnimal.getId());
            System.out.println(GraphQLDataFetchers.arcadeGameList);
            System.out.println(GraphQLDataFetchers.animalList);

    }
}
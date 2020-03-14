package com.example.demo.Repository;

import com.example.demo.Model.ArcadeGame;
import org.springframework.data.repository.CrudRepository;

public interface ArcadeGameRepository extends CrudRepository<ArcadeGame, Long> {
}

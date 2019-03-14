package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.domain.Player;

@RepositoryRestResource(path = "players", collectionResourceRel = "players", itemResourceRel = "player")
public interface PlayerDao extends CrudRepository<Player, Long> {
    List<Player> findAll();

    Player findByName(String name);
}

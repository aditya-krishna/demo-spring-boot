package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.domain.Team;

@RepositoryRestResource(path = "teams", collectionResourceRel = "teams", itemResourceRel = "team")
public interface TeamDao extends CrudRepository<Team, Long> {
    List<Team> findAll();

    Team findByName(String name);
}

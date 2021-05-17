package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@SpringBootApplication
public class DemoSpringBootApplication extends SpringBootServletInitializer {
    @Autowired
    private TeamDao teamDao;

    
    public static void main(String[] args) {
        System.out.println("Running from main method");
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }

    /*
     * @Override protected SpringApplicationBuilder
     * configure(SpringApplicationBuilder builder) { return
     * builder.sources(DemoSpringBootApplication.class); }
     */

    @PostConstruct
    public void init() {
        System.out.println("Creating team");
        Set<Player> players = new HashSet<>();
        players.add(new Player("Charlie Brown", "pitcher"));
        players.add(new Player("Snoopy",
                "shortstop"));
        Team team = new Team("California", "Peanuts", players);
        teamDao.save(team);
    }

}

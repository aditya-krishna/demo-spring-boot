package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Team;

@Controller
public class DemoController {
    private Team team;

    @Autowired
    private TeamDao teamDao;

    @RequestMapping("/hi")
    public @ResponseBody String hiThere() {
        return "Hello There!";
    }

    @RequestMapping("/hi/team")
    public @ResponseBody Team hiTeam() {
        return team;
    }

    @RequestMapping("/hi/person/{name}")
    public String hiThere(Map<String, String> model, @PathVariable String name) {
        model.put("name", name);
        return "hello";
    }

    /*
     * @RequestMapping("/teams/{name}") public @ResponseBody Team
     * hiThere(@PathVariable String name) {
     * System.out.println("Received request for: " + name); return
     * teamDao.findByName(name); }
     */

    /*
     * @RequestMapping(method = RequestMethod.POST, value = "/teams")
     * public @ResponseBody void createTeam() {
     * System.out.println("Creating team"); Set<Player> players = new
     * HashSet<>(); players.add(new Player("Charlie Brown", "pitcher"));
     * players.add(new Player("Snoopy", "shortstop")); Team team = new
     * Team("California", "Peanuts", players); teamDao.save(team); }
     */

    /*
     * @PostConstruct public void init() { Set<Player> players = new
     * HashSet<>(); players.add(new Player("Charlie Brown", "pitcher"));
     * players.add(new Player("Snoopy", "shortstop")); team = new
     * Team("California", "Peanuts", players); }
     */
}

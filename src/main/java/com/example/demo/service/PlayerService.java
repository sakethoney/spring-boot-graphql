package com.example.demo.service;

import com.example.demo.domain.Player;
import com.example.demo.domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;


@Service
public class PlayerService {

    private final List<Player>  players = new ArrayList<>();
    AtomicInteger id = new AtomicInteger();

    public List<Player> findAll(){
        return players;
    }
    public Optional<Player> findOne(Integer id) {
        return players.stream().filter(player -> player.id() == id).findFirst();
    }

    public  Player create(String name, Team team){
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);
        return player;
    }
}

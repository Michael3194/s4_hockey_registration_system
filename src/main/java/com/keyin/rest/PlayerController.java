package com.keyin.rest;

import com.keyin.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<Player> updatePlayerById(@PathVariable long id, @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayerById(id, player));
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id) {
        Player player = playerService.getPlayerById(id);

        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/player")
    public Iterable<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return ResponseEntity.noContent().build();
    }

}

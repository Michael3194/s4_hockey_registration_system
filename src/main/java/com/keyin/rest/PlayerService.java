package com.keyin.rest;

import com.keyin.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    public Player updatePlayerById(Long id, Player updatedPlayer) {
        Optional<Player> playerToUpdateOptional = playerRepository.findById(id);

        if (playerToUpdateOptional.isPresent()) {
            Player playerToUpdate = playerToUpdateOptional.get();

            playerToUpdate.setBirthday(updatedPlayer.getBirthday());
            playerToUpdate.setFirstName(updatedPlayer.getFirstName());
            playerToUpdate.setLastName(updatedPlayer.getLastName());

            return playerRepository.save(playerToUpdate);
        }

        return null;
    }

    public Player getPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        return playerOptional.orElse(null);
    }

    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}

package ru.javapj.thelife.thelife.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import ru.javapj.thelife.thelife.model.Cell;
import ru.javapj.thelife.thelife.model.Game;

/**
 *
 * @author alex
 */
@Service
public class TheLifeService {
    
    private final Map<UUID, Game> games = new ConcurrentHashMap<>();
        
    public UUID startGame(int w, int h, List<Cell> cells) {
        Game game = new Game(UUID.randomUUID(), w, h, cells);
        for(Cell cell : cells) {
            cell.setGameId(game.getId());
        }
        games.put(game.getId(), game);
        return game.getId();
    }
    
    public List<Cell> move(UUID id) throws CloneNotSupportedException {
        Game game = games.get(id);
        if(game == null) {
            throw new RuntimeException("Game not found");
        }
        List<Cell> list = game.move();
        return list;
    }
    
}

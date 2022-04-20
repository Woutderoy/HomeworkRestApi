package nl.inholland.HomeworkWeek1.controllers;

import nl.inholland.HomeworkWeek1.models.Game;
import nl.inholland.HomeworkWeek1.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/games")
public class GameRestController {
    @Autowired
    private GameService gameService;

    @GetMapping()
    public List<Game> getGames(){
        return gameService.getAll();
    }

    @PutMapping("update")
    public String updateGame(@RequestBody Game game){
        return gameService.updateGames(game);
    }
    @PatchMapping("patch")
    public String patchGame(@RequestBody Game game){
        return gameService.patchGames(game);
    }
    @PostMapping("post")
    public Game addGame(@RequestBody Game g){
        return gameService.addGame(g);
    }

}

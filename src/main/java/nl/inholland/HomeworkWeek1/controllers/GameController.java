package nl.inholland.HomeworkWeek1.controllers;

import nl.inholland.HomeworkWeek1.models.Game;
import nl.inholland.HomeworkWeek1.services.GameService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("games")
public class GameController {

//    private int number = 1;
//
//    @RequestMapping("number")
//    public ResponseEntity<Integer> getNumber(){
//        number++;
//        return ResponseEntity.ok(number);
//    }
//
//    @RequestMapping("")
//    public ResponseEntity getGames(){
//        return ResponseEntity.status(200).body("Hier staat niks");
//    }
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "", method = RequestMethod.GET,
     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getGames(){

        return ResponseEntity.status(200).body(gameService.getAll());

    }

    @RequestMapping(value = "", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addGames(@RequestBody Game g){

        Game result = gameService.addGame(g);

        return ResponseEntity.status(201).body(g);

    }
}

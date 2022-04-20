package nl.inholland.HomeworkWeek1.services;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import nl.inholland.HomeworkWeek1.models.Game;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {
    List<Game> gameList = new ArrayList<>();

    public GameService() {
        gameList.add(new Game( "1","Grand Theft Auto V", 60));
        gameList.add(new Game("2","Red Dead Redemption 2", 59.99));
    }
//updategames is used to update a game in its entirety overwriting the whole item
    public String updateGames(Game game){
        boolean itemFound = false;
        for(Game currentItem: gameList){
            if(Objects.equals(currentItem.getId(), game.getId())){
                itemFound = true;
                currentItem.setId(game.getId());
                currentItem.setName(game.getName());
                currentItem.setPrice(game.getPrice());
            }
            if(!itemFound){
                gameList.add(game);
                return "Game added succesfully";
            }
        }
        return "Game succesfully updated!";
    }
//patchgames is used to update specific parts of the json object without needing to fill in all the values again
    public String patchGames(Game game) {
        for (Game currentItem : gameList) {
            if (Objects.equals(currentItem.getId(), game.getId())) {
                if (game.getName() != null) {
                    currentItem.setName(game.getName());
                }
                if (game.getPrice() != 0) {
                    currentItem.setPrice(game.getPrice());
                }
                return "Game has been updated succesfully!";
            }
        }
        return "Something went wrong!";
    }



    public List<Game> getAll(){
        return gameList;
    }
//adds games to the list
    public Game addGame(Game g){

        gameList.add(g);
        return g;
    }

}

package ru.javapj.thelife.thelife.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.javapj.thelife.thelife.model.Cell;
import ru.javapj.thelife.thelife.service.TheLifeService;

/**
 *
 * @author alex
 */
@RestController
@RequestMapping("/game")
@CrossOrigin
public class TheLifeController {
    
    @Autowired
    private TheLifeService theLifeService;
    
    @RequestMapping(value = "/start", method = {RequestMethod.POST}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ResponseEntity<UUID> gameStart(@RequestParam int w, @RequestParam int h, @RequestBody List<Cell> cells) {
        UUID id = theLifeService.startGame(w, h, cells);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/move", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<?> gameStart(@RequestParam UUID id) throws CloneNotSupportedException {
        try {
            List<Cell> list = theLifeService.move(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch(RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
    }
}

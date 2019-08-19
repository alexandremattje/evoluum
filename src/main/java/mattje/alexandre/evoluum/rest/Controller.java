package mattje.alexandre.evoluum.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.model.Moviment;

@RestController
@RequestMapping("/rest")
public class Controller {

    private Moviment moviment;

    @GetMapping(path = "/mars")
    public ResponseEntity<Robot> listar(@RequestParam String command) {
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

}

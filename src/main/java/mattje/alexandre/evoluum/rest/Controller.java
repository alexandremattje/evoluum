package mattje.alexandre.evoluum.rest;

import java.lang.reflect.Executable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mattje.alexandre.evoluum.dto.CommandExecuted;
import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.dto.Terrain;
import mattje.alexandre.evoluum.enums.CommandStatus;
import mattje.alexandre.evoluum.model.CommandModel;

@RestController
@RequestMapping("/rest")
public class Controller {

    private static Terrain terrain = Terrain.builder().height(5).width(5).build();

    @Autowired
    private CommandModel commandModel;

    @PostMapping(path = "/mars/{command}")
    public ResponseEntity<Robot> mars(@PathVariable String command, @RequestBody Robot robot) {
        CommandExecuted executed = commandModel.executeCommand(robot, command, terrain);
        if (CommandStatus.OK.equals(executed.getStatus())) {
            return new ResponseEntity<>(executed.getRobot(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

package mattje.alexandre.evoluum.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.dto.Terrain;
import mattje.alexandre.evoluum.enums.CommandLetters;

@Component
public class Moviment {

	@Autowired
	private Command command;

	public Robot executeCommand(Robot robot, String commands, Terrain terrain) {
		char[] chars = commands.toCharArray();
		for (char c : chars) {
			if (CommandLetters.L.getLetter() == c) {
				robot = command.left(robot);
			} else if (CommandLetters.R.getLetter() == c) {
				robot = command.right(robot);
			} else if (CommandLetters.M.getLetter() == c) {
				robot = command.move(robot);
			}
		}

		return robot;
	}

}

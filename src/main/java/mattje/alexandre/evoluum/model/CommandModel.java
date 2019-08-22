package mattje.alexandre.evoluum.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mattje.alexandre.evoluum.dto.CommandExecuted;
import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.dto.Terrain;
import mattje.alexandre.evoluum.enums.CommandLetters;
import mattje.alexandre.evoluum.enums.CommandStatus;

@Component
public class CommandModel {

	@Autowired
	private MoveModel move;

	public CommandExecuted executeCommand(Robot robot, String commands, Terrain terrain) {
		char[] commandsInArray = commands.toCharArray();
		for (char singleCommand : commandsInArray) {
			if (CommandLetters.L.getLetter() == singleCommand) {
				robot = move.left(robot);
			} else if (CommandLetters.R.getLetter() == singleCommand) {
				robot = move.right(robot);
			} else if (CommandLetters.M.getLetter() == singleCommand) {
				robot = move.move(robot);
				if (!checkTerrainBounds(robot, terrain)) {
					return CommandExecuted.builder()
							.status(CommandStatus.OUT_OF_BOUNDS)
							.build();
				}
			} else {
				return CommandExecuted.builder()
						.status(CommandStatus.INVALID_COMMAND)
						.build();
			}
		}

		return CommandExecuted.builder()
				.robot(robot)
				.status(CommandStatus.OK)
				.build();
	}

	private boolean checkTerrainBounds(Robot robot, Terrain terrain) {
		return terrain.getHeight() >= robot.getY() && terrain.getWidth() >= robot.getX() && robot.getX() >= 0 && robot.getY() >= 0;
	}

}

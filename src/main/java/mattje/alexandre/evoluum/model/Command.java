package mattje.alexandre.evoluum.model;

import org.springframework.stereotype.Component;

import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.enums.Direction;

@Component
public class Command {

	public Robot left(Robot robot) {
		int newDirection = robot.getDirection().ordinal() - 1;
		if (newDirection == -1) {
			newDirection = 3;
		}

		return robot.toBuilder().direction(Direction.values()[newDirection]).build();
	}

	public Robot right(Robot robot) {
		int newDirection = robot.getDirection().ordinal() + 1;
		if (newDirection == 4) {
			newDirection = 0;
		}

		return robot.toBuilder().direction(Direction.values()[newDirection]).build();
	}

	public Robot move(Robot robot) {
		switch (robot.getDirection()) {
		case NORTH:
			return robot.toBuilder().y(robot.getY() + 1).build();
		case SOUTH:
			return robot.toBuilder().y(robot.getY() - 1).build();
		case WEST:
			return robot.toBuilder().x(robot.getX() - 1).build();
		case EAST:
			return robot.toBuilder().x(robot.getX() + 1).build();
		}
		return robot;
	}

}

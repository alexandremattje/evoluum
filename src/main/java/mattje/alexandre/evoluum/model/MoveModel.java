package mattje.alexandre.evoluum.model;

import org.springframework.stereotype.Component;

import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.enums.Direction;

@Component
public class MoveModel {


	public Robot left(Robot robot) {
		int newDirection = robot.getDirection().ordinal() - 1;
		if (newDirection < Direction.W.ordinal()) {
			newDirection = Direction.S.ordinal();
		}

		return robot.toBuilder().direction(Direction.values()[newDirection]).build();
	}

	public Robot right(Robot robot) {
		int newDirection = robot.getDirection().ordinal() + 1;
		if (newDirection > Direction.S.ordinal()) {
			newDirection = Direction.W.ordinal();
		}

		return robot.toBuilder().direction(Direction.values()[newDirection]).build();
	}

	public Robot move(Robot robot) {
		switch (robot.getDirection()) {
		case N:
			return robot.toBuilder().y(robot.getY() + 1).build();
		case S:
			return robot.toBuilder().y(robot.getY() - 1).build();
		case W:
			return robot.toBuilder().x(robot.getX() - 1).build();
		case E:
			return robot.toBuilder().x(robot.getX() + 1).build();
		}
		return robot;
	}

}

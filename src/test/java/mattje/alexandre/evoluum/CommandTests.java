package mattje.alexandre.evoluum;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mattje.alexandre.evoluum.dto.CommandExecuted;
import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.dto.Terrain;
import mattje.alexandre.evoluum.enums.CommandStatus;
import mattje.alexandre.evoluum.enums.Direction;
import mattje.alexandre.evoluum.model.CommandModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandTests {

	@Autowired
	private CommandModel moviment;

	@Test
	public void testMMRMMRMM() {
		CommandExecuted executed = moviment.executeCommand(defaultRobotStartPosition(), "MMRMMRMM", defaultTerrain());

		Assertions.assertThat(executed.getStatus()).isEqualTo(CommandStatus.OK);
		Assertions.assertThat(executed.getRobot()).isEqualTo(Robot.builder()
				.direction(Direction.S)
				.x(2)
				.y(0)
				.build());
	}

	@Test
	public void testMML() {
		CommandExecuted executed = moviment.executeCommand(defaultRobotStartPosition(), "MML", defaultTerrain());

		Assertions.assertThat(executed.getStatus()).isEqualTo(CommandStatus.OK);
		Assertions.assertThat(executed.getRobot()).isEqualTo(Robot.builder()
				.direction(Direction.W)
				.x(0)
				.y(2)
				.build());

		executed = moviment.executeCommand(defaultRobotStartPosition(), "MML", defaultTerrain());

		Assertions.assertThat(executed.getStatus()).isEqualTo(CommandStatus.OK);
		Assertions.assertThat(executed.getRobot()).isEqualTo(Robot.builder()
				.direction(Direction.W)
				.x(0)
				.y(2)
				.build());
	}

	@Test
	public void testAAA() {
		CommandExecuted executed = moviment.executeCommand(defaultRobotStartPosition(), "AAA", defaultTerrain());

		Assertions.assertThat(executed.getStatus()).isEqualTo(CommandStatus.INVALID_COMMAND);
	}

	@Test
	public void testMMMMMMMMMMMMMMMMMMMMMMMM() {
		CommandExecuted executed = moviment.executeCommand(defaultRobotStartPosition(), "MMMMMMMMMMMMMMMMMMMMMMMM", defaultTerrain());

		Assertions.assertThat(executed.getStatus()).isEqualTo(CommandStatus.OUT_OF_BOUNDS);
	}

	private Terrain defaultTerrain() {
		return Terrain.builder()
				.height(5)
				.width(5)
				.build();
	}

	private Robot defaultRobotStartPosition() {
		return Robot.builder()
				.direction(Direction.N)
				.x(0)
				.y(0)
				.build();
	}

}

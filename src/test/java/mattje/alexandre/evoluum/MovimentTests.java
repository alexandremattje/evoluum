package mattje.alexandre.evoluum;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.dto.Terrain;
import mattje.alexandre.evoluum.enums.Direction;
import mattje.alexandre.evoluum.model.Moviment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimentTests {

	@Autowired
	private Moviment moviment;

	@Test
	public void testMMRMMRMM() {
		Robot robot = moviment.executeCommand(defaultRobotStartPosition(), "MMRMMRMMR", defaultTerrain());

		Assertions.assertThat(robot).isEqualTo(Robot.builder()
				.direction(Direction.NORTH)
				.x(2)
				.y(0)
				.build());
	}

	@Test
	public void testMML() {
		Robot robot = moviment.executeCommand(defaultRobotStartPosition(), "MML", defaultTerrain());

		Assertions.assertThat(robot).isEqualTo(Robot.builder()
				.direction(Direction.WEST)
				.x(0)
				.y(2)
				.build());

		robot = moviment.executeCommand(defaultRobotStartPosition(), "MML", defaultTerrain());

		Assertions.assertThat(robot).isEqualTo(Robot.builder()
				.direction(Direction.WEST)
				.x(0)
				.y(2)
				.build());
	}

	@Test
	public void testAAA() {
		// moviment.checkCommand(defaultRobotStartPosition(), "AAA", defaultTerrain());


	}

	private Terrain defaultTerrain() {
		return Terrain.builder()
				.height(5)
				.width(5)
				.build();
	}

	private Robot defaultRobotStartPosition() {
		return Robot.builder()
				.direction(Direction.NORTH)
				.x(0)
				.y(0)
				.build();
	}

}

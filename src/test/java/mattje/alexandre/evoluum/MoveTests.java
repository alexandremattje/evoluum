package mattje.alexandre.evoluum;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mattje.alexandre.evoluum.dto.Robot;
import mattje.alexandre.evoluum.enums.Direction;
import mattje.alexandre.evoluum.model.MoveModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoveTests {

	@Autowired
	private MoveModel moveModel;

	@Test
	public void testLeft() {
		Robot robotLeft = moveModel.left(Robot.builder()
				.direction(Direction.N)
				.x(1)
				.y(1)
				.build());

		Assertions.assertThat(robotLeft).isEqualTo(Robot.builder()
				.direction(Direction.W)
				.x(1)
				.y(1)
				.build());
	}

	@Test
	public void test360Left() {
		Robot robotLeft = moveModel.left(Robot.builder()
				.direction(Direction.N)
				.x(1)
				.y(1)
				.build());
		robotLeft = moveModel.left(robotLeft);
		robotLeft = moveModel.left(robotLeft);
		robotLeft = moveModel.left(robotLeft);

		Assertions.assertThat(robotLeft).isEqualTo(Robot.builder()
				.direction(Direction.N)
				.x(1)
				.y(1)
				.build());
	}

	@Test
	public void testRight() {
		Robot robotRight = moveModel.right(Robot.builder()
				.direction(Direction.N)
				.x(1)
				.y(1)
				.build());

		Assertions.assertThat(robotRight).isEqualTo(Robot.builder()
				.direction(Direction.E)
				.x(1)
				.y(1)
				.build());
	}

	@Test
	public void test360Right() {
		Robot robotRight = moveModel.right(Robot.builder()
				.direction(Direction.N)
				.x(1)
				.y(1)
				.build());

		robotRight = moveModel.right(robotRight);
		robotRight = moveModel.right(robotRight);
		robotRight = moveModel.right(robotRight);

		Assertions.assertThat(robotRight).isEqualTo(Robot.builder()
				.direction(Direction.N)
				.x(1)
				.y(1)
				.build());
	}

	@Test
	public void testMove() {
		Robot robotMove = moveModel.move(Robot.builder()
				.direction(Direction.W)
				.x(1)
				.y(1)
				.build());

		Assertions.assertThat(robotMove).isEqualTo(Robot.builder()
				.direction(Direction.W)
				.x(0)
				.y(1)
				.build());
	}


}

package mattje.alexandre.evoluum.dto;

import lombok.Builder;
import lombok.Data;

import mattje.alexandre.evoluum.enums.Direction;

@Data
@Builder(toBuilder = true)
public class Robot {

	private int x;
	private int y;
	private Direction direction;

}

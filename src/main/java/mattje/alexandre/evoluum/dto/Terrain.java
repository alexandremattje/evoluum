package mattje.alexandre.evoluum.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Terrain {

	private int height;
	private int width;

}

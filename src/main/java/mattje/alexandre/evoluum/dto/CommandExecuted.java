package mattje.alexandre.evoluum.dto;

import lombok.Builder;
import lombok.Data;

import mattje.alexandre.evoluum.enums.CommandStatus;

@Data
@Builder
public class CommandExecuted {

	private Robot robot;
	private CommandStatus status;

}

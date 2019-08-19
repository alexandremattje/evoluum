package mattje.alexandre.evoluum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CommandLetters {

	M('M'),
	L('L'),
	R('R'),
	;

	@Getter
	private char letter;

}

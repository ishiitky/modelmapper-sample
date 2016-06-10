package modelmapper.sample;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StringToBoolean {

	/**
	 * String を含む Bean を Boolean の Bean に変換する.
	 * 
	 * @param src
	 * @return
	 */
	public static DestStringToBoolean convert(SrcStringToBoolean src) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(src, DestStringToBoolean.class);
	}
}

@AllArgsConstructor
@Data
class SrcStringToBoolean {
	private String flag;
}

@Data
class DestStringToBoolean {
	private Boolean flag;
}

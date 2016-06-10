package modelmapper.sample;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

public class BooleanToString {

	/**
	 * Boolean を含む Bean を String の Bean に変換する.
	 * 
	 * @param src
	 * @return
	 */
	public static DestBooleanToString convert(SrcBooleanToString src) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(src, DestBooleanToString.class);
	}
}

@AllArgsConstructor
@Data
class SrcBooleanToString {
	private Boolean flag;
}

@Data
class DestBooleanToString {
	private String flag;
}

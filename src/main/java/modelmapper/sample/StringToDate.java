package modelmapper.sample;

import java.util.Date;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StringToDate {

	/**
	 * String を含む Bean を Date の Bean に変換する.
	 * 
	 * @param src
	 * @return
	 */
	public static DestStringToDate convert(SrcStringToDate src) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(src, DestStringToDate.class);
	}
}

@AllArgsConstructor
@Data
class SrcStringToDate {
	private String date;
}

@Data
class DestStringToDate {
	private Date date;
}

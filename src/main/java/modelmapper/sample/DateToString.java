package modelmapper.sample;

import java.util.Date;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DateToString {

	/**
	 * Date を含む Bean を String の Bean に変換する.
	 * 
	 * @param src
	 * @return
	 */
	public static DestDateToString convert(SrcDateToString src) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(src, DestDateToString.class);
	}
}

@AllArgsConstructor
@Data
class SrcDateToString {
	private Date date;
}

@Data
class DestDateToString {
	private String date;
}

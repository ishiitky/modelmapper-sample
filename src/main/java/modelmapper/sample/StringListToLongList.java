package modelmapper.sample;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StringListToLongList {

	public static void main(String... args) {

		List<String> target = new ArrayList<String>();
		target.add("1");
		target.add("2");
		target.add("3");

		ModelMapper mapper = new ModelMapper();
		List<Long> result = new ArrayList<Long>();
		mapper.map(target, result);
		System.out.println(result);

	}
}

@AllArgsConstructor
@Data
class SrcStringListToLongList {
	private List<String> StringIdList;
}

@Data
class DestStringListToLongList {
	private List<Long> LongIdList;
}

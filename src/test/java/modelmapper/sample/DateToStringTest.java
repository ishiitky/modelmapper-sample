package modelmapper.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class DateToStringTest {

	@Test
	public void Date型からString型への変換確認() throws ParseException {
        String dateStr = "20150102 01:23:45";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        
		SrcDateToString src = new SrcDateToString(sdf.parse(dateStr));
		DestDateToString dest = DateToString.convert(src);
		assertThat(dest.getDate(), is("Fri Jan 02 01:23:45 JST 2015"));
	}

	@Test
	public void nullの場合はnullのまま() {
		SrcDateToString src = new SrcDateToString(null);
		DestDateToString dest = DateToString.convert(src);
		assertNull(dest.getDate());
	}
}

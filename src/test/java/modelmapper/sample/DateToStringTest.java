package modelmapper.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DateToStringTest {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
	Date target; // 引数
	SrcDateToString src; // 変換前bean
	DestDateToString dest; // 変換後bean

	@Before
	public void init() {
		target = null;
		src = null;
		dest = null;
	}

	@Test
	public void Date型からString型への変換確認() throws ParseException {
		
		// 期待通りの日付に変更されていること
		target = sdf.parse("20150102 01:23:45.678");
		src = new SrcDateToString(target);
		dest = DateToString.convert(src);
		assertThat(dest.getDate(), is(target.toString())); // DateのString型と同じであること
		assertThat(dest.getDate(), is("Fri Jan 02 01:23:45 JST 2015")); // 中身の確認

		//　9999年12月31日(2038年問題が発生しないこと)
		target = sdf.parse("99991231 23:59:59.999");
		src = new SrcDateToString(target);
		dest = DateToString.convert(src);
		assertThat(dest.getDate(), is(target.toString()));
		assertThat(dest.getDate(), is("Fri Dec 31 23:59:59 JST 9999"));

		// 1900年1月1日(1970年問題が発生しないこと)
		target = sdf.parse("19000101 00:00:00.000");
		src = new SrcDateToString(target);
		dest = DateToString.convert(src);
		assertThat(dest.getDate(), is(target.toString()));
		assertThat(dest.getDate(), is("Mon Jan 01 00:00:00 JST 1900"));
	}

	@Test
	public void nullの場合はnullのまま() {
		SrcDateToString src = new SrcDateToString(null);
		DestDateToString dest = DateToString.convert(src);
		assertNull(dest.getDate());
	}

	@Test
	public void Date型の注意すべき動作() throws ParseException {
		// 0000年は0002年に変換される
		target = sdf.parse("00000000 00:00:00.000");
		src = new SrcDateToString(target);
		dest = DateToString.convert(src);
		assertThat(dest.getDate(), is(target.toString()));
		assertThat(dest.getDate(), is("Sun Nov 30 00:00:00 JST 2"));
	}
}

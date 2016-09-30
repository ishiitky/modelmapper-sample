package modelmapper.sample;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import lombok.Data;

public class Skip {
	public static void main(String... args) {
		SrcSkip src = new SrcSkip();
		src.setName("name");
		src.setLoginName("loginName");

		List<String> groupIdList = Arrays.asList("1", "2", "3");
		src.setGroupIdList(groupIdList);

		ModelMapper mapper = new ModelMapper();
		PropertyMap<SrcSkip, DestSkip> map = new PropertyMap<SrcSkip, DestSkip>() {
			@Override
			protected void configure() {
				map().setId(null);
			}
		};
		mapper.addMappings(map);

		DestSkip dest = mapper.map(src, DestSkip.class);
		System.out.println(dest.toString());
	}
}

@Data
class SrcSkip {
	private String name;
	private String loginName;
	private String loginStatus;
	private String lastLogin;
	private String isAdmin;
	private String mailAddress;
	private String loginPassword;
	private String passwordUpdated;
	private String passwordLifetime;
	private List<String> groupIdList;
}

@Data
class DestSkip {
	private Long id;
	private Integer lockVersion;
	private Date created;
	private Date updated;
	private String name;
	private String loginName;
	private Integer loginStatus;
	private Date lastLogin;
	private Boolean isAdmin;
	private String mailAddress;
	private String loginPassword;
	private Date passwordUpdated;
	private Integer passwordLifetime;
}
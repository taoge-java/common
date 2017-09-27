package common.spring;

import java.util.List;

import org.junit.Test;

public class TestModel {

	@Test
	public void test() {
		BaseJdbcTemplate jdbcTemplate = new BaseJdbcTemplate();
		List<User> list = jdbcTemplate.findAll("select * from user",User.class);
		for (User user : list) {
			System.err.println(user.getPassword());
		}
		System.err.println(list);
	}
}

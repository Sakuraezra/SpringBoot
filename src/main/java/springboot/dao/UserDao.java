package springboot.dao;

import springboot.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author ezra
 * @ date 2019/3/27 12:32
 */
public class UserDao {
	public List<User> queryUserList(){

		List<User> result = new ArrayList<User>();
		//模拟数据库

		for(int i =0 ;i<10;i++)
		{
			User user = new User();
			user.setUsername("username_"+i);
			user.setPassword("password_"+i);
			user.setAge(i+1);
			result.add(user);
		}
		return result;
	}
}

package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.User;
import springboot.mapper.UserMapper;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/3/27 14:24
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> queryUserList() {
		return this.userMapper.selectUserAll();
	}
}

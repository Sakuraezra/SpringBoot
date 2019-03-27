package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dao.UserDao;
import springboot.entity.User;
import java.util.List;

/**
 * @ author ezra
 * @ date 2019/3/27 14:24
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> queryUserList() {
		return this.userDao.queryUserList();
	}
}

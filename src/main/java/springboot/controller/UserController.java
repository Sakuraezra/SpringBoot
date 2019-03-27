package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.User;
import springboot.service.UserService;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/3/27 16:20
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {
	@Autowired
	private UserService userService;

	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("getUser")
	public String getUser() {
		List<User> userList = userService.queryUserList();
		for (User user : userList) {
			LOGGER.info(user.toString());
		}
		return "SUCCESS";
	}
}

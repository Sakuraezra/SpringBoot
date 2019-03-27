package springboot.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springboot.Springconfig.SpringConfig;
import springboot.entity.User;
import springboot.service.UserService;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/3/27 14:40
 */
public class Main {
	public static void main(String[] args) {
		//通过jaqva配置来实例化Spring容器
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(SpringConfig.class);

		//Spring容器中获取Bean对象
		UserService userService = context.getBean(UserService.class);

		List<User> userList = userService.queryUserList();
		for(User user:userList)
		{
			System.out.println(user.toString());
		}

		context.destroy();
	}
}

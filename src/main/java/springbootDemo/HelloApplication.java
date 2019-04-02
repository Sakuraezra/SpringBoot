package springbootDemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @ author ezra
 * @ date 2019/3/27 18:32
 */

@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {


	@RequestMapping("hello")
	@ResponseBody
	public String hello()
	{
		return "hello world";
	}

	public static void main(String[] args) {

//		SpringApplication.run(HelloApplication.class,args);


		//banner隐藏
		SpringApplication application = new SpringApplication(HelloApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}

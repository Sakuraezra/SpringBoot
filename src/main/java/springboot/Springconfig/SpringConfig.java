package springboot.Springconfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springboot.dao.UserDao;
/**
 * @ author ezra
 * @ date 2019/3/27 14:27
 */
@Configuration   // 通过该注解来表明该类是一个spring的配置。相当于一个XML
@ComponentScan(basePackages = "springboot")  // 配置扫描包
@PropertySource(value = {"classpath:mybatis.properties"}, ignoreResourceNotFound = true)
public class SpringConfig {

	@Bean  // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>
	public UserDao getUserDao() {
		return new UserDao();  //new 对象
	}

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.username}")
	private String jdbcUsername;

	@Value("${jdbc.password}")
	private String jdbcPassword;


	@Bean(destroyMethod = "close")
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(jdbcDriverClassName);
		basicDataSource.setUrl(jdbcUrl);
		basicDataSource.setUsername(jdbcUsername);
		basicDataSource.setPassword(jdbcPassword);
		basicDataSource.setMaxIdle(100);
		basicDataSource.setMinIdle(5);
		return basicDataSource;
	}

}

package springboot.mapper;

import org.springframework.stereotype.Repository;
import springboot.entity.User;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/3/27 16:26
 */
@Repository
public interface UserMapper {
	List<User> selectUserAll();
}

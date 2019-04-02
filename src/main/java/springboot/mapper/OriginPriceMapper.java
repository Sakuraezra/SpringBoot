package springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import springboot.entity.OriginPrice;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/4/2 10:37
 */
@Repository
public interface OriginPriceMapper {

	List<OriginPrice> selectHospital();
	int updateHospitalByIdNumber(@Param("IDNumber") String IDNumber, @Param("hospitalPrice") String hospitalPrice);

	List<OriginPrice> selectPersonal();
	int updatePersonalByIdNumber(@Param("IDNumber") String IDNumber, @Param("personalPrice") String personalPrice);

}

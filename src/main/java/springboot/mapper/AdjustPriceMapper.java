package springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import springboot.entity.AdjustPrice;
import springboot.entity.FinalPrice;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/4/2 10:38
 */
@Repository
public interface AdjustPriceMapper {

	List<AdjustPrice> selectHospital();
	int updateHospitalByIdNumber(@Param("IDNumber") String IDNumber, @Param("hospitalPrice") String hospitalPrice);

	List<AdjustPrice> selectPersonal();
	int updatePersonalByIdNumber(@Param("IDNumber") String IDNumber, @Param("personalPrice") String personalPrice);


	List<FinalPrice> selectFinalHospital();
	int updateFinalHospitalPrice(@Param("IDNumber") String IDNumber, @Param("hospital") String hospital);

	List<FinalPrice> selectFinalPersonal();
	int updateFinalPersonalPrice(@Param("IDNumber") String IDNumber, @Param("personal") String personal);


}

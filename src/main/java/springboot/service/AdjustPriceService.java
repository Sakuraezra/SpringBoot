package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.AdjustPrice;
import springboot.entity.FinalPrice;
import springboot.mapper.AdjustPriceMapper;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/4/2 10:40
 */
@Service
public class AdjustPriceService {
	@Autowired
	AdjustPriceMapper adjustPriceMapper;

	public List<AdjustPrice> selectHospital() {
		return adjustPriceMapper.selectHospital();
	}

	public List<AdjustPrice> selectPersonal() {
		return adjustPriceMapper.selectPersonal();
	}

	public int updateHospitalByIdNumber(String IDNumber, String hospitalPrice) {
		return adjustPriceMapper.updateHospitalByIdNumber(IDNumber, hospitalPrice);
	}

	public int updatePersonalByIdNumber(String IDNumber, String personalPrice) {
		return adjustPriceMapper.updatePersonalByIdNumber(IDNumber, personalPrice);
	}


	public List<FinalPrice> selectFinalHospital()
	{
		return adjustPriceMapper.selectFinalHospital();
	}

	public int updateFinalHospitalPrice(String IDNumber, String hospital) {
		return adjustPriceMapper.updateFinalHospitalPrice(IDNumber, hospital);
	}

	public List<FinalPrice> selectFinalPersonal()
	{
		return adjustPriceMapper.selectFinalPersonal();
	}

	public int updateFinalPersonalPrice(String IDNumber, String personal) {
		return adjustPriceMapper.updateFinalPersonalPrice(IDNumber, personal);
	}


}

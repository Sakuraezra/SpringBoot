package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.AdjustPrice;
import springboot.entity.OriginPrice;
import springboot.mapper.OriginPriceMapper;

import java.util.List;

/**
 * @ author ezra
 * @ date 2019/4/2 10:39
 */
@Service
public class OriginPriceService {

	@Autowired
	OriginPriceMapper originPriceMapper;

	public List<OriginPrice> selectHospital() {
		return originPriceMapper.selectHospital();
	}

	public List<OriginPrice> selectPersonal() {
		return originPriceMapper.selectPersonal();
	}

	public int updateHospitalByIdNumber(String IDNumber, String hospitalPrice) {
		return originPriceMapper.updateHospitalByIdNumber(IDNumber, hospitalPrice);
	}

	public int updatePersonalByIdNumber(String IDNumber, String personalPrice) {
		return originPriceMapper.updatePersonalByIdNumber(IDNumber, personalPrice);
	}
}

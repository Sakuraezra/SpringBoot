package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.AdjustPrice;
import springboot.entity.FinalPrice;
import springboot.entity.OriginPrice;
import springboot.service.AdjustPriceService;
import springboot.service.OriginPriceService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ author ezra
 * @ date 2019/4/2 10:41
 */
@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	AdjustPriceService adjustPriceService;
	@Autowired
	OriginPriceService originPriceService;

	@RequestMapping(value = "/adjustHospital")
	public String adjustHospital() throws Exception {
		List<AdjustPrice> adjustPrices = adjustPriceService.selectHospital();
		Map<Object, BigDecimal> map = new HashMap<>();

		for (AdjustPrice adjustPrice : adjustPrices) {
			BigDecimal bigDecimal = new BigDecimal(adjustPrice.getAdjustPrice());
			if (!map.containsKey(adjustPrice.getIDNumber())) {
				map.put(adjustPrice.getIDNumber(), bigDecimal);
			} else {
				map.put(adjustPrice.getIDNumber(), bigDecimal.add(map.get(adjustPrice.getIDNumber())));
			}
		}
		for (Map.Entry<Object, BigDecimal> entry : map.entrySet()) {
			adjustPriceService.updateHospitalByIdNumber(entry.getKey().toString(),entry.getValue().toString());
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return "success";
	}

	@RequestMapping(value = "/adjustPersonal")
	public String adjustPersonal() {
		List<AdjustPrice> adjustPrices = adjustPriceService.selectPersonal();
		Map<Object, BigDecimal> map = new HashMap<>();

		for (AdjustPrice adjustPrice : adjustPrices) {
			BigDecimal bigDecimal = new BigDecimal(adjustPrice.getAdjustPrice());
			if (!map.containsKey(adjustPrice.getIDNumber())) {
				map.put(adjustPrice.getIDNumber(), bigDecimal);
			} else {
				map.put(adjustPrice.getIDNumber(), bigDecimal.add(map.get(adjustPrice.getIDNumber())));
			}
		}
		for (Map.Entry<Object, BigDecimal> entry : map.entrySet()) {
			adjustPriceService.updatePersonalByIdNumber(entry.getKey().toString(),entry.getValue().toString());
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return "success";
	}

	@RequestMapping(value = "/originHospital")
	public String originHospital() throws Exception {
		List<OriginPrice> originPrices = originPriceService.selectHospital();
		Map<Object, BigDecimal> map = new HashMap<>();

		for (OriginPrice originPrice : originPrices) {
			BigDecimal bigDecimal = new BigDecimal(originPrice.getOriginPrice());
			if (!map.containsKey(originPrice.getIDNumber())) {
				map.put(originPrice.getIDNumber(), bigDecimal);
			} else {
				map.put(originPrice.getIDNumber(), bigDecimal.add(map.get(originPrice.getIDNumber())));
			}
		}
		for (Map.Entry<Object, BigDecimal> entry : map.entrySet()) {
			originPriceService.updateHospitalByIdNumber(entry.getKey().toString(),entry.getValue().toString());
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return "success";
	}


	@RequestMapping(value = "/originPersonal")
	public String originPersonal() {
		List<OriginPrice> originPrices = originPriceService.selectPersonal();
		Map<Object, BigDecimal> map = new HashMap<>();

		for (OriginPrice originPrice : originPrices) {
			BigDecimal bigDecimal = new BigDecimal(originPrice.getOriginPrice());
			if (!map.containsKey(originPrice.getIDNumber())) {
				map.put(originPrice.getIDNumber(), bigDecimal);
			} else {
				map.put(originPrice.getIDNumber(), bigDecimal.add(map.get(originPrice.getIDNumber())));
			}
		}
		for (Map.Entry<Object, BigDecimal> entry : map.entrySet()) {
			originPriceService.updatePersonalByIdNumber(entry.getKey().toString(),entry.getValue().toString());
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return "success";
	}


	@RequestMapping(value = "/countHospital")
	public String countHospital() {

		List<FinalPrice> finalPrices = adjustPriceService.selectFinalHospital();

		for (FinalPrice finalPrice : finalPrices) {
			BigDecimal originPrice = new BigDecimal(finalPrice.getOriginHospital());
			BigDecimal adjustPrice = new BigDecimal(finalPrice.getAdjustHospital());
			BigDecimal hospital = originPrice.subtract(adjustPrice);
			adjustPriceService.updateFinalHospitalPrice(finalPrice.getIDNumber(),hospital.toString());
			System.out.println("Key = " + finalPrice.getIDNumber() + ", Value = " + hospital);
		}
		return "success";
	}


	@RequestMapping(value = "/countPersonal")
	public String countPersonal() {

		List<FinalPrice> finalPrices = adjustPriceService.selectFinalPersonal();

		for (FinalPrice finalPrice : finalPrices) {
			BigDecimal adjustPersonal = new BigDecimal(finalPrice.getAdjustPersonal());
			BigDecimal originPersonal = new BigDecimal(finalPrice.getOriginPersonal());
			BigDecimal personal = originPersonal.subtract(adjustPersonal);
			adjustPriceService.updateFinalPersonalPrice(finalPrice.getIDNumber(),personal.toString());
			System.out.println("Key = " + finalPrice.getIDNumber() + ", Value = " + personal);
		}
		return "success";
	}

}

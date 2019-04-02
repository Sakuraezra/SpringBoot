package springboot.entity;

/**
 * @ author ezra
 * @ date 2019/4/2 16:05
 */
public class FinalPrice {
	String IDNumber;
	String adjustHospital;
	String adjustPersonal;
	String originHospital;
	String originPersonal;

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String IDNumber) {
		this.IDNumber = IDNumber;
	}

	public String getAdjustHospital() {
		return adjustHospital;
	}

	public void setAdjustHospital(String adjustHospital) {
		this.adjustHospital = adjustHospital;
	}

	public String getAdjustPersonal() {
		return adjustPersonal;
	}

	public void setAdjustPersonal(String adjustPersonal) {
		this.adjustPersonal = adjustPersonal;
	}

	public String getOriginHospital() {
		return originHospital;
	}

	public void setOriginHospital(String originHospital) {
		this.originHospital = originHospital;
	}

	public String getOriginPersonal() {
		return originPersonal;
	}

	public void setOriginPersonal(String originPersonal) {
		this.originPersonal = originPersonal;
	}
}

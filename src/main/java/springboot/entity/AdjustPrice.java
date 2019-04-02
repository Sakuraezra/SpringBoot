package springboot.entity;

/**
 * @ author ezra
 * @ date 2019/4/2 10:32
 */
public class AdjustPrice {
	String IDNumber ;
	String adjustPrice;
	String way;

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String IDNumber) {
		this.IDNumber = IDNumber;
	}

	public String getAdjustPrice() {
		return adjustPrice;
	}

	public void setAdjustPrice(String adjustPrice) {
		this.adjustPrice = adjustPrice;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
}

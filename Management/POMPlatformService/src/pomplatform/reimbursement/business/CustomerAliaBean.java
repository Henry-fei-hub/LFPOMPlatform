package pomplatform.reimbursement.business;

import java.math.BigDecimal;

public class CustomerAliaBean {
	
	private Integer plateId;
	private Integer areaId;
	private BigDecimal amount;
	
	public Integer getPlateId() {
		return plateId;
	}
	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "CustomerAliaBean [plateId=" + plateId + ", areaId=" + areaId + ", amount=" + amount + "]";
	}
	
	
}

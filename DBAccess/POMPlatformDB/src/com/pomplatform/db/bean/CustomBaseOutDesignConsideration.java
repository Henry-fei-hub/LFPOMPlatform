package com.pomplatform.db.bean;


public class CustomBaseOutDesignConsideration extends BaseOutDesignConsideration 
{

	public static CustomBaseOutDesignConsideration newInstance(){
		return new CustomBaseOutDesignConsideration();
	}

	public final static java.lang.String ALL_CAPTIONS = "业务类型,类别,区域(设计范围),设计面积(㎡),设计单价(元),总价(设计面积*单价),备注,内部设计单价(元),内部设计面积总金额";

	public void getDataFromFather(BaseOutDesignConsideration b){
		this.setBusinessType(b.getBusinessType());
		this.setOptionType(b.getOptionType());
		this.setMainDesignAreaName(b.getMainDesignAreaName());
		this.setDesignArea(b.getDesignArea());
		this.setDesignUnitPrice(b.getDesignUnitPrice());
		this.setMoneySum(b.getMoneySum());
		this.setRemark(b.getRemark());
		this.setInteriorPrice(b.getInteriorPrice());
		this.setInteriorMoneySum(b.getInteriorMoneySum());
	}
	
	public java.lang.String toCSVString() {
		StringBuilder sb = new StringBuilder();
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		String strOptionType = delicacy.system.executor.SelectValueCache.getSelectValue("sys_classifications", String.valueOf(getOptionType()));
		sb.append(strOptionType == null ? "" : strOptionType);
		sb.append(",");
		sb.append(getMainDesignAreaName() == null ? "" : getMainDesignAreaName());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getDesignUnitPrice() == null ? "" : getDesignUnitPrice());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getInteriorPrice() == null ? "" : getInteriorPrice());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		return sb.toString();
	}

}

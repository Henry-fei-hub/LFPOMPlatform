package com.pomplatform.db.bean;

public class CustomBaseDesignConsideration extends BaseDesignConsideration 
{


	public final static java.lang.String ALL_CAPTIONS = "业务类型,项目类别,区域(设计范围),设计面积(㎡),拆分价金额,备注";
	
	public void getDataFromFather(BaseDesignConsideration b){
		this.setBusinessType(b.getBusinessType());
		this.setOptionType(b.getOptionType());
		this.setProjectType(b.getProjectType());
		this.setMainDesignAreaName(b.getMainDesignAreaName());
		this.setDecorationStatus(b.getDecorationStatus());
		this.setDesignArea(b.getDesignArea());
		this.setDesignUnitPrice(b.getDesignUnitPrice());
		this.setMoneySum(b.getMoneySum());
		this.setRemark(b.getRemark());
		this.setInteriorPrice(b.getInteriorPrice());
		this.setInteriorMoneySum(b.getInteriorMoneySum());
		this.setSplitPrice(b.getSplitPrice());
	}
	
	public java.lang.String toCSVString() {

		StringBuilder sb = new StringBuilder();
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
//		sb.append(",");
//		String strOptionType = delicacy.system.executor.SelectValueCache.getSelectValue("sys_classifications", String.valueOf(getOptionType()));
//		sb.append(strOptionType == null ? "" : strOptionType);
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getMainDesignAreaName() == null ? "" : getMainDesignAreaName());
		sb.append(",");
//		String strDecorationStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_30", String.valueOf(getDecorationStatus()));
//		sb.append(strDecorationStatus == null ? "" : strDecorationStatus);
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
//		sb.append(",");
//		sb.append(getDesignUnitPrice() == null ? "" : getDesignUnitPrice());
//		sb.append(",");
//		sb.append(getMoneySum() == null ? "" : getMoneySum());

//		sb.append(",");
//		sb.append(getInteriorPrice() == null ? "" : getInteriorPrice());
//		sb.append(",");
//		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		sb.append(",");
		sb.append(getSplitPrice() == null ? "" : getSplitPrice());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}
}

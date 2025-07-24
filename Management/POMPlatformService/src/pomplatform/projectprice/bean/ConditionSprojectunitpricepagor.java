package pomplatform.projectprice.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectunitpricepagor extends GenericCondition {

	public ConditionSprojectunitpricepagor() {
		setParameterCount(5);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId(java.lang.Integer value) {
		this.__area_id = value;
	}

	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId(java.lang.Integer value) {
		this.__grade_id = value;
	}

	public java.lang.Integer getSquareId() {
		return this.__square_id;
	}

	public void setSquareId(java.lang.Integer value) {
		this.__square_id = value;
	}

	public java.math.BigDecimal getSquare() {
		return this.__square;
	}

	public void setSquare(java.math.BigDecimal value) {
		this.__square = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if (getPlateId() != null) {
			sb.append(__wrapNumber(1, "plateId", getPlateId()));
		}
		if (getAreaId() != null) {
			sb.append(__wrapNumber(1, "areaId", getAreaId()));
		}
		if (getGradeId() != null) {
			sb.append(__wrapNumber(1, "gradeId", getGradeId()));
		}
		if (getSquareId() != null) {
			sb.append(__wrapNumber(1, "squareId", getSquareId()));
		}
		if (getSquare() != null) {
			sb.append(__wrapNumber(1, "square", getSquare()));
		}
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		super.setDataFromMap(values);
		Object val;
		if ((val = values.get("plateId")) != null) {
			setPlateId(__getInt(val));
		}
		if ((val = values.get("areaId")) != null) {
			setAreaId(__getInt(val));
		}
		if ((val = values.get("gradeId")) != null) {
			setGradeId(__getInt(val));
		}
		if ((val = values.get("squareId")) != null) {
			setSquareId(__getInt(val));
		}
		if ((val = values.get("square")) != null) {
			setSquare(__getDecimal(val));
		}
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __area_id = null;
	private java.lang.Integer __grade_id = null;
	private java.lang.Integer __square_id = null;
	private java.math.BigDecimal __square = null;
}

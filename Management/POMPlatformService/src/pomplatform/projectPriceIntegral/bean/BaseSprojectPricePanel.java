package pomplatform.projectPriceIntegral.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectPricePanel extends GenericBase implements BaseFactory<BaseSprojectPricePanel>, Comparable<BaseSprojectPricePanel> 
{


	public static BaseSprojectPricePanel newInstance(){
		return new BaseSprojectPricePanel();
	}

	@Override
	public BaseSprojectPricePanel make(){
		BaseSprojectPricePanel b = new BaseSprojectPricePanel();
		return b;
	}

	public final static java.lang.String CS_PROJECT_UNIT_PRICE_ID = "project_unit_price_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_AREA_ID = "area_id" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;
	public final static java.lang.String CS_SQUARE_ID = "square_id" ;
	public final static java.lang.String CS_MIN_SQUARE = "min_square" ;
	public final static java.lang.String CS_MAX_SQUARE = "max_square" ;
	public final static java.lang.String CS_UNIT_PRICE = "unit_price" ;

	public final static java.lang.String ALL_CAPTIONS = "项目单价,板块,区域,项目级别,面积区间,最小面积,最大面积,单价";

	public java.lang.Integer getProjectUnitPriceId() {
		return this.__project_unit_price_id;
	}

	public void setProjectUnitPriceId( java.lang.Integer value ) {
		this.__project_unit_price_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( java.lang.Integer value ) {
		this.__grade_id = value;
	}

	public java.lang.Integer getSquareId() {
		return this.__square_id;
	}

	public void setSquareId( java.lang.Integer value ) {
		this.__square_id = value;
	}

	public java.math.BigDecimal getMinSquare() {
		return this.__min_square;
	}

	public void setMinSquare( java.math.BigDecimal value ) {
		this.__min_square = value;
	}

	public java.math.BigDecimal getMaxSquare() {
		return this.__max_square;
	}

	public void setMaxSquare( java.math.BigDecimal value ) {
		this.__max_square = value;
	}

	public java.math.BigDecimal getUnitPrice() {
		return this.__unit_price;
	}

	public void setUnitPrice( java.math.BigDecimal value ) {
		this.__unit_price = value;
	}

	public void cloneCopy(BaseSprojectPricePanel __bean){
		__bean.setProjectUnitPriceId(getProjectUnitPriceId());
		__bean.setPlateId(getPlateId());
		__bean.setAreaId(getAreaId());
		__bean.setGradeId(getGradeId());
		__bean.setSquareId(getSquareId());
		__bean.setMinSquare(getMinSquare());
		__bean.setMaxSquare(getMaxSquare());
		__bean.setUnitPrice(getUnitPrice());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectUnitPriceId() == null ? "" : getProjectUnitPriceId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getAreaId() == null ? "" : getAreaId());
		sb.append(",");
		sb.append(getGradeId() == null ? "" : getGradeId());
		sb.append(",");
		sb.append(getSquareId() == null ? "" : getSquareId());
		sb.append(",");
		sb.append(getMinSquare() == null ? "" : getMinSquare());
		sb.append(",");
		sb.append(getMaxSquare() == null ? "" : getMaxSquare());
		sb.append(",");
		sb.append(getUnitPrice() == null ? "" : getUnitPrice());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectPricePanel o) {
		return __project_unit_price_id == null ? -1 : __project_unit_price_id.compareTo(o.getProjectUnitPriceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_unit_price_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__area_id);
		hash = 97 * hash + Objects.hashCode(this.__grade_id);
		hash = 97 * hash + Objects.hashCode(this.__square_id);
		hash = 97 * hash + Objects.hashCode(this.__min_square);
		hash = 97 * hash + Objects.hashCode(this.__max_square);
		hash = 97 * hash + Objects.hashCode(this.__unit_price);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectPricePanel o = (BaseSprojectPricePanel)obj;
		if(!Objects.equals(this.__project_unit_price_id, o.getProjectUnitPriceId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__area_id, o.getAreaId())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		if(!Objects.equals(this.__square_id, o.getSquareId())) return false;
		if(!Objects.equals(this.__min_square, o.getMinSquare())) return false;
		if(!Objects.equals(this.__max_square, o.getMaxSquare())) return false;
		if(!Objects.equals(this.__unit_price, o.getUnitPrice())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectUnitPriceId() != null) sb.append(__wrapNumber(count++, "projectUnitPriceId", getProjectUnitPriceId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getAreaId() != null) sb.append(__wrapNumber(count++, "areaId", getAreaId()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		if(getSquareId() != null) sb.append(__wrapNumber(count++, "squareId", getSquareId()));
		if(getMinSquare() != null) sb.append(__wrapDecimal(count++, "minSquare", getMinSquare()));
		if(getMaxSquare() != null) sb.append(__wrapDecimal(count++, "maxSquare", getMaxSquare()));
		if(getUnitPrice() != null) sb.append(__wrapDecimal(count++, "unitPrice", getUnitPrice()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectUnitPriceId")) != null) setProjectUnitPriceId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
		if((val = values.get("squareId")) != null) setSquareId(__getInt(val)); 
		if((val = values.get("minSquare")) != null) setMinSquare(__getDecimal(val));  
		if((val = values.get("maxSquare")) != null) setMaxSquare(__getDecimal(val));  
		if((val = values.get("unitPrice")) != null) setUnitPrice(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_unit_price_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __area_id ;
	protected java.lang.Integer  __grade_id ;
	protected java.lang.Integer  __square_id ;
	protected java.math.BigDecimal  __min_square ;
	protected java.math.BigDecimal  __max_square ;
	protected java.math.BigDecimal  __unit_price ;
}

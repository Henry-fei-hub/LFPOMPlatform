package pomplatform.goodsreceive.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGoodsreceive extends GenericBase implements BaseFactory<BaseGoodsreceive>, Comparable<BaseGoodsreceive> 
{


	public static BaseGoodsreceive newInstance(){
		return new BaseGoodsreceive();
	}

	@Override
	public BaseGoodsreceive make(){
		BaseGoodsreceive b = new BaseGoodsreceive();
		return b;
	}

	public final static java.lang.String CS_GOODS_RECEIVE_ID = "goods_receive_id" ;
	public final static java.lang.String CS_SUBJECT = "subject" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_RECEIVE_DATE = "receive_date" ;
	public final static java.lang.String CS_COUNT = "count" ;
	public final static java.lang.String CS_CREATE_PERSON_ID = "create_person_id" ;
	public final static java.lang.String CS_FILE_MANAGE_ID = "file_manage_id" ;
	public final static java.lang.String CS_GOODS_DETAIL = "goods_detail" ;
	public final static java.lang.String CS_RECEIVE_PERSON_NUMBER = "receive_person_number" ;
	public final static java.lang.String CS_RECEIVE_COUNT = "receive_count" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主题,创建时间,日期,物品数量,创建人编码,文件管理编码,物品详情,领取人数,领取数量";

	public java.lang.Integer getGoodsReceiveId() {
		return this.__goods_receive_id;
	}

	public void setGoodsReceiveId( java.lang.Integer value ) {
		this.__goods_receive_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject;
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getReceiveDate() {
		return this.__receive_date;
	}

	public void setReceiveDate( java.util.Date value ) {
		this.__receive_date = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public java.lang.Integer getCreatePersonId() {
		return this.__create_person_id;
	}

	public void setCreatePersonId( java.lang.Integer value ) {
		this.__create_person_id = value;
	}

	public java.lang.Integer getFileManageId() {
		return this.__file_manage_id;
	}

	public void setFileManageId( java.lang.Integer value ) {
		this.__file_manage_id = value;
	}

	public java.lang.String getGoodsDetail() {
		return this.__goods_detail;
	}

	public void setGoodsDetail( java.lang.String value ) {
		this.__goods_detail = value;
	}

	public java.lang.Long getReceivePersonNumber() {
		return this.__receive_person_number;
	}

	public void setReceivePersonNumber( java.lang.Long value ) {
		this.__receive_person_number = value;
	}

	public java.lang.Long getReceiveCount() {
		return this.__receive_count;
	}

	public void setReceiveCount( java.lang.Long value ) {
		this.__receive_count = value;
	}

	public void cloneCopy(BaseGoodsreceive __bean){
		__bean.setGoodsReceiveId(getGoodsReceiveId());
		__bean.setSubject(getSubject());
		__bean.setCreateTime(getCreateTime());
		__bean.setReceiveDate(getReceiveDate());
		__bean.setCount(getCount());
		__bean.setCreatePersonId(getCreatePersonId());
		__bean.setFileManageId(getFileManageId());
		__bean.setGoodsDetail(getGoodsDetail());
		__bean.setReceivePersonNumber(getReceivePersonNumber());
		__bean.setReceiveCount(getReceiveCount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getGoodsReceiveId() == null ? "" : getGoodsReceiveId());
		sb.append(",");
		sb.append(getSubject() == null ? "" : getSubject());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getReceiveDate() == null ? "" : sdf.format(getReceiveDate()));
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		String strCreatePersonId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getCreatePersonId()));
		sb.append(strCreatePersonId == null ? "" : strCreatePersonId);
		sb.append(",");
		sb.append(getFileManageId() == null ? "" : getFileManageId());
		sb.append(",");
		sb.append(getGoodsDetail() == null ? "" : getGoodsDetail());
		sb.append(",");
		sb.append(getReceivePersonNumber() == null ? "" : getReceivePersonNumber());
		sb.append(",");
		sb.append(getReceiveCount() == null ? "" : getReceiveCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGoodsreceive o) {
		return __goods_receive_id == null ? -1 : __goods_receive_id.compareTo(o.getGoodsReceiveId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__goods_receive_id);
		hash = 97 * hash + Objects.hashCode(this.__subject);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__receive_date);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__create_person_id);
		hash = 97 * hash + Objects.hashCode(this.__file_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__goods_detail);
		hash = 97 * hash + Objects.hashCode(this.__receive_person_number);
		hash = 97 * hash + Objects.hashCode(this.__receive_count);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGoodsreceive o = (BaseGoodsreceive)obj;
		if(!Objects.equals(this.__goods_receive_id, o.getGoodsReceiveId())) return false;
		if(!Objects.equals(this.__subject, o.getSubject())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__receive_date, o.getReceiveDate())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__create_person_id, o.getCreatePersonId())) return false;
		if(!Objects.equals(this.__file_manage_id, o.getFileManageId())) return false;
		if(!Objects.equals(this.__goods_detail, o.getGoodsDetail())) return false;
		if(!Objects.equals(this.__receive_person_number, o.getReceivePersonNumber())) return false;
		if(!Objects.equals(this.__receive_count, o.getReceiveCount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getGoodsReceiveId() != null) sb.append(__wrapNumber(count++, "goodsReceiveId", getGoodsReceiveId()));
		if(getSubject() != null) sb.append(__wrapString(count++, "subject", getSubject()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getReceiveDate() != null) sb.append(__wrapDate(count++, "receiveDate", getReceiveDate()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getCreatePersonId() != null) sb.append(__wrapNumber(count++, "createPersonId", getCreatePersonId()));
		if(getFileManageId() != null) sb.append(__wrapNumber(count++, "fileManageId", getFileManageId()));
		if(getGoodsDetail() != null) sb.append(__wrapString(count++, "goodsDetail", getGoodsDetail()));
		if(getReceivePersonNumber() != null) sb.append(__wrapNumber(count++, "receivePersonNumber", getReceivePersonNumber()));
		if(getReceiveCount() != null) sb.append(__wrapNumber(count++, "receiveCount", getReceiveCount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("goodsReceiveId")) != null) setGoodsReceiveId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("receiveDate")) != null) setReceiveDate(__getDate(val)); 
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("createPersonId")) != null) setCreatePersonId(__getInt(val)); 
		if((val = values.get("fileManageId")) != null) setFileManageId(__getInt(val)); 
		if((val = values.get("goodsDetail")) != null) setGoodsDetail(__getString(val));
		if((val = values.get("receivePersonNumber")) != null) setReceivePersonNumber(__getLong(val)); 
		if((val = values.get("receiveCount")) != null) setReceiveCount(__getLong(val)); 
	}

	protected java.lang.Integer  __goods_receive_id ;
	protected java.lang.String  __subject ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __receive_date ;
	protected java.lang.Integer  __count ;
	protected java.lang.Integer  __create_person_id ;
	protected java.lang.Integer  __file_manage_id ;
	protected java.lang.String  __goods_detail ;
	protected java.lang.Long  __receive_person_number ;
	protected java.lang.Long  __receive_count ;
}

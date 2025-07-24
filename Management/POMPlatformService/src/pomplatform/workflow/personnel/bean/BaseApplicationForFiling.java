package pomplatform.workflow.personnel.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseApplicationForFiling extends GenericBase implements BaseFactory<BaseApplicationForFiling>, Comparable<BaseApplicationForFiling> 
{


	public static BaseApplicationForFiling newInstance(){
		return new BaseApplicationForFiling();
	}

	@Override
	public BaseApplicationForFiling make(){
		BaseApplicationForFiling b = new BaseApplicationForFiling();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_BIRTH = "birth" ;
	public final static String CS_AGE = "age" ;
	public final static String CS_START_WORK_DATE = "start_work_date" ;
	public final static String CS_ONBOARD_DATE = "onboard_date" ;
	public final static String CS_GRADUATED_SCHOOL = "graduated_school" ;
	public final static String CS_SPECIALTY = "specialty" ;
	public final static String CS_CARD_ATTACHMENT = "card_attachment" ;
	public final static String CS_TECHNICAL_ATTACHMENT = "technical_attachment" ;
	public final static String CS_EDUCATION_PROOF = "education_proof" ;

	public final static String ALL_CAPTIONS = "员工工号,员工姓名,出生日期,年龄,参加工作时间,入职日期,毕业院校,所学专业,身份证附件,职称证明附件,学历证附件";

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public java.util.Date getBirth() {
		return this.__birth;
	}

	public void setBirth( java.util.Date value ) {
		this.__birth = value;
	}

	public Integer getAge() {
		return this.__age;
	}

	public void setAge( Integer value ) {
		this.__age = value;
	}

	public java.util.Date getStartWorkDate() {
		return this.__start_work_date;
	}

	public void setStartWorkDate( java.util.Date value ) {
		this.__start_work_date = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public String getGraduatedSchool() {
		return this.__graduated_school;
	}

	public void setGraduatedSchool( String value ) {
		this.__graduated_school = value;
	}

	public String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( String value ) {
		this.__specialty = value;
	}

	public String getCardAttachment() {
		return this.__card_attachment;
	}

	public void setCardAttachment( String value ) {
		this.__card_attachment = value;
	}

	public String getTechnicalAttachment() {
		return this.__technical_attachment;
	}

	public void setTechnicalAttachment( String value ) {
		this.__technical_attachment = value;
	}

	public String getEducationProof() {
		return this.__education_proof;
	}

	public void setEducationProof( String value ) {
		this.__education_proof = value;
	}

	public void cloneCopy(BaseApplicationForFiling __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setBirth(getBirth());
		__bean.setAge(getAge());
		__bean.setStartWorkDate(getStartWorkDate());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setGraduatedSchool(getGraduatedSchool());
		__bean.setSpecialty(getSpecialty());
		__bean.setCardAttachment(getCardAttachment());
		__bean.setTechnicalAttachment(getTechnicalAttachment());
		__bean.setEducationProof(getEducationProof());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getBirth() == null ? "" : sdf.format(getBirth()));
		sb.append(",");
		sb.append(getAge() == null ? "" : getAge());
		sb.append(",");
		sb.append(getStartWorkDate() == null ? "" : sdf.format(getStartWorkDate()));
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getGraduatedSchool() == null ? "" : getGraduatedSchool());
		sb.append(",");
		sb.append(getSpecialty() == null ? "" : getSpecialty());
		sb.append(",");
		sb.append(getCardAttachment() == null ? "" : getCardAttachment());
		sb.append(",");
		sb.append(getTechnicalAttachment() == null ? "" : getTechnicalAttachment());
		sb.append(",");
		sb.append(getEducationProof() == null ? "" : getEducationProof());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseApplicationForFiling o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__birth);
		hash = 97 * hash + Objects.hashCode(this.__age);
		hash = 97 * hash + Objects.hashCode(this.__start_work_date);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__graduated_school);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__card_attachment);
		hash = 97 * hash + Objects.hashCode(this.__technical_attachment);
		hash = 97 * hash + Objects.hashCode(this.__education_proof);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseApplicationForFiling o = (BaseApplicationForFiling)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__birth, o.getBirth())) return false;
		if(!Objects.equals(this.__age, o.getAge())) return false;
		if(!Objects.equals(this.__start_work_date, o.getStartWorkDate())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__graduated_school, o.getGraduatedSchool())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__card_attachment, o.getCardAttachment())) return false;
		if(!Objects.equals(this.__technical_attachment, o.getTechnicalAttachment())) return false;
		if(!Objects.equals(this.__education_proof, o.getEducationProof())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getBirth() != null) sb.append(__wrapDate(count++, "birth", getBirth()));
		if(getAge() != null) sb.append(__wrapNumber(count++, "age", getAge()));
		if(getStartWorkDate() != null) sb.append(__wrapDate(count++, "startWorkDate", getStartWorkDate()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getGraduatedSchool() != null) sb.append(__wrapString(count++, "graduatedSchool", getGraduatedSchool()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getCardAttachment() != null) sb.append(__wrapString(count++, "cardAttachment", getCardAttachment()));
		if(getTechnicalAttachment() != null) sb.append(__wrapString(count++, "technicalAttachment", getTechnicalAttachment()));
		if(getEducationProof() != null) sb.append(__wrapString(count++, "educationProof", getEducationProof()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getBirth() != null) res.put("birth", getBirth());
		if(getAge() != null) res.put("age", getAge());
		if(getStartWorkDate() != null) res.put("startWorkDate", getStartWorkDate());
		if(getOnboardDate() != null) res.put("onboardDate", getOnboardDate());
		if(getGraduatedSchool() != null) res.put("graduatedSchool", getGraduatedSchool());
		if(getSpecialty() != null) res.put("specialty", getSpecialty());
		if(getCardAttachment() != null) res.put("cardAttachment", getCardAttachment());
		if(getTechnicalAttachment() != null) res.put("technicalAttachment", getTechnicalAttachment());
		if(getEducationProof() != null) res.put("educationProof", getEducationProof());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("birth")) != null) setBirth(__getDate(val)); 
		if((val = values.get("age")) != null) setAge(__getInt(val)); 
		if((val = values.get("startWorkDate")) != null) setStartWorkDate(__getDate(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("graduatedSchool")) != null) setGraduatedSchool(__getString(val));
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("cardAttachment")) != null) setCardAttachment(__getString(val));
		if((val = values.get("technicalAttachment")) != null) setTechnicalAttachment(__getString(val));
		if((val = values.get("educationProof")) != null) setEducationProof(__getString(val));
	}

	protected Integer  __employee_id ;
	protected String  __employee_name ;
	protected java.util.Date  __birth ;
	protected Integer  __age ;
	protected java.util.Date  __start_work_date ;
	protected java.util.Date  __onboard_date ;
	protected String  __graduated_school ;
	protected String  __specialty ;
	protected String  __card_attachment ;
	protected String  __technical_attachment ;
	protected String  __education_proof ;
}

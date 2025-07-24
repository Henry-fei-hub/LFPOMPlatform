package pomplatform.workflow.personnelbusiness.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.dao.EmployeeWithEeeee;
import com.pomplatform.db.dao.EmployeeEducationInformation;
import com.pomplatform.db.dao.EmployeeFamilyInformation;
import com.pomplatform.db.dao.EmployeeRewardExperience;
import com.pomplatform.db.dao.EmployeeWorkExperience;
import com.pomplatform.db.dao.EmployeeTechnicalTitle;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class EmployeeWithEeeeeHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(EmployeeWithEeeeeHandler.class);

	public static BaseEmployeeWithEeeee getEmployeeWithEeeeeById( java.lang.Integer employee_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseEmployeeWithEeeee result;
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			dao.setEmployeeId(employee_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get EmployeeWithEeeee By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isEmployeeWithEeeeeExists( pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query EmployeeWithEeeee List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countEmployeeWithEeeee( pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query EmployeeWithEeeee List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseEmployeeWithEeeee> queryEmployeeWithEeeee( BaseEmployeeWithEeeee bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseEmployeeWithEeeee> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseEmployeeWithEeeee> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query EmployeeWithEeeee List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithEeeee addToEmployeeWithEeeee ( BaseEmployeeWithEeeee employeewitheeeee ) {
		return addToEmployeeWithEeeee ( employeewitheeeee , false);
	}

	public static BaseEmployeeWithEeeee addToEmployeeWithEeeee ( BaseEmployeeWithEeeee employeewitheeeee, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			dao.setDataFromBase(employeewitheeeee);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to EmployeeWithEeeee time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithEeeee addUpdateEmployeeWithEeeee ( BaseEmployeeWithEeeee employeewitheeeee ) {
		return addUpdateEmployeeWithEeeee ( employeewitheeeee , false);
	}

	public static BaseEmployeeWithEeeee addUpdateEmployeeWithEeeee ( BaseEmployeeWithEeeee employeewitheeeee, boolean singleTransaction  ) {
		if(employeewitheeeee.getEmployeeId() == null) return addToEmployeeWithEeeee(employeewitheeeee);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			dao.setDataFromBase(employeewitheeeee);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(employeewitheeeee); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to EmployeeWithEeeee time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithEeeee deleteEmployeeWithEeeee ( BaseEmployeeWithEeeee bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete EmployeeWithEeeee time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithEeeee updateEmployeeWithEeeee ( BaseEmployeeWithEeeee employeewitheeeee ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			dao.setEmployeeId( employeewitheeeee.getEmployeeId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(employeewitheeeee);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update EmployeeWithEeeee time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? employeewitheeeee : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseEmployeeWithEeeee updateEmployeeWithEeeeeDirect( BaseEmployeeWithEeeee employeewitheeeee ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			int result = 0;
			dao.setDataFromBase(employeewitheeeee);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update EmployeeWithEeeee time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? employeewitheeeee : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseEmployeeWithEeeee bean, EmployeeWithEeeee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeId() != null) {
			dao.setEmployeeId(bean.getEmployeeId());
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getRoleId() != null) {
				dao.setConditionRoleId("=", bean.getRoleId());
				count++;
			}
			if(bean.getGradeId() != null) {
				dao.setConditionGradeId("=", bean.getGradeId());
				count++;
			}
			if(bean.getEmployeePassword() != null) {
				dao.setConditionEmployeePassword("=", bean.getEmployeePassword());
				count++;
			}
			if(bean.getMobile() != null) {
				dao.setConditionMobile("=", bean.getMobile());
				count++;
			}
			if(bean.getPhone() != null) {
				dao.setConditionPhone("=", bean.getPhone());
				count++;
			}
			if(bean.getQq() != null) {
				dao.setConditionQq("=", bean.getQq());
				count++;
			}
			if(bean.getEmail() != null) {
				dao.setConditionEmail("=", bean.getEmail());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getUsableStatus() != null) {
				dao.setConditionUsableStatus("=", bean.getUsableStatus());
				count++;
			}
			if(bean.getIsDepartment() != null) {
				dao.setConditionIsDepartment("=", bean.getIsDepartment());
				count++;
			}
			if(bean.getPhoto() != null) {
				dao.setConditionPhoto("=", bean.getPhoto());
				count++;
			}
			if(bean.getGender() != null) {
				dao.setConditionGender("=", bean.getGender());
				count++;
			}
			if(bean.getAutograph() != null) {
				dao.setConditionAutograph("=", bean.getAutograph());
				count++;
			}
			if(bean.getAge() != null) {
				dao.setConditionAge("=", bean.getAge());
				count++;
			}
			if(bean.getCard() != null) {
				dao.setConditionCard("=", bean.getCard());
				count++;
			}
			if(bean.getAddress() != null) {
				dao.setConditionAddress("=", bean.getAddress());
				count++;
			}
			if(bean.getAlternateField1() != null) {
				dao.setConditionAlternateField1("=", bean.getAlternateField1());
				count++;
			}
			if(bean.getAlternateField2() != null) {
				dao.setConditionAlternateField2("=", bean.getAlternateField2());
				count++;
			}
			if(bean.getAlternateField3() != null) {
				dao.setConditionAlternateField3("=", bean.getAlternateField3());
				count++;
			}
			if(bean.getLocked() != null) {
				dao.setConditionLocked("=", bean.getLocked());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDutyId() != null) {
				dao.setConditionDutyId("=", bean.getDutyId());
				count++;
			}
			if(bean.getUserAcct() != null) {
				dao.setConditionUserAcct("=", bean.getUserAcct());
				count++;
			}
			if(bean.getEmployeeNameEn() != null) {
				dao.setConditionEmployeeNameEn("=", bean.getEmployeeNameEn());
				count++;
			}
			if(bean.getEducation() != null) {
				dao.setConditionEducation("=", bean.getEducation());
				count++;
			}
			if(bean.getDegree() != null) {
				dao.setConditionDegree("=", bean.getDegree());
				count++;
			}
			if(bean.getNationality() != null) {
				dao.setConditionNationality("=", bean.getNationality());
				count++;
			}
			if(bean.getMarriedStatus() != null) {
				dao.setConditionMarriedStatus("=", bean.getMarriedStatus());
				count++;
			}
			if(bean.getHealth() != null) {
				dao.setConditionHealth("=", bean.getHealth());
				count++;
			}
			if(bean.getWorkAddress() != null) {
				dao.setConditionWorkAddress("=", bean.getWorkAddress());
				count++;
			}
			if(bean.getRegisteredAddress() != null) {
				dao.setConditionRegisteredAddress("=", bean.getRegisteredAddress());
				count++;
			}
			if(bean.getOaId() != null) {
				dao.setConditionOaId("=", bean.getOaId());
				count++;
			}
			if(bean.getOaDepart() != null) {
				dao.setConditionOaDepart("=", bean.getOaDepart());
				count++;
			}
			if(bean.getIsHeadcount() != null) {
				dao.setConditionIsHeadcount("=", bean.getIsHeadcount());
				count++;
			}
			if(bean.getIsCheck() != null) {
				dao.setConditionIsCheck("=", bean.getIsCheck());
				count++;
			}
			if(bean.getDirectLeader() != null) {
				dao.setConditionDirectLeader("=", bean.getDirectLeader());
				count++;
			}
			if(bean.getIsManager() != null) {
				dao.setConditionIsManager("=", bean.getIsManager());
				count++;
			}
			if(bean.getPoliticalFace() != null) {
				dao.setConditionPoliticalFace("=", bean.getPoliticalFace());
				count++;
			}
			if(bean.getBirthplace() != null) {
				dao.setConditionBirthplace("=", bean.getBirthplace());
				count++;
			}
			if(bean.getCountry() != null) {
				dao.setConditionCountry("=", bean.getCountry());
				count++;
			}
			if(bean.getAccountLocation() != null) {
				dao.setConditionAccountLocation("=", bean.getAccountLocation());
				count++;
			}
			if(bean.getLanguages() != null) {
				dao.setConditionLanguages("=", bean.getLanguages());
				count++;
			}
			if(bean.getSocialComputerNumber() != null) {
				dao.setConditionSocialComputerNumber("=", bean.getSocialComputerNumber());
				count++;
			}
			if(bean.getFundAccount() != null) {
				dao.setConditionFundAccount("=", bean.getFundAccount());
				count++;
			}
			if(bean.getTryTime() != null) {
				dao.setConditionTryTime("=", bean.getTryTime());
				count++;
			}
			if(bean.getOwnedCompany() != null) {
				dao.setConditionOwnedCompany("=", bean.getOwnedCompany());
				count++;
			}
			if(bean.getJobs() != null) {
				dao.setConditionJobs("=", bean.getJobs());
				count++;
			}
			if(bean.getPersonalBusinessRemark() != null) {
				dao.setConditionPersonalBusinessRemark("=", bean.getPersonalBusinessRemark());
				count++;
			}
			if(bean.getSelfIntroduction() != null) {
				dao.setConditionSelfIntroduction("=", bean.getSelfIntroduction());
				count++;
			}
			if(bean.getLaborAttachments() != null) {
				dao.setConditionLaborAttachments("=", bean.getLaborAttachments());
				count++;
			}
			if(bean.getEmergencyContactPerson() != null) {
				dao.setConditionEmergencyContactPerson("=", bean.getEmergencyContactPerson());
				count++;
			}
			if(bean.getEmergencyContactPhone() != null) {
				dao.setConditionEmergencyContactPhone("=", bean.getEmergencyContactPhone());
				count++;
			}
			if(bean.getHomePhone() != null) {
				dao.setConditionHomePhone("=", bean.getHomePhone());
				count++;
			}
			if(bean.getNowAddress() != null) {
				dao.setConditionNowAddress("=", bean.getNowAddress());
				count++;
			}
			if(bean.getTryTimePay() != null) {
				dao.setConditionTryTimePay("=", bean.getTryTimePay());
				count++;
			}
			if(bean.getPositivePay() != null) {
				dao.setConditionPositivePay("=", bean.getPositivePay());
				count++;
			}
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
				count++;
			}
			if(bean.getBankCardNum() != null) {
				dao.setConditionBankCardNum("=", bean.getBankCardNum());
				count++;
			}
			if(bean.getFileNumber() != null) {
				dao.setConditionFileNumber("=", bean.getFileNumber());
				count++;
			}
			if(bean.getHouseholdRegistration() != null) {
				dao.setConditionHouseholdRegistration("=", bean.getHouseholdRegistration());
				count++;
			}
			if(bean.getForeman() != null) {
				dao.setConditionForeman("=", bean.getForeman());
				count++;
			}
			if(bean.getCardAttachment() != null) {
				dao.setConditionCardAttachment("=", bean.getCardAttachment());
				count++;
			}
			if(bean.getTechnicalAttachment() != null) {
				dao.setConditionTechnicalAttachment("=", bean.getTechnicalAttachment());
				count++;
			}
			if(bean.getEducationProof() != null) {
				dao.setConditionEducationProof("=", bean.getEducationProof());
				count++;
			}
			if(bean.getDegreeProof() != null) {
				dao.setConditionDegreeProof("=", bean.getDegreeProof());
				count++;
			}
			if(bean.getEmployeeShift() != null) {
				dao.setConditionEmployeeShift("=", bean.getEmployeeShift());
				count++;
			}
			if(bean.getCardAddress() != null) {
				dao.setConditionCardAddress("=", bean.getCardAddress());
				count++;
			}
			if(bean.getAnnualPerformance() != null) {
				dao.setConditionAnnualPerformance("=", bean.getAnnualPerformance());
				count++;
			}
			if(bean.getAnnualBonus() != null) {
				dao.setConditionAnnualBonus("=", bean.getAnnualBonus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeWithEeeee bean, EmployeeWithEeeee dao){
		int count = 0;
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getRoleId() != null) {
			dao.setConditionRoleId("=", bean.getRoleId());
			count++;
		}
		if(bean.getGradeId() != null) {
			dao.setConditionGradeId("=", bean.getGradeId());
			count++;
		}
		if(bean.getEmployeePassword() != null) {
			if(bean.getEmployeePassword().indexOf("%") >= 0)
				dao.setConditionEmployeePassword("like", bean.getEmployeePassword());
			else
				dao.setConditionEmployeePassword("=", bean.getEmployeePassword());
			count++;
		}
		if(bean.getMobile() != null) {
			if(bean.getMobile().indexOf("%") >= 0)
				dao.setConditionMobile("like", bean.getMobile());
			else
				dao.setConditionMobile("=", bean.getMobile());
			count++;
		}
		if(bean.getPhone() != null) {
			if(bean.getPhone().indexOf("%") >= 0)
				dao.setConditionPhone("like", bean.getPhone());
			else
				dao.setConditionPhone("=", bean.getPhone());
			count++;
		}
		if(bean.getQq() != null) {
			if(bean.getQq().indexOf("%") >= 0)
				dao.setConditionQq("like", bean.getQq());
			else
				dao.setConditionQq("=", bean.getQq());
			count++;
		}
		if(bean.getEmail() != null) {
			if(bean.getEmail().indexOf("%") >= 0)
				dao.setConditionEmail("like", bean.getEmail());
			else
				dao.setConditionEmail("=", bean.getEmail());
			count++;
		}
		if(bean.getOnboardDate() != null) {
			dao.setConditionOnboardDate(">=", bean.getOnboardDate());
			count++;
		}
		if(bean.getResignationDate() != null) {
			dao.setConditionResignationDate(">=", bean.getResignationDate());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getUsableStatus() != null) {
			dao.setConditionUsableStatus("=", bean.getUsableStatus());
			count++;
		}
		if(bean.getIsDepartment() != null) {
			dao.setConditionIsDepartment("=", bean.getIsDepartment());
			count++;
		}
		if(bean.getPhoto() != null) {
			if(bean.getPhoto().indexOf("%") >= 0)
				dao.setConditionPhoto("like", bean.getPhoto());
			else
				dao.setConditionPhoto("=", bean.getPhoto());
			count++;
		}
		if(bean.getGender() != null) {
			dao.setConditionGender("=", bean.getGender());
			count++;
		}
		if(bean.getAutograph() != null) {
			if(bean.getAutograph().indexOf("%") >= 0)
				dao.setConditionAutograph("like", bean.getAutograph());
			else
				dao.setConditionAutograph("=", bean.getAutograph());
			count++;
		}
		if(bean.getAge() != null) {
			dao.setConditionAge("=", bean.getAge());
			count++;
		}
		if(bean.getBirth() != null) {
			dao.setConditionBirth(">=", bean.getBirth());
			count++;
		}
		if(bean.getCard() != null) {
			if(bean.getCard().indexOf("%") >= 0)
				dao.setConditionCard("like", bean.getCard());
			else
				dao.setConditionCard("=", bean.getCard());
			count++;
		}
		if(bean.getAddress() != null) {
			if(bean.getAddress().indexOf("%") >= 0)
				dao.setConditionAddress("like", bean.getAddress());
			else
				dao.setConditionAddress("=", bean.getAddress());
			count++;
		}
		if(bean.getAlternateField1() != null) {
			if(bean.getAlternateField1().indexOf("%") >= 0)
				dao.setConditionAlternateField1("like", bean.getAlternateField1());
			else
				dao.setConditionAlternateField1("=", bean.getAlternateField1());
			count++;
		}
		if(bean.getAlternateField2() != null) {
			if(bean.getAlternateField2().indexOf("%") >= 0)
				dao.setConditionAlternateField2("like", bean.getAlternateField2());
			else
				dao.setConditionAlternateField2("=", bean.getAlternateField2());
			count++;
		}
		if(bean.getAlternateField3() != null) {
			if(bean.getAlternateField3().indexOf("%") >= 0)
				dao.setConditionAlternateField3("like", bean.getAlternateField3());
			else
				dao.setConditionAlternateField3("=", bean.getAlternateField3());
			count++;
		}
		if(bean.getLocked() != null) {
			dao.setConditionLocked("=", bean.getLocked());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDutyId() != null) {
			dao.setConditionDutyId("=", bean.getDutyId());
			count++;
		}
		if(bean.getUserAcct() != null) {
			if(bean.getUserAcct().indexOf("%") >= 0)
				dao.setConditionUserAcct("like", bean.getUserAcct());
			else
				dao.setConditionUserAcct("=", bean.getUserAcct());
			count++;
		}
		if(bean.getEmployeeNameEn() != null) {
			if(bean.getEmployeeNameEn().indexOf("%") >= 0)
				dao.setConditionEmployeeNameEn("like", bean.getEmployeeNameEn());
			else
				dao.setConditionEmployeeNameEn("=", bean.getEmployeeNameEn());
			count++;
		}
		if(bean.getEducation() != null) {
			if(bean.getEducation().indexOf("%") >= 0)
				dao.setConditionEducation("like", bean.getEducation());
			else
				dao.setConditionEducation("=", bean.getEducation());
			count++;
		}
		if(bean.getDegree() != null) {
			if(bean.getDegree().indexOf("%") >= 0)
				dao.setConditionDegree("like", bean.getDegree());
			else
				dao.setConditionDegree("=", bean.getDegree());
			count++;
		}
		if(bean.getNationality() != null) {
			if(bean.getNationality().indexOf("%") >= 0)
				dao.setConditionNationality("like", bean.getNationality());
			else
				dao.setConditionNationality("=", bean.getNationality());
			count++;
		}
		if(bean.getMarriedStatus() != null) {
			if(bean.getMarriedStatus().indexOf("%") >= 0)
				dao.setConditionMarriedStatus("like", bean.getMarriedStatus());
			else
				dao.setConditionMarriedStatus("=", bean.getMarriedStatus());
			count++;
		}
		if(bean.getHealth() != null) {
			if(bean.getHealth().indexOf("%") >= 0)
				dao.setConditionHealth("like", bean.getHealth());
			else
				dao.setConditionHealth("=", bean.getHealth());
			count++;
		}
		if(bean.getWorkAddress() != null) {
			if(bean.getWorkAddress().indexOf("%") >= 0)
				dao.setConditionWorkAddress("like", bean.getWorkAddress());
			else
				dao.setConditionWorkAddress("=", bean.getWorkAddress());
			count++;
		}
		if(bean.getRegisteredAddress() != null) {
			if(bean.getRegisteredAddress().indexOf("%") >= 0)
				dao.setConditionRegisteredAddress("like", bean.getRegisteredAddress());
			else
				dao.setConditionRegisteredAddress("=", bean.getRegisteredAddress());
			count++;
		}
		if(bean.getOaId() != null) {
			dao.setConditionOaId("=", bean.getOaId());
			count++;
		}
		if(bean.getOaDepart() != null) {
			dao.setConditionOaDepart("=", bean.getOaDepart());
			count++;
		}
		if(bean.getIsHeadcount() != null) {
			dao.setConditionIsHeadcount("=", bean.getIsHeadcount());
			count++;
		}
		if(bean.getIsCheck() != null) {
			dao.setConditionIsCheck("=", bean.getIsCheck());
			count++;
		}
		if(bean.getDirectLeader() != null) {
			dao.setConditionDirectLeader("=", bean.getDirectLeader());
			count++;
		}
		if(bean.getIsManager() != null) {
			dao.setConditionIsManager("=", bean.getIsManager());
			count++;
		}
		if(bean.getPoliticalFace() != null) {
			dao.setConditionPoliticalFace("=", bean.getPoliticalFace());
			count++;
		}
		if(bean.getBirthplace() != null) {
			if(bean.getBirthplace().indexOf("%") >= 0)
				dao.setConditionBirthplace("like", bean.getBirthplace());
			else
				dao.setConditionBirthplace("=", bean.getBirthplace());
			count++;
		}
		if(bean.getCountry() != null) {
			if(bean.getCountry().indexOf("%") >= 0)
				dao.setConditionCountry("like", bean.getCountry());
			else
				dao.setConditionCountry("=", bean.getCountry());
			count++;
		}
		if(bean.getAccountLocation() != null) {
			if(bean.getAccountLocation().indexOf("%") >= 0)
				dao.setConditionAccountLocation("like", bean.getAccountLocation());
			else
				dao.setConditionAccountLocation("=", bean.getAccountLocation());
			count++;
		}
		if(bean.getLanguages() != null) {
			if(bean.getLanguages().indexOf("%") >= 0)
				dao.setConditionLanguages("like", bean.getLanguages());
			else
				dao.setConditionLanguages("=", bean.getLanguages());
			count++;
		}
		if(bean.getStartWorkDate() != null) {
			dao.setConditionStartWorkDate(">=", bean.getStartWorkDate());
			count++;
		}
		if(bean.getSocialComputerNumber() != null) {
			if(bean.getSocialComputerNumber().indexOf("%") >= 0)
				dao.setConditionSocialComputerNumber("like", bean.getSocialComputerNumber());
			else
				dao.setConditionSocialComputerNumber("=", bean.getSocialComputerNumber());
			count++;
		}
		if(bean.getFundAccount() != null) {
			if(bean.getFundAccount().indexOf("%") >= 0)
				dao.setConditionFundAccount("like", bean.getFundAccount());
			else
				dao.setConditionFundAccount("=", bean.getFundAccount());
			count++;
		}
		if(bean.getPositiveDate() != null) {
			dao.setConditionPositiveDate(">=", bean.getPositiveDate());
			count++;
		}
		if(bean.getTryTime() != null) {
			if(bean.getTryTime().indexOf("%") >= 0)
				dao.setConditionTryTime("like", bean.getTryTime());
			else
				dao.setConditionTryTime("=", bean.getTryTime());
			count++;
		}
		if(bean.getContractStartDate() != null) {
			dao.setConditionContractStartDate(">=", bean.getContractStartDate());
			count++;
		}
		if(bean.getContractEndDate() != null) {
			dao.setConditionContractEndDate(">=", bean.getContractEndDate());
			count++;
		}
		if(bean.getOwnedCompany() != null) {
			if(bean.getOwnedCompany().indexOf("%") >= 0)
				dao.setConditionOwnedCompany("like", bean.getOwnedCompany());
			else
				dao.setConditionOwnedCompany("=", bean.getOwnedCompany());
			count++;
		}
		if(bean.getJobs() != null) {
			if(bean.getJobs().indexOf("%") >= 0)
				dao.setConditionJobs("like", bean.getJobs());
			else
				dao.setConditionJobs("=", bean.getJobs());
			count++;
		}
		if(bean.getPersonalBusinessRemark() != null) {
			if(bean.getPersonalBusinessRemark().indexOf("%") >= 0)
				dao.setConditionPersonalBusinessRemark("like", bean.getPersonalBusinessRemark());
			else
				dao.setConditionPersonalBusinessRemark("=", bean.getPersonalBusinessRemark());
			count++;
		}
		if(bean.getSelfIntroduction() != null) {
			if(bean.getSelfIntroduction().indexOf("%") >= 0)
				dao.setConditionSelfIntroduction("like", bean.getSelfIntroduction());
			else
				dao.setConditionSelfIntroduction("=", bean.getSelfIntroduction());
			count++;
		}
		if(bean.getLaborAttachments() != null) {
			if(bean.getLaborAttachments().indexOf("%") >= 0)
				dao.setConditionLaborAttachments("like", bean.getLaborAttachments());
			else
				dao.setConditionLaborAttachments("=", bean.getLaborAttachments());
			count++;
		}
		if(bean.getEmergencyContactPerson() != null) {
			if(bean.getEmergencyContactPerson().indexOf("%") >= 0)
				dao.setConditionEmergencyContactPerson("like", bean.getEmergencyContactPerson());
			else
				dao.setConditionEmergencyContactPerson("=", bean.getEmergencyContactPerson());
			count++;
		}
		if(bean.getEmergencyContactPhone() != null) {
			if(bean.getEmergencyContactPhone().indexOf("%") >= 0)
				dao.setConditionEmergencyContactPhone("like", bean.getEmergencyContactPhone());
			else
				dao.setConditionEmergencyContactPhone("=", bean.getEmergencyContactPhone());
			count++;
		}
		if(bean.getHomePhone() != null) {
			if(bean.getHomePhone().indexOf("%") >= 0)
				dao.setConditionHomePhone("like", bean.getHomePhone());
			else
				dao.setConditionHomePhone("=", bean.getHomePhone());
			count++;
		}
		if(bean.getNowAddress() != null) {
			if(bean.getNowAddress().indexOf("%") >= 0)
				dao.setConditionNowAddress("like", bean.getNowAddress());
			else
				dao.setConditionNowAddress("=", bean.getNowAddress());
			count++;
		}
		if(bean.getTryTimePay() != null) {
			if(bean.getTryTimePay().indexOf("%") >= 0)
				dao.setConditionTryTimePay("like", bean.getTryTimePay());
			else
				dao.setConditionTryTimePay("=", bean.getTryTimePay());
			count++;
		}
		if(bean.getPositivePay() != null) {
			if(bean.getPositivePay().indexOf("%") >= 0)
				dao.setConditionPositivePay("like", bean.getPositivePay());
			else
				dao.setConditionPositivePay("=", bean.getPositivePay());
			count++;
		}
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
			count++;
		}
		if(bean.getBankCardNum() != null) {
			if(bean.getBankCardNum().indexOf("%") >= 0)
				dao.setConditionBankCardNum("like", bean.getBankCardNum());
			else
				dao.setConditionBankCardNum("=", bean.getBankCardNum());
			count++;
		}
		if(bean.getFileNumber() != null) {
			if(bean.getFileNumber().indexOf("%") >= 0)
				dao.setConditionFileNumber("like", bean.getFileNumber());
			else
				dao.setConditionFileNumber("=", bean.getFileNumber());
			count++;
		}
		if(bean.getHouseholdRegistration() != null) {
			dao.setConditionHouseholdRegistration("=", bean.getHouseholdRegistration());
			count++;
		}
		if(bean.getForeman() != null) {
			if(bean.getForeman().indexOf("%") >= 0)
				dao.setConditionForeman("like", bean.getForeman());
			else
				dao.setConditionForeman("=", bean.getForeman());
			count++;
		}
		if(bean.getCardAttachment() != null) {
			if(bean.getCardAttachment().indexOf("%") >= 0)
				dao.setConditionCardAttachment("like", bean.getCardAttachment());
			else
				dao.setConditionCardAttachment("=", bean.getCardAttachment());
			count++;
		}
		if(bean.getTechnicalAttachment() != null) {
			if(bean.getTechnicalAttachment().indexOf("%") >= 0)
				dao.setConditionTechnicalAttachment("like", bean.getTechnicalAttachment());
			else
				dao.setConditionTechnicalAttachment("=", bean.getTechnicalAttachment());
			count++;
		}
		if(bean.getEducationProof() != null) {
			if(bean.getEducationProof().indexOf("%") >= 0)
				dao.setConditionEducationProof("like", bean.getEducationProof());
			else
				dao.setConditionEducationProof("=", bean.getEducationProof());
			count++;
		}
		if(bean.getDegreeProof() != null) {
			if(bean.getDegreeProof().indexOf("%") >= 0)
				dao.setConditionDegreeProof("like", bean.getDegreeProof());
			else
				dao.setConditionDegreeProof("=", bean.getDegreeProof());
			count++;
		}
		if(bean.getEmployeeShift() != null) {
			dao.setConditionEmployeeShift("=", bean.getEmployeeShift());
			count++;
		}
		if(bean.getCardAddress() != null) {
			if(bean.getCardAddress().indexOf("%") >= 0)
				dao.setConditionCardAddress("like", bean.getCardAddress());
			else
				dao.setConditionCardAddress("=", bean.getCardAddress());
			count++;
		}
		if(bean.getAnnualPerformance() != null) {
			if(bean.getAnnualPerformance().indexOf("%") >= 0)
				dao.setConditionAnnualPerformance("like", bean.getAnnualPerformance());
			else
				dao.setConditionAnnualPerformance("=", bean.getAnnualPerformance());
			count++;
		}
		if(bean.getAnnualBonus() != null) {
			if(bean.getAnnualBonus().indexOf("%") >= 0)
				dao.setConditionAnnualBonus("like", bean.getAnnualBonus());
			else
				dao.setConditionAnnualBonus("=", bean.getAnnualBonus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
		bean.setDataFromJSON(json);
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeWithEeeee> rlist = new BaseCollection<>();
		BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeWithEeeee> result = dao.conditionalLoadExt(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
		bean.setDataFromJSON(json);
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
		bean.setDataFromJSON(json);
		int num = 0;
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
		bean.setDataFromJSON(json);
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
		bean.setDataFromJSON(json);
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}



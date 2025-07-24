package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PersonnelBusinesHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PersonnelBusinesHandler.class);

	public static BasePersonnelBusines getPersonnelBusinesById( 
		java.lang.Integer personnel_business_id
	) throws Exception
	{
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(personnel_business_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPersonnelBusinesExists( com.pomplatform.db.bean.BasePersonnelBusines bean, String additional ) throws Exception {

		PersonnelBusines dao = new PersonnelBusines();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPersonnelBusines( com.pomplatform.db.bean.BasePersonnelBusines bean, String additional ) throws Exception {

		PersonnelBusines dao = new PersonnelBusines();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePersonnelBusines> queryPersonnelBusines( com.pomplatform.db.bean.BasePersonnelBusines bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePersonnelBusines> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePersonnelBusines> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePersonnelBusines addToPersonnelBusines ( BasePersonnelBusines personnelbusines )  throws Exception {
		return addToPersonnelBusines ( personnelbusines , false);
	}

	public static BasePersonnelBusines addToPersonnelBusines ( BasePersonnelBusines personnelbusines, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(personnelbusines);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePersonnelBusines addUpdatePersonnelBusines ( BasePersonnelBusines personnelbusines ) throws Exception {
		return addUpdatePersonnelBusines ( personnelbusines , false);
	}

	public static BasePersonnelBusines addUpdatePersonnelBusines ( BasePersonnelBusines personnelbusines, boolean singleTransaction  ) throws Exception {
		if(personnelbusines.getPersonnelBusinessId() == null) return addToPersonnelBusines(personnelbusines);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(personnelbusines);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(personnelbusines); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePersonnelBusines ( BasePersonnelBusines bean ) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePersonnelBusines updatePersonnelBusines ( BasePersonnelBusines personnelbusines ) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId( personnelbusines.getPersonnelBusinessId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(personnelbusines);
			result = dao.update();
		}
		return result == 1 ? personnelbusines : null ;
	}

	public static BasePersonnelBusines updatePersonnelBusinesDirect( BasePersonnelBusines personnelbusines ) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		int result = 0;
		dao.setDataFromBase(personnelbusines);
		result = dao.update();
		return result == 1 ? personnelbusines : null ;
	}

	public static int setDeleteConditions(BasePersonnelBusines bean, PersonnelBusines dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getStartDateDetail() != null) {
				dao.setConditionStartDateDetail("=", bean.getStartDateDetail());
				count++;
			}
			if(bean.getEndDateDetail() != null) {
				dao.setConditionEndDateDetail("=", bean.getEndDateDetail());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getAddress() != null) {
				dao.setConditionAddress("=", bean.getAddress());
				count++;
			}
			if(bean.getPlan() != null) {
				dao.setConditionPlan("=", bean.getPlan());
				count++;
			}
			if(bean.getTransportation() != null) {
				dao.setConditionTransportation("=", bean.getTransportation());
				count++;
			}
			if(bean.getUnit() != null) {
				dao.setConditionUnit("=", bean.getUnit());
				count++;
			}
			if(bean.getContactPerson() != null) {
				dao.setConditionContactPerson("=", bean.getContactPerson());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getNextAuditor() != null) {
				dao.setConditionNextAuditor("=", bean.getNextAuditor());
				count++;
			}
			if(bean.getSubType() != null) {
				dao.setConditionSubType("=", bean.getSubType());
				count++;
			}
			if(bean.getCompanyProvince() != null) {
				dao.setConditionCompanyProvince("=", bean.getCompanyProvince());
				count++;
			}
			if(bean.getTargetProvince() != null) {
				dao.setConditionTargetProvince("=", bean.getTargetProvince());
				count++;
			}
			if(bean.getNumberOfBaby() != null) {
				dao.setConditionNumberOfBaby("=", bean.getNumberOfBaby());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
				count++;
			}
			if(bean.getSubTypeStr() != null) {
				dao.setConditionSubTypeStr("=", bean.getSubTypeStr());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getIsRemoteCity() != null) {
				dao.setConditionIsRemoteCity("=", bean.getIsRemoteCity());
				count++;
			}
			if(bean.getProvideAccommodation() != null) {
				dao.setConditionProvideAccommodation("=", bean.getProvideAccommodation());
				count++;
			}
			if(bean.getDrafter() != null) {
				dao.setConditionDrafter("=", bean.getDrafter());
				count++;
			}
			if(bean.getCard() != null) {
				dao.setConditionCard("=", bean.getCard());
				count++;
			}
			if(bean.getDutyId() != null) {
				dao.setConditionDutyId("=", bean.getDutyId());
				count++;
			}
			if(bean.getEquivalentNumber() != null) {
				dao.setConditionEquivalentNumber("=", bean.getEquivalentNumber());
				count++;
			}
			if(bean.getLinkId() != null) {
				dao.setConditionLinkId("=", bean.getLinkId());
				count++;
			}
			if(bean.getSalary1() != null) {
				dao.setConditionSalary1("=", bean.getSalary1());
				count++;
			}
			if(bean.getSalary2() != null) {
				dao.setConditionSalary2("=", bean.getSalary2());
				count++;
			}
			if(bean.getOriginalPay() != null) {
				dao.setConditionOriginalPay("=", bean.getOriginalPay());
				count++;
			}
			if(bean.getMonthPay() != null) {
				dao.setConditionMonthPay("=", bean.getMonthPay());
				count++;
			}
			if(bean.getBasicProportionStr() != null) {
				dao.setConditionBasicProportionStr("=", bean.getBasicProportionStr());
				count++;
			}
			if(bean.getMonthBasicPay() != null) {
				dao.setConditionMonthBasicPay("=", bean.getMonthBasicPay());
				count++;
			}
			if(bean.getMonthPerformancePay() != null) {
				dao.setConditionMonthPerformancePay("=", bean.getMonthPerformancePay());
				count++;
			}
			if(bean.getForemanPay() != null) {
				dao.setConditionForemanPay("=", bean.getForemanPay());
				count++;
			}
			if(bean.getOtherSubsidy() != null) {
				dao.setConditionOtherSubsidy("=", bean.getOtherSubsidy());
				count++;
			}
			if(bean.getTotalPay() != null) {
				dao.setConditionTotalPay("=", bean.getTotalPay());
				count++;
			}
			if(bean.getAnnualPerformance() != null) {
				dao.setConditionAnnualPerformance("=", bean.getAnnualPerformance());
				count++;
			}
			if(bean.getCostAttribution() != null) {
				dao.setConditionCostAttribution("=", bean.getCostAttribution());
				count++;
			}
			if(bean.getProjectIds() != null) {
				dao.setConditionProjectIds("=", bean.getProjectIds());
				count++;
			}
			if(bean.getPaymentSequenceId() != null) {
				dao.setConditionPaymentSequenceId("=", bean.getPaymentSequenceId());
				count++;
			}
			if(bean.getBudgetManagementId() != null) {
				dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
				count++;
			}
			if(bean.getBudgetAttachmentId() != null) {
				dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
				count++;
			}
			if(bean.getStageId() != null) {
				dao.setConditionStageId("=", bean.getStageId());
				count++;
			}
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePersonnelBusines bean, PersonnelBusines dao){
		int count = 0;
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
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
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getStartDateDetail() != null) {
			dao.setConditionStartDateDetail("=", bean.getStartDateDetail());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getEndDateDetail() != null) {
			dao.setConditionEndDateDetail("=", bean.getEndDateDetail());
			count++;
		}
		if(bean.getDays() != null) {
			dao.setConditionDays("=", bean.getDays());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getAddress() != null) {
			if(bean.getAddress().indexOf("%") >= 0)
				dao.setConditionAddress("like", bean.getAddress());
			else
				dao.setConditionAddress("=", bean.getAddress());
			count++;
		}
		if(bean.getPlan() != null) {
			if(bean.getPlan().indexOf("%") >= 0)
				dao.setConditionPlan("like", bean.getPlan());
			else
				dao.setConditionPlan("=", bean.getPlan());
			count++;
		}
		if(bean.getTransportation() != null) {
			if(bean.getTransportation().indexOf("%") >= 0)
				dao.setConditionTransportation("like", bean.getTransportation());
			else
				dao.setConditionTransportation("=", bean.getTransportation());
			count++;
		}
		if(bean.getFee() != null) {
			dao.setConditionFee("=", bean.getFee());
			count++;
		}
		if(bean.getUnit() != null) {
			if(bean.getUnit().indexOf("%") >= 0)
				dao.setConditionUnit("like", bean.getUnit());
			else
				dao.setConditionUnit("=", bean.getUnit());
			count++;
		}
		if(bean.getContactPerson() != null) {
			if(bean.getContactPerson().indexOf("%") >= 0)
				dao.setConditionContactPerson("like", bean.getContactPerson());
			else
				dao.setConditionContactPerson("=", bean.getContactPerson());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getNextAuditor() != null) {
			dao.setConditionNextAuditor("=", bean.getNextAuditor());
			count++;
		}
		if(bean.getSubType() != null) {
			if(bean.getSubType().indexOf("%") >= 0)
				dao.setConditionSubType("like", bean.getSubType());
			else
				dao.setConditionSubType("=", bean.getSubType());
			count++;
		}
		if(bean.getHours() != null) {
			dao.setConditionHours("=", bean.getHours());
			count++;
		}
		if(bean.getCompanyProvince() != null) {
			dao.setConditionCompanyProvince("=", bean.getCompanyProvince());
			count++;
		}
		if(bean.getTargetProvince() != null) {
			dao.setConditionTargetProvince("=", bean.getTargetProvince());
			count++;
		}
		if(bean.getNumberOfBaby() != null) {
			dao.setConditionNumberOfBaby("=", bean.getNumberOfBaby());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
			count++;
		}
		if(bean.getSubTypeStr() != null) {
			if(bean.getSubTypeStr().indexOf("%") >= 0)
				dao.setConditionSubTypeStr("like", bean.getSubTypeStr());
			else
				dao.setConditionSubTypeStr("=", bean.getSubTypeStr());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getIsRemoteCity() != null) {
			dao.setConditionIsRemoteCity("=", bean.getIsRemoteCity());
			count++;
		}
		if(bean.getProvideAccommodation() != null) {
			dao.setConditionProvideAccommodation("=", bean.getProvideAccommodation());
			count++;
		}
		if(bean.getLivingExpenses() != null) {
			dao.setConditionLivingExpenses("=", bean.getLivingExpenses());
			count++;
		}
		if(bean.getHousingFinance() != null) {
			dao.setConditionHousingFinance("=", bean.getHousingFinance());
			count++;
		}
		if(bean.getDrafter() != null) {
			dao.setConditionDrafter("=", bean.getDrafter());
			count++;
		}
		if(bean.getCard() != null) {
			if(bean.getCard().indexOf("%") >= 0)
				dao.setConditionCard("like", bean.getCard());
			else
				dao.setConditionCard("=", bean.getCard());
			count++;
		}
		if(bean.getDutyId() != null) {
			dao.setConditionDutyId("=", bean.getDutyId());
			count++;
		}
		if(bean.getEquivalentNumber() != null) {
			if(bean.getEquivalentNumber().indexOf("%") >= 0)
				dao.setConditionEquivalentNumber("like", bean.getEquivalentNumber());
			else
				dao.setConditionEquivalentNumber("=", bean.getEquivalentNumber());
			count++;
		}
		if(bean.getLinkId() != null) {
			dao.setConditionLinkId("=", bean.getLinkId());
			count++;
		}
		if(bean.getSeverance() != null) {
			dao.setConditionSeverance("=", bean.getSeverance());
			count++;
		}
		if(bean.getSalary1() != null) {
			if(bean.getSalary1().indexOf("%") >= 0)
				dao.setConditionSalary1("like", bean.getSalary1());
			else
				dao.setConditionSalary1("=", bean.getSalary1());
			count++;
		}
		if(bean.getSalary2() != null) {
			if(bean.getSalary2().indexOf("%") >= 0)
				dao.setConditionSalary2("like", bean.getSalary2());
			else
				dao.setConditionSalary2("=", bean.getSalary2());
			count++;
		}
		if(bean.getOriginalPay() != null) {
			if(bean.getOriginalPay().indexOf("%") >= 0)
				dao.setConditionOriginalPay("like", bean.getOriginalPay());
			else
				dao.setConditionOriginalPay("=", bean.getOriginalPay());
			count++;
		}
		if(bean.getMonthPay() != null) {
			if(bean.getMonthPay().indexOf("%") >= 0)
				dao.setConditionMonthPay("like", bean.getMonthPay());
			else
				dao.setConditionMonthPay("=", bean.getMonthPay());
			count++;
		}
		if(bean.getBasicProportionStr() != null) {
			if(bean.getBasicProportionStr().indexOf("%") >= 0)
				dao.setConditionBasicProportionStr("like", bean.getBasicProportionStr());
			else
				dao.setConditionBasicProportionStr("=", bean.getBasicProportionStr());
			count++;
		}
		if(bean.getBasicProportion() != null) {
			dao.setConditionBasicProportion("=", bean.getBasicProportion());
			count++;
		}
		if(bean.getMonthBasicPay() != null) {
			if(bean.getMonthBasicPay().indexOf("%") >= 0)
				dao.setConditionMonthBasicPay("like", bean.getMonthBasicPay());
			else
				dao.setConditionMonthBasicPay("=", bean.getMonthBasicPay());
			count++;
		}
		if(bean.getMonthPerformancePay() != null) {
			if(bean.getMonthPerformancePay().indexOf("%") >= 0)
				dao.setConditionMonthPerformancePay("like", bean.getMonthPerformancePay());
			else
				dao.setConditionMonthPerformancePay("=", bean.getMonthPerformancePay());
			count++;
		}
		if(bean.getForemanPay() != null) {
			if(bean.getForemanPay().indexOf("%") >= 0)
				dao.setConditionForemanPay("like", bean.getForemanPay());
			else
				dao.setConditionForemanPay("=", bean.getForemanPay());
			count++;
		}
		if(bean.getOtherSubsidy() != null) {
			if(bean.getOtherSubsidy().indexOf("%") >= 0)
				dao.setConditionOtherSubsidy("like", bean.getOtherSubsidy());
			else
				dao.setConditionOtherSubsidy("=", bean.getOtherSubsidy());
			count++;
		}
		if(bean.getTotalPay() != null) {
			if(bean.getTotalPay().indexOf("%") >= 0)
				dao.setConditionTotalPay("like", bean.getTotalPay());
			else
				dao.setConditionTotalPay("=", bean.getTotalPay());
			count++;
		}
		if(bean.getAnnualPerformance() != null) {
			if(bean.getAnnualPerformance().indexOf("%") >= 0)
				dao.setConditionAnnualPerformance("like", bean.getAnnualPerformance());
			else
				dao.setConditionAnnualPerformance("=", bean.getAnnualPerformance());
			count++;
		}
		if(bean.getCostAttribution() != null) {
			dao.setConditionCostAttribution("=", bean.getCostAttribution());
			count++;
		}
		if(bean.getCertificationTime() != null) {
			dao.setConditionCertificationTime(">=", bean.getCertificationTime());
			count++;
		}
		if(bean.getProjectIds() != null) {
			dao.setConditionProjectIds("=", bean.getProjectIds());
			count++;
		}
		if(bean.getPaymentSequenceId() != null) {
			dao.setConditionPaymentSequenceId("=", bean.getPaymentSequenceId());
			count++;
		}
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBudgetAttachmentId() != null) {
			dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
			count++;
		}
		if(bean.getStageId() != null) {
			dao.setConditionStageId("=", bean.getStageId());
			count++;
		}
		if(bean.getAttachmentId() != null) {
			dao.setConditionAttachmentId("=", bean.getAttachmentId());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromJSON(json);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePersonnelBusines> rlist = new BaseCollection<>();
		BasePersonnelBusines bean = new BasePersonnelBusines();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PersonnelBusines dao = new PersonnelBusines();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePersonnelBusines> result = dao.conditionalLoad(addtion);
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
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromJSON(json);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromJSON(json);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromJSON(json);
		PersonnelBusines dao = new PersonnelBusines();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromJSON(json);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



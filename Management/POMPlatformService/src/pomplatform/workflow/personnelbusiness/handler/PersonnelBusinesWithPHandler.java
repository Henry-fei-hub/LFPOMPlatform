package pomplatform.workflow.personnelbusiness.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithP;
import pomplatform.workflow.personnelbusiness.dao.PersonnelBusinesWithP;
import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class PersonnelBusinesWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(PersonnelBusinesWithPHandler.class);

	public static BasePersonnelBusinesWithP getPersonnelBusinesWithPById( java.lang.Integer personnel_business_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BasePersonnelBusinesWithP result;
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			dao.setPersonnelBusinessId(personnel_business_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get PersonnelBusinesWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isPersonnelBusinesWithPExists( pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PersonnelBusinesWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countPersonnelBusinesWithP( pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PersonnelBusinesWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BasePersonnelBusinesWithP> queryPersonnelBusinesWithP( BasePersonnelBusinesWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BasePersonnelBusinesWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BasePersonnelBusinesWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query PersonnelBusinesWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePersonnelBusinesWithP addToPersonnelBusinesWithP ( BasePersonnelBusinesWithP personnelbusineswithp ) {
		return addToPersonnelBusinesWithP ( personnelbusineswithp , false);
	}

	public static BasePersonnelBusinesWithP addToPersonnelBusinesWithP ( BasePersonnelBusinesWithP personnelbusineswithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			dao.setDataFromBase(personnelbusineswithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PersonnelBusinesWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePersonnelBusinesWithP addUpdatePersonnelBusinesWithP ( BasePersonnelBusinesWithP personnelbusineswithp ) {
		return addUpdatePersonnelBusinesWithP ( personnelbusineswithp , false);
	}

	public static BasePersonnelBusinesWithP addUpdatePersonnelBusinesWithP ( BasePersonnelBusinesWithP personnelbusineswithp, boolean singleTransaction  ) {
		if(personnelbusineswithp.getPersonnelBusinessId() == null) return addToPersonnelBusinesWithP(personnelbusineswithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			dao.setDataFromBase(personnelbusineswithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(personnelbusineswithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PersonnelBusinesWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePersonnelBusinesWithP deletePersonnelBusinesWithP ( BasePersonnelBusinesWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete PersonnelBusinesWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePersonnelBusinesWithP updatePersonnelBusinesWithP ( BasePersonnelBusinesWithP personnelbusineswithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			dao.setPersonnelBusinessId( personnelbusineswithp.getPersonnelBusinessId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(personnelbusineswithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update PersonnelBusinesWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? personnelbusineswithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePersonnelBusinesWithP updatePersonnelBusinesWithPDirect( BasePersonnelBusinesWithP personnelbusineswithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
			int result = 0;
			dao.setDataFromBase(personnelbusineswithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update PersonnelBusinesWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? personnelbusineswithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BasePersonnelBusinesWithP bean, PersonnelBusinesWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPersonnelBusinessId() != null) {
			dao.setPersonnelBusinessId(bean.getPersonnelBusinessId());
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
		}
		return count;
	}

	public static int setConditions(BasePersonnelBusinesWithP bean, PersonnelBusinesWithP dao){
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();
		bean.setDataFromJSON(json);
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePersonnelBusinesWithP> rlist = new BaseCollection<>();
		BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePersonnelBusinesWithP> result = dao.conditionalLoadExt(addtion);
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
		BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();
		bean.setDataFromJSON(json);
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();
		bean.setDataFromJSON(json);
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();
		bean.setDataFromJSON(json);
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}



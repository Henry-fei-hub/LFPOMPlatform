package pomplatform.preProjects.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.preProjects.bean.BasePreProjectWithMmm;
import pomplatform.preProjects.dao.PreProjectWithMmm;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.MainProjectSpecialty;
import com.pomplatform.db.dao.MainProjectCompetitionUnit;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class PreProjectWithMmmHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(PreProjectWithMmmHandler.class);

	public static BasePreProjectWithMmm getPreProjectWithMmmById( java.lang.Integer pre_project_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BasePreProjectWithMmm result;
			PreProjectWithMmm dao = new PreProjectWithMmm();
			dao.setPreProjectId(pre_project_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get PreProjectWithMmm By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isPreProjectWithMmmExists( pomplatform.preProjects.bean.BasePreProjectWithMmm bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PreProjectWithMmm List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countPreProjectWithMmm( pomplatform.preProjects.bean.BasePreProjectWithMmm bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PreProjectWithMmm List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BasePreProjectWithMmm> queryPreProjectWithMmm( BasePreProjectWithMmm bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BasePreProjectWithMmm> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BasePreProjectWithMmm> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query PreProjectWithMmm List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePreProjectWithMmm addToPreProjectWithMmm ( BasePreProjectWithMmm preprojectwithmmm ) {
		return addToPreProjectWithMmm ( preprojectwithmmm , false);
	}

	public static BasePreProjectWithMmm addToPreProjectWithMmm ( BasePreProjectWithMmm preprojectwithmmm, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			dao.setDataFromBase(preprojectwithmmm);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PreProjectWithMmm time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePreProjectWithMmm addUpdatePreProjectWithMmm ( BasePreProjectWithMmm preprojectwithmmm ) {
		return addUpdatePreProjectWithMmm ( preprojectwithmmm , false);
	}

	public static BasePreProjectWithMmm addUpdatePreProjectWithMmm ( BasePreProjectWithMmm preprojectwithmmm, boolean singleTransaction  ) {
		if(preprojectwithmmm.getPreProjectId() == null) return addToPreProjectWithMmm(preprojectwithmmm);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			dao.setDataFromBase(preprojectwithmmm);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(preprojectwithmmm); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PreProjectWithMmm time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePreProjectWithMmm deletePreProjectWithMmm ( BasePreProjectWithMmm bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete PreProjectWithMmm time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePreProjectWithMmm updatePreProjectWithMmm ( BasePreProjectWithMmm preprojectwithmmm ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			dao.setPreProjectId( preprojectwithmmm.getPreProjectId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(preprojectwithmmm);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update PreProjectWithMmm time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? preprojectwithmmm : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePreProjectWithMmm updatePreProjectWithMmmDirect( BasePreProjectWithMmm preprojectwithmmm ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PreProjectWithMmm dao = new PreProjectWithMmm();
			int result = 0;
			dao.setDataFromBase(preprojectwithmmm);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update PreProjectWithMmm time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? preprojectwithmmm : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BasePreProjectWithMmm bean, PreProjectWithMmm dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPreProjectId() != null) {
			dao.setPreProjectId(bean.getPreProjectId());
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getClientId() != null) {
				dao.setConditionClientId("=", bean.getClientId());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getCustomerAddress() != null) {
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getDetailAddress() != null) {
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getProjectOrigination() != null) {
				dao.setConditionProjectOrigination("=", bean.getProjectOrigination());
				count++;
			}
			if(bean.getProjectOriginationRemark() != null) {
				dao.setConditionProjectOriginationRemark("=", bean.getProjectOriginationRemark());
				count++;
			}
			if(bean.getCustomerContactId() != null) {
				dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
				count++;
			}
			if(bean.getContactName() != null) {
				dao.setConditionContactName("=", bean.getContactName());
				count++;
			}
			if(bean.getContactPhone() != null) {
				dao.setConditionContactPhone("=", bean.getContactPhone());
				count++;
			}
			if(bean.getDesignStatus() != null) {
				dao.setConditionDesignStatus("=", bean.getDesignStatus());
				count++;
			}
			if(bean.getProjectSalesTeam() != null) {
				dao.setConditionProjectSalesTeam("=", bean.getProjectSalesTeam());
				count++;
			}
			if(bean.getDesignTeam() != null) {
				dao.setConditionDesignTeam("=", bean.getDesignTeam());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getSignCompany() != null) {
				dao.setConditionSignCompany("=", bean.getSignCompany());
				count++;
			}
			if(bean.getDesignQualification() != null) {
				dao.setConditionDesignQualification("=", bean.getDesignQualification());
				count++;
			}
			if(bean.getProjectBaseOn() != null) {
				dao.setConditionProjectBaseOn("=", bean.getProjectBaseOn());
				count++;
			}
			if(bean.getIsHighRiseBuilding() != null) {
				dao.setConditionIsHighRiseBuilding("=", bean.getIsHighRiseBuilding());
				count++;
			}
			if(bean.getDesignCooperationName() != null) {
				dao.setConditionDesignCooperationName("=", bean.getDesignCooperationName());
				count++;
			}
			if(bean.getArchitecturalDesignUnits() != null) {
				dao.setConditionArchitecturalDesignUnits("=", bean.getArchitecturalDesignUnits());
				count++;
			}
			if(bean.getFireResistanceRating() != null) {
				dao.setConditionFireResistanceRating("=", bean.getFireResistanceRating());
				count++;
			}
			if(bean.getSpecialty() != null) {
				dao.setConditionSpecialty("=", bean.getSpecialty());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getHasContract() != null) {
				dao.setConditionHasContract("=", bean.getHasContract());
				count++;
			}
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
				count++;
			}
			if(bean.getProjectStatus() != null) {
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
				count++;
			}
			if(bean.getCloseReason() != null) {
				dao.setConditionCloseReason("=", bean.getCloseReason());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePreProjectWithMmm bean, PreProjectWithMmm dao){
		int count = 0;
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getCustomerAddress() != null) {
			if(bean.getCustomerAddress().indexOf("%") >= 0)
				dao.setConditionCustomerAddress("like", bean.getCustomerAddress());
			else
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProvince() != null) {
			if(bean.getProvince().indexOf("%") >= 0)
				dao.setConditionProvince("like", bean.getProvince());
			else
				dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			if(bean.getCity().indexOf("%") >= 0)
				dao.setConditionCity("like", bean.getCity());
			else
				dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getDetailAddress() != null) {
			if(bean.getDetailAddress().indexOf("%") >= 0)
				dao.setConditionDetailAddress("like", bean.getDetailAddress());
			else
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getTotalBuildingAreas() != null) {
			dao.setConditionTotalBuildingAreas("=", bean.getTotalBuildingAreas());
			count++;
		}
		if(bean.getProjectOrigination() != null) {
			if(bean.getProjectOrigination().indexOf("%") >= 0)
				dao.setConditionProjectOrigination("like", bean.getProjectOrigination());
			else
				dao.setConditionProjectOrigination("=", bean.getProjectOrigination());
			count++;
		}
		if(bean.getProjectOriginationRemark() != null) {
			if(bean.getProjectOriginationRemark().indexOf("%") >= 0)
				dao.setConditionProjectOriginationRemark("like", bean.getProjectOriginationRemark());
			else
				dao.setConditionProjectOriginationRemark("=", bean.getProjectOriginationRemark());
			count++;
		}
		if(bean.getCustomerContactId() != null) {
			dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
			count++;
		}
		if(bean.getContactName() != null) {
			if(bean.getContactName().indexOf("%") >= 0)
				dao.setConditionContactName("like", bean.getContactName());
			else
				dao.setConditionContactName("=", bean.getContactName());
			count++;
		}
		if(bean.getContactPhone() != null) {
			if(bean.getContactPhone().indexOf("%") >= 0)
				dao.setConditionContactPhone("like", bean.getContactPhone());
			else
				dao.setConditionContactPhone("=", bean.getContactPhone());
			count++;
		}
		if(bean.getDesignStatus() != null) {
			if(bean.getDesignStatus().indexOf("%") >= 0)
				dao.setConditionDesignStatus("like", bean.getDesignStatus());
			else
				dao.setConditionDesignStatus("=", bean.getDesignStatus());
			count++;
		}
		if(bean.getProjectSalesTeam() != null) {
			if(bean.getProjectSalesTeam().indexOf("%") >= 0)
				dao.setConditionProjectSalesTeam("like", bean.getProjectSalesTeam());
			else
				dao.setConditionProjectSalesTeam("=", bean.getProjectSalesTeam());
			count++;
		}
		if(bean.getDesignTeam() != null) {
			dao.setConditionDesignTeam("=", bean.getDesignTeam());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getSignCompany() != null) {
			dao.setConditionSignCompany("=", bean.getSignCompany());
			count++;
		}
		if(bean.getDesignQualification() != null) {
			if(bean.getDesignQualification().indexOf("%") >= 0)
				dao.setConditionDesignQualification("like", bean.getDesignQualification());
			else
				dao.setConditionDesignQualification("=", bean.getDesignQualification());
			count++;
		}
		if(bean.getProjectBaseOn() != null) {
			dao.setConditionProjectBaseOn("=", bean.getProjectBaseOn());
			count++;
		}
		if(bean.getProjectApprovalTime() != null) {
			dao.setConditionProjectApprovalTime(">=", bean.getProjectApprovalTime());
			count++;
		}
		if(bean.getIsHighRiseBuilding() != null) {
			dao.setConditionIsHighRiseBuilding("=", bean.getIsHighRiseBuilding());
			count++;
		}
		if(bean.getDesignCooperationName() != null) {
			if(bean.getDesignCooperationName().indexOf("%") >= 0)
				dao.setConditionDesignCooperationName("like", bean.getDesignCooperationName());
			else
				dao.setConditionDesignCooperationName("=", bean.getDesignCooperationName());
			count++;
		}
		if(bean.getArchitecturalDesignUnits() != null) {
			if(bean.getArchitecturalDesignUnits().indexOf("%") >= 0)
				dao.setConditionArchitecturalDesignUnits("like", bean.getArchitecturalDesignUnits());
			else
				dao.setConditionArchitecturalDesignUnits("=", bean.getArchitecturalDesignUnits());
			count++;
		}
		if(bean.getProjectTotalInvestment() != null) {
			dao.setConditionProjectTotalInvestment("=", bean.getProjectTotalInvestment());
			count++;
		}
		if(bean.getFireResistanceRating() != null) {
			if(bean.getFireResistanceRating().indexOf("%") >= 0)
				dao.setConditionFireResistanceRating("like", bean.getFireResistanceRating());
			else
				dao.setConditionFireResistanceRating("=", bean.getFireResistanceRating());
			count++;
		}
		if(bean.getEstimateTheDesignAreas() != null) {
			dao.setConditionEstimateTheDesignAreas("=", bean.getEstimateTheDesignAreas());
			count++;
		}
		if(bean.getActualDesignAreas() != null) {
			dao.setConditionActualDesignAreas("=", bean.getActualDesignAreas());
			count++;
		}
		if(bean.getBuildingHeight() != null) {
			dao.setConditionBuildingHeight("=", bean.getBuildingHeight());
			count++;
		}
		if(bean.getBuildingFloors() != null) {
			dao.setConditionBuildingFloors("=", bean.getBuildingFloors());
			count++;
		}
		if(bean.getDecorateMoneyControl() != null) {
			dao.setConditionDecorateMoneyControl("=", bean.getDecorateMoneyControl());
			count++;
		}
		if(bean.getSpecialty() != null) {
			if(bean.getSpecialty().indexOf("%") >= 0)
				dao.setConditionSpecialty("like", bean.getSpecialty());
			else
				dao.setConditionSpecialty("=", bean.getSpecialty());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getHasContract() != null) {
			dao.setConditionHasContract("=", bean.getHasContract());
			count++;
		}
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getInfoRegisterTime() != null) {
			dao.setConditionInfoRegisterTime(">=", bean.getInfoRegisterTime());
			count++;
		}
		if(bean.getProjectStatus() != null) {
			if(bean.getProjectStatus().indexOf("%") >= 0)
				dao.setConditionProjectStatus("like", bean.getProjectStatus());
			else
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
			count++;
		}
		if(bean.getCloseReason() != null) {
			if(bean.getCloseReason().indexOf("%") >= 0)
				dao.setConditionCloseReason("like", bean.getCloseReason());
			else
				dao.setConditionCloseReason("=", bean.getCloseReason());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
		bean.setDataFromJSON(json);
		PreProjectWithMmm dao = new PreProjectWithMmm();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePreProjectWithMmm> rlist = new BaseCollection<>();
		BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PreProjectWithMmm dao = new PreProjectWithMmm();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePreProjectWithMmm> result = dao.conditionalLoadExt(addtion);
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
		BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
		bean.setDataFromJSON(json);
		PreProjectWithMmm dao = new PreProjectWithMmm();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
		bean.setDataFromJSON(json);
		int num = 0;
		PreProjectWithMmm dao = new PreProjectWithMmm();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
		bean.setDataFromJSON(json);
		PreProjectWithMmm dao = new PreProjectWithMmm();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
		bean.setDataFromJSON(json);
		PreProjectWithMmm dao = new PreProjectWithMmm();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}



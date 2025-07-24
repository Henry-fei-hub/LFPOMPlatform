package pomplatform.ht2.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.ht2.bean.BaseFormalContractWithO;
import pomplatform.ht2.dao.FormalContractWithO;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.date.util.TimeSpanCalculator;

public class FormalContractWithOHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(FormalContractWithOHandler.class);

	public static BaseFormalContractWithO getFormalContractWithOById( java.lang.Integer formal_contract_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseFormalContractWithO result;
			FormalContractWithO dao = new FormalContractWithO();
			dao.setFormalContractId(formal_contract_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get FormalContractWithO By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isFormalContractWithOExists( pomplatform.ht2.bean.BaseFormalContractWithO bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			FormalContractWithO dao = new FormalContractWithO();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query FormalContractWithO List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countFormalContractWithO( pomplatform.ht2.bean.BaseFormalContractWithO bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			FormalContractWithO dao = new FormalContractWithO();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query FormalContractWithO List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseFormalContractWithO> queryFormalContractWithO( BaseFormalContractWithO bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			FormalContractWithO dao = new FormalContractWithO();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseFormalContractWithO> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseFormalContractWithO> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query FormalContractWithO List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseFormalContractWithO addToFormalContractWithO ( BaseFormalContractWithO formalcontractwitho ) {
		return addToFormalContractWithO ( formalcontractwitho , false);
	}

	public static BaseFormalContractWithO addToFormalContractWithO ( BaseFormalContractWithO formalcontractwitho, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			FormalContractWithO dao = new FormalContractWithO();
			dao.setDataFromBase(formalcontractwitho);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to FormalContractWithO time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseFormalContractWithO addUpdateFormalContractWithO ( BaseFormalContractWithO formalcontractwitho ) {
		return addUpdateFormalContractWithO ( formalcontractwitho , false);
	}

	public static BaseFormalContractWithO addUpdateFormalContractWithO ( BaseFormalContractWithO formalcontractwitho, boolean singleTransaction  ) {
		if(formalcontractwitho.getFormalContractId() == null) return addToFormalContractWithO(formalcontractwitho);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			FormalContractWithO dao = new FormalContractWithO();
			dao.setDataFromBase(formalcontractwitho);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(formalcontractwitho); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to FormalContractWithO time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseFormalContractWithO deleteFormalContractWithO ( BaseFormalContractWithO bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			FormalContractWithO dao = new FormalContractWithO();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete FormalContractWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseFormalContractWithO updateFormalContractWithO ( BaseFormalContractWithO formalcontractwitho ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			FormalContractWithO dao = new FormalContractWithO();
			dao.setFormalContractId( formalcontractwitho.getFormalContractId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(formalcontractwitho);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update FormalContractWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? formalcontractwitho : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseFormalContractWithO updateFormalContractWithODirect( BaseFormalContractWithO formalcontractwitho ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			FormalContractWithO dao = new FormalContractWithO();
			int result = 0;
			dao.setDataFromBase(formalcontractwitho);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update FormalContractWithO time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? formalcontractwitho : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseFormalContractWithO bean, FormalContractWithO dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFormalContractId() != null) {
			dao.setFormalContractId(bean.getFormalContractId());
			dao.setConditionFormalContractId("=", bean.getFormalContractId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getClientContractId() != null) {
				dao.setConditionClientContractId("=", bean.getClientContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getContractType() != null) {
				dao.setConditionContractType("=", bean.getContractType());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getTotalProjectTime() != null) {
				dao.setConditionTotalProjectTime("=", bean.getTotalProjectTime());
				count++;
			}
			if(bean.getProjectAddress() != null) {
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
				count++;
			}
			if(bean.getContractFollower() != null) {
				dao.setConditionContractFollower("=", bean.getContractFollower());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSigningCompanyName() != null) {
				dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getFlowStatus() != null) {
				dao.setConditionFlowStatus("=", bean.getFlowStatus());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getProfessionalCooperation() != null) {
				dao.setConditionProfessionalCooperation("=", bean.getProfessionalCooperation());
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
			if(bean.getCustomerAddress() != null) {
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
				count++;
			}
			if(bean.getServiceSuggestBook() != null) {
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getContractStatus() != null) {
				dao.setConditionContractStatus("=", bean.getContractStatus());
				count++;
			}
			if(bean.getJobMix() != null) {
				dao.setConditionJobMix("=", bean.getJobMix());
				count++;
			}
			if(bean.getOnSiteTime() != null) {
				dao.setConditionOnSiteTime("=", bean.getOnSiteTime());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFormalContractWithO bean, FormalContractWithO dao){
		int count = 0;
		if(bean.getFormalContractId() != null) {
			dao.setConditionFormalContractId("=", bean.getFormalContractId());
			count++;
		}
		if(bean.getClientContractId() != null) {
			if(bean.getClientContractId().indexOf("%") >= 0)
				dao.setConditionClientContractId("like", bean.getClientContractId());
			else
				dao.setConditionClientContractId("=", bean.getClientContractId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getContractType() != null) {
			dao.setConditionContractType("=", bean.getContractType());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getTotalProjectTime() != null) {
			dao.setConditionTotalProjectTime("=", bean.getTotalProjectTime());
			count++;
		}
		if(bean.getSigningMoneySum() != null) {
			dao.setConditionSigningMoneySum("=", bean.getSigningMoneySum());
			count++;
		}
		if(bean.getDesignAreas() != null) {
			dao.setConditionDesignAreas("=", bean.getDesignAreas());
			count++;
		}
		if(bean.getContractPrice() != null) {
			dao.setConditionContractPrice("=", bean.getContractPrice());
			count++;
		}
		if(bean.getProjectAddress() != null) {
			if(bean.getProjectAddress().indexOf("%") >= 0)
				dao.setConditionProjectAddress("like", bean.getProjectAddress());
			else
				dao.setConditionProjectAddress("=", bean.getProjectAddress());
			count++;
		}
		if(bean.getContractFollower() != null) {
			dao.setConditionContractFollower("=", bean.getContractFollower());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getSigningCompanyName() != null) {
			dao.setConditionSigningCompanyName("=", bean.getSigningCompanyName());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getFlowStatus() != null) {
			dao.setConditionFlowStatus("=", bean.getFlowStatus());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			if(bean.getSerialNumber().indexOf("%") >= 0)
				dao.setConditionSerialNumber("like", bean.getSerialNumber());
			else
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getProjectType() != null) {
			if(bean.getProjectType().indexOf("%") >= 0)
				dao.setConditionProjectType("like", bean.getProjectType());
			else
				dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getCoveredArea() != null) {
			dao.setConditionCoveredArea("=", bean.getCoveredArea());
			count++;
		}
		if(bean.getProfessionalCooperation() != null) {
			if(bean.getProfessionalCooperation().indexOf("%") >= 0)
				dao.setConditionProfessionalCooperation("like", bean.getProfessionalCooperation());
			else
				dao.setConditionProfessionalCooperation("=", bean.getProfessionalCooperation());
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
		if(bean.getCustomerAddress() != null) {
			if(bean.getCustomerAddress().indexOf("%") >= 0)
				dao.setConditionCustomerAddress("like", bean.getCustomerAddress());
			else
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
			count++;
		}
		if(bean.getServiceSuggestBook() != null) {
			if(bean.getServiceSuggestBook().indexOf("%") >= 0)
				dao.setConditionServiceSuggestBook("like", bean.getServiceSuggestBook());
			else
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
			count++;
		}
		if(bean.getProjectApprovalTime() != null) {
			dao.setConditionProjectApprovalTime(">=", bean.getProjectApprovalTime());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getContractStatus() != null) {
			dao.setConditionContractStatus("=", bean.getContractStatus());
			count++;
		}
		if(bean.getJobMix() != null) {
			dao.setConditionJobMix("=", bean.getJobMix());
			count++;
		}
		if(bean.getServiceArea() != null) {
			dao.setConditionServiceArea("=", bean.getServiceArea());
			count++;
		}
		if(bean.getWithTheAmount() != null) {
			dao.setConditionWithTheAmount("=", bean.getWithTheAmount());
			count++;
		}
		if(bean.getOnSiteTime() != null) {
			dao.setConditionOnSiteTime("=", bean.getOnSiteTime());
			count++;
		}
		if(bean.getOnSiteTotalMoney() != null) {
			dao.setConditionOnSiteTotalMoney("=", bean.getOnSiteTotalMoney());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFormalContractWithO bean = new BaseFormalContractWithO();
		bean.setDataFromJSON(json);
		FormalContractWithO dao = new FormalContractWithO();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFormalContractWithO> rlist = new BaseCollection<>();
		BaseFormalContractWithO bean = new BaseFormalContractWithO();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FormalContractWithO dao = new FormalContractWithO();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFormalContractWithO> result = dao.conditionalLoadExt(addtion);
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
		BaseFormalContractWithO bean = new BaseFormalContractWithO();
		bean.setDataFromJSON(json);
		FormalContractWithO dao = new FormalContractWithO();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFormalContractWithO bean = new BaseFormalContractWithO();
		bean.setDataFromJSON(json);
		int num = 0;
		FormalContractWithO dao = new FormalContractWithO();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFormalContractWithO bean = new BaseFormalContractWithO();
		bean.setDataFromJSON(json);
		FormalContractWithO dao = new FormalContractWithO();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFormalContractWithO bean = new BaseFormalContractWithO();
		bean.setDataFromJSON(json);
		FormalContractWithO dao = new FormalContractWithO();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

}



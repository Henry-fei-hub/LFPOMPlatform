package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseDesignConsiderationHistory;
import com.pomplatform.db.dao.DesignConsiderationHistory;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class DesignConsiderationHistoryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(DesignConsiderationHistoryHandler.class);

	public static BaseDesignConsiderationHistory getDesignConsiderationHistoryById( 
		java.lang.Integer design_consideration_history_id
	) throws Exception
	{
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setDesignConsiderationHistoryId(design_consideration_history_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isDesignConsiderationHistoryExists( com.pomplatform.db.bean.BaseDesignConsiderationHistory bean, String additional ) throws Exception {

		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countDesignConsiderationHistory( com.pomplatform.db.bean.BaseDesignConsiderationHistory bean, String additional ) throws Exception {

		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseDesignConsiderationHistory> queryDesignConsiderationHistory( com.pomplatform.db.bean.BaseDesignConsiderationHistory bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseDesignConsiderationHistory> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseDesignConsiderationHistory> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseDesignConsiderationHistory addToDesignConsiderationHistory ( BaseDesignConsiderationHistory designconsiderationhistory )  throws Exception {
		return addToDesignConsiderationHistory ( designconsiderationhistory , false);
	}

	public static BaseDesignConsiderationHistory addToDesignConsiderationHistory ( BaseDesignConsiderationHistory designconsiderationhistory, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setDataFromBase(designconsiderationhistory);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseDesignConsiderationHistory addUpdateDesignConsiderationHistory ( BaseDesignConsiderationHistory designconsiderationhistory ) throws Exception {
		return addUpdateDesignConsiderationHistory ( designconsiderationhistory , false);
	}

	public static BaseDesignConsiderationHistory addUpdateDesignConsiderationHistory ( BaseDesignConsiderationHistory designconsiderationhistory, boolean singleTransaction  ) throws Exception {
		if(designconsiderationhistory.getDesignConsiderationHistoryId() == null) return addToDesignConsiderationHistory(designconsiderationhistory);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setDataFromBase(designconsiderationhistory);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(designconsiderationhistory); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteDesignConsiderationHistory ( BaseDesignConsiderationHistory bean ) throws Exception {
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseDesignConsiderationHistory updateDesignConsiderationHistory ( BaseDesignConsiderationHistory designconsiderationhistory ) throws Exception {
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setDesignConsiderationHistoryId( designconsiderationhistory.getDesignConsiderationHistoryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(designconsiderationhistory);
			result = dao.update();
		}
		return result == 1 ? designconsiderationhistory : null ;
	}

	public static BaseDesignConsiderationHistory updateDesignConsiderationHistoryDirect( BaseDesignConsiderationHistory designconsiderationhistory ) throws Exception {
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		int result = 0;
		dao.setDataFromBase(designconsiderationhistory);
		result = dao.update();
		return result == 1 ? designconsiderationhistory : null ;
	}

	public static int setDeleteConditions(BaseDesignConsiderationHistory bean, DesignConsiderationHistory dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getDesignConsiderationHistoryId() != null) {
			dao.setConditionDesignConsiderationHistoryId("=", bean.getDesignConsiderationHistoryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getHistoryStatus() != null) {
				dao.setConditionHistoryStatus("=", bean.getHistoryStatus());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getMainDesignAreaName() != null) {
				dao.setConditionMainDesignAreaName("=", bean.getMainDesignAreaName());
				count++;
			}
			if(bean.getDecorationStatus() != null) {
				dao.setConditionDecorationStatus("=", bean.getDecorationStatus());
				count++;
			}
			if(bean.getSubContractId() != null) {
				dao.setConditionSubContractId("=", bean.getSubContractId());
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
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getHistoryVersion() != null) {
				dao.setConditionHistoryVersion("=", bean.getHistoryVersion());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseDesignConsiderationHistory bean, DesignConsiderationHistory dao){
		int count = 0;
		if(bean.getDesignConsiderationHistoryId() != null) {
			dao.setConditionDesignConsiderationHistoryId("=", bean.getDesignConsiderationHistoryId());
			count++;
		}
		if(bean.getHistoryStatus() != null) {
			dao.setConditionHistoryStatus("=", bean.getHistoryStatus());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getMainDesignAreaName() != null) {
			if(bean.getMainDesignAreaName().indexOf("%") >= 0)
				dao.setConditionMainDesignAreaName("like", bean.getMainDesignAreaName());
			else
				dao.setConditionMainDesignAreaName("=", bean.getMainDesignAreaName());
			count++;
		}
		if(bean.getDecorationStatus() != null) {
			dao.setConditionDecorationStatus("=", bean.getDecorationStatus());
			count++;
		}
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getDesignUnitPrice() != null) {
			dao.setConditionDesignUnitPrice("=", bean.getDesignUnitPrice());
			count++;
		}
		if(bean.getMoneySum() != null) {
			dao.setConditionMoneySum("=", bean.getMoneySum());
			count++;
		}
		if(bean.getSubContractId() != null) {
			dao.setConditionSubContractId("=", bean.getSubContractId());
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
		if(bean.getOnSitePrice() != null) {
			dao.setConditionOnSitePrice("=", bean.getOnSitePrice());
			count++;
		}
		if(bean.getOnSiteTotalMoney() != null) {
			dao.setConditionOnSiteTotalMoney("=", bean.getOnSiteTotalMoney());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getMoveTime() != null) {
			dao.setConditionMoveTime(">=", bean.getMoveTime());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getHistoryVersion() != null) {
			dao.setConditionHistoryVersion("=", bean.getHistoryVersion());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseDesignConsiderationHistory bean = new BaseDesignConsiderationHistory();
		bean.setDataFromJSON(json);
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseDesignConsiderationHistory> rlist = new BaseCollection<>();
		BaseDesignConsiderationHistory bean = new BaseDesignConsiderationHistory();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseDesignConsiderationHistory> result = dao.conditionalLoad(addtion);
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
		BaseDesignConsiderationHistory bean = new BaseDesignConsiderationHistory();
		bean.setDataFromJSON(json);
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseDesignConsiderationHistory bean = new BaseDesignConsiderationHistory();
		bean.setDataFromJSON(json);
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseDesignConsiderationHistory bean = new BaseDesignConsiderationHistory();
		bean.setDataFromJSON(json);
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseDesignConsiderationHistory bean = new BaseDesignConsiderationHistory();
		bean.setDataFromJSON(json);
		DesignConsiderationHistory dao = new DesignConsiderationHistory();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



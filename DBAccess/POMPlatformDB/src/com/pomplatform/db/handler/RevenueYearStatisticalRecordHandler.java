package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseRevenueYearStatisticalRecord;
import com.pomplatform.db.dao.RevenueYearStatisticalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class RevenueYearStatisticalRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(RevenueYearStatisticalRecordHandler.class);

	public static BaseRevenueYearStatisticalRecord getRevenueYearStatisticalRecordById( 
		java.lang.Integer revenue_year_statistical_record_id
	) throws Exception
	{
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setRevenueYearStatisticalRecordId(revenue_year_statistical_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isRevenueYearStatisticalRecordExists( com.pomplatform.db.bean.BaseRevenueYearStatisticalRecord bean, String additional ) throws Exception {

		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countRevenueYearStatisticalRecord( com.pomplatform.db.bean.BaseRevenueYearStatisticalRecord bean, String additional ) throws Exception {

		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseRevenueYearStatisticalRecord> queryRevenueYearStatisticalRecord( com.pomplatform.db.bean.BaseRevenueYearStatisticalRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseRevenueYearStatisticalRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseRevenueYearStatisticalRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseRevenueYearStatisticalRecord addToRevenueYearStatisticalRecord ( BaseRevenueYearStatisticalRecord revenueyearstatisticalrecord )  throws Exception {
		return addToRevenueYearStatisticalRecord ( revenueyearstatisticalrecord , false);
	}

	public static BaseRevenueYearStatisticalRecord addToRevenueYearStatisticalRecord ( BaseRevenueYearStatisticalRecord revenueyearstatisticalrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setDataFromBase(revenueyearstatisticalrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseRevenueYearStatisticalRecord addUpdateRevenueYearStatisticalRecord ( BaseRevenueYearStatisticalRecord revenueyearstatisticalrecord ) throws Exception {
		return addUpdateRevenueYearStatisticalRecord ( revenueyearstatisticalrecord , false);
	}

	public static BaseRevenueYearStatisticalRecord addUpdateRevenueYearStatisticalRecord ( BaseRevenueYearStatisticalRecord revenueyearstatisticalrecord, boolean singleTransaction  ) throws Exception {
		if(revenueyearstatisticalrecord.getRevenueYearStatisticalRecordId() == null) return addToRevenueYearStatisticalRecord(revenueyearstatisticalrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setDataFromBase(revenueyearstatisticalrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(revenueyearstatisticalrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteRevenueYearStatisticalRecord ( BaseRevenueYearStatisticalRecord bean ) throws Exception {
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseRevenueYearStatisticalRecord updateRevenueYearStatisticalRecord ( BaseRevenueYearStatisticalRecord revenueyearstatisticalrecord ) throws Exception {
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setRevenueYearStatisticalRecordId( revenueyearstatisticalrecord.getRevenueYearStatisticalRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(revenueyearstatisticalrecord);
			result = dao.update();
		}
		return result == 1 ? revenueyearstatisticalrecord : null ;
	}

	public static BaseRevenueYearStatisticalRecord updateRevenueYearStatisticalRecordDirect( BaseRevenueYearStatisticalRecord revenueyearstatisticalrecord ) throws Exception {
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		int result = 0;
		dao.setDataFromBase(revenueyearstatisticalrecord);
		result = dao.update();
		return result == 1 ? revenueyearstatisticalrecord : null ;
	}

	public static int setDeleteConditions(BaseRevenueYearStatisticalRecord bean, RevenueYearStatisticalRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getRevenueYearStatisticalRecordId() != null) {
			dao.setConditionRevenueYearStatisticalRecordId("=", bean.getRevenueYearStatisticalRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseRevenueYearStatisticalRecord bean, RevenueYearStatisticalRecord dao){
		int count = 0;
		if(bean.getRevenueYearStatisticalRecordId() != null) {
			dao.setConditionRevenueYearStatisticalRecordId("=", bean.getRevenueYearStatisticalRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getJanuaryRevenue() != null) {
			dao.setConditionJanuaryRevenue("=", bean.getJanuaryRevenue());
			count++;
		}
		if(bean.getFebruaryRevenue() != null) {
			dao.setConditionFebruaryRevenue("=", bean.getFebruaryRevenue());
			count++;
		}
		if(bean.getMarchRevenue() != null) {
			dao.setConditionMarchRevenue("=", bean.getMarchRevenue());
			count++;
		}
		if(bean.getAprilRevenue() != null) {
			dao.setConditionAprilRevenue("=", bean.getAprilRevenue());
			count++;
		}
		if(bean.getMayRevenue() != null) {
			dao.setConditionMayRevenue("=", bean.getMayRevenue());
			count++;
		}
		if(bean.getJuneRevenue() != null) {
			dao.setConditionJuneRevenue("=", bean.getJuneRevenue());
			count++;
		}
		if(bean.getJulyRevenue() != null) {
			dao.setConditionJulyRevenue("=", bean.getJulyRevenue());
			count++;
		}
		if(bean.getAugustRevenue() != null) {
			dao.setConditionAugustRevenue("=", bean.getAugustRevenue());
			count++;
		}
		if(bean.getSeptemberRevenue() != null) {
			dao.setConditionSeptemberRevenue("=", bean.getSeptemberRevenue());
			count++;
		}
		if(bean.getOctoberRevenue() != null) {
			dao.setConditionOctoberRevenue("=", bean.getOctoberRevenue());
			count++;
		}
		if(bean.getNovemberRevenue() != null) {
			dao.setConditionNovemberRevenue("=", bean.getNovemberRevenue());
			count++;
		}
		if(bean.getDecemberRevenue() != null) {
			dao.setConditionDecemberRevenue("=", bean.getDecemberRevenue());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseRevenueYearStatisticalRecord bean = new BaseRevenueYearStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseRevenueYearStatisticalRecord> rlist = new BaseCollection<>();
		BaseRevenueYearStatisticalRecord bean = new BaseRevenueYearStatisticalRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseRevenueYearStatisticalRecord> result = dao.conditionalLoad(addtion);
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
		BaseRevenueYearStatisticalRecord bean = new BaseRevenueYearStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseRevenueYearStatisticalRecord bean = new BaseRevenueYearStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseRevenueYearStatisticalRecord bean = new BaseRevenueYearStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseRevenueYearStatisticalRecord bean = new BaseRevenueYearStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueYearStatisticalRecord dao = new RevenueYearStatisticalRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



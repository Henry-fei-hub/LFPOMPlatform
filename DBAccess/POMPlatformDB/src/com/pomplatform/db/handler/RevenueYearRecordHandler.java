package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseRevenueYearRecord;
import com.pomplatform.db.dao.RevenueYearRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class RevenueYearRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(RevenueYearRecordHandler.class);

	public static BaseRevenueYearRecord getRevenueYearRecordById( 
		java.lang.Integer revenue_year_record_id
	) throws Exception
	{
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setRevenueYearRecordId(revenue_year_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isRevenueYearRecordExists( com.pomplatform.db.bean.BaseRevenueYearRecord bean, String additional ) throws Exception {

		RevenueYearRecord dao = new RevenueYearRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countRevenueYearRecord( com.pomplatform.db.bean.BaseRevenueYearRecord bean, String additional ) throws Exception {

		RevenueYearRecord dao = new RevenueYearRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseRevenueYearRecord> queryRevenueYearRecord( com.pomplatform.db.bean.BaseRevenueYearRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		RevenueYearRecord dao = new RevenueYearRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseRevenueYearRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseRevenueYearRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseRevenueYearRecord addToRevenueYearRecord ( BaseRevenueYearRecord revenueyearrecord )  throws Exception {
		return addToRevenueYearRecord ( revenueyearrecord , false);
	}

	public static BaseRevenueYearRecord addToRevenueYearRecord ( BaseRevenueYearRecord revenueyearrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setDataFromBase(revenueyearrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseRevenueYearRecord addUpdateRevenueYearRecord ( BaseRevenueYearRecord revenueyearrecord ) throws Exception {
		return addUpdateRevenueYearRecord ( revenueyearrecord , false);
	}

	public static BaseRevenueYearRecord addUpdateRevenueYearRecord ( BaseRevenueYearRecord revenueyearrecord, boolean singleTransaction  ) throws Exception {
		if(revenueyearrecord.getRevenueYearRecordId() == null) return addToRevenueYearRecord(revenueyearrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setDataFromBase(revenueyearrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(revenueyearrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteRevenueYearRecord ( BaseRevenueYearRecord bean ) throws Exception {
		RevenueYearRecord dao = new RevenueYearRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseRevenueYearRecord updateRevenueYearRecord ( BaseRevenueYearRecord revenueyearrecord ) throws Exception {
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setRevenueYearRecordId( revenueyearrecord.getRevenueYearRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(revenueyearrecord);
			result = dao.update();
		}
		return result == 1 ? revenueyearrecord : null ;
	}

	public static BaseRevenueYearRecord updateRevenueYearRecordDirect( BaseRevenueYearRecord revenueyearrecord ) throws Exception {
		RevenueYearRecord dao = new RevenueYearRecord();
		int result = 0;
		dao.setDataFromBase(revenueyearrecord);
		result = dao.update();
		return result == 1 ? revenueyearrecord : null ;
	}

	public static int setDeleteConditions(BaseRevenueYearRecord bean, RevenueYearRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getRevenueYearRecordId() != null) {
			dao.setConditionRevenueYearRecordId("=", bean.getRevenueYearRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getYearRevenue() != null) {
				dao.setConditionYearRevenue("=", bean.getYearRevenue());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getSigningCompany() != null) {
				dao.setConditionSigningCompany("=", bean.getSigningCompany());
				count++;
			}
			if(bean.getIsFinish() != null) {
				dao.setConditionIsFinish("=", bean.getIsFinish());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseRevenueYearRecord bean, RevenueYearRecord dao){
		int count = 0;
		if(bean.getRevenueYearRecordId() != null) {
			dao.setConditionRevenueYearRecordId("=", bean.getRevenueYearRecordId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getMoney() != null) {
			dao.setConditionMoney("=", bean.getMoney());
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
		if(bean.getTotalRevenue() != null) {
			dao.setConditionTotalRevenue("=", bean.getTotalRevenue());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getYearRevenue() != null) {
			dao.setConditionYearRevenue("=", bean.getYearRevenue());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		if(bean.getSigningCompany() != null) {
			dao.setConditionSigningCompany("=", bean.getSigningCompany());
			count++;
		}
		if(bean.getIsFinish() != null) {
			dao.setConditionIsFinish("=", bean.getIsFinish());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseRevenueYearRecord bean = new BaseRevenueYearRecord();
		bean.setDataFromJSON(json);
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseRevenueYearRecord> rlist = new BaseCollection<>();
		BaseRevenueYearRecord bean = new BaseRevenueYearRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		RevenueYearRecord dao = new RevenueYearRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseRevenueYearRecord> result = dao.conditionalLoad(addtion);
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
		BaseRevenueYearRecord bean = new BaseRevenueYearRecord();
		bean.setDataFromJSON(json);
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseRevenueYearRecord bean = new BaseRevenueYearRecord();
		bean.setDataFromJSON(json);
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseRevenueYearRecord bean = new BaseRevenueYearRecord();
		bean.setDataFromJSON(json);
		RevenueYearRecord dao = new RevenueYearRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseRevenueYearRecord bean = new BaseRevenueYearRecord();
		bean.setDataFromJSON(json);
		RevenueYearRecord dao = new RevenueYearRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



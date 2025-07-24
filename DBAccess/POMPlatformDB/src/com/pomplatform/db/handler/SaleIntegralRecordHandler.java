package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSaleIntegralRecord;
import com.pomplatform.db.dao.SaleIntegralRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SaleIntegralRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SaleIntegralRecordHandler.class);

	public static BaseSaleIntegralRecord getSaleIntegralRecordById( 
		java.lang.Integer sale_integral_record_id
	) throws Exception
	{
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setSaleIntegralRecordId(sale_integral_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSaleIntegralRecordExists( com.pomplatform.db.bean.BaseSaleIntegralRecord bean, String additional ) throws Exception {

		SaleIntegralRecord dao = new SaleIntegralRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSaleIntegralRecord( com.pomplatform.db.bean.BaseSaleIntegralRecord bean, String additional ) throws Exception {

		SaleIntegralRecord dao = new SaleIntegralRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSaleIntegralRecord> querySaleIntegralRecord( com.pomplatform.db.bean.BaseSaleIntegralRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SaleIntegralRecord dao = new SaleIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSaleIntegralRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSaleIntegralRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSaleIntegralRecord addToSaleIntegralRecord ( BaseSaleIntegralRecord saleintegralrecord )  throws Exception {
		return addToSaleIntegralRecord ( saleintegralrecord , false);
	}

	public static BaseSaleIntegralRecord addToSaleIntegralRecord ( BaseSaleIntegralRecord saleintegralrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setDataFromBase(saleintegralrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSaleIntegralRecord addUpdateSaleIntegralRecord ( BaseSaleIntegralRecord saleintegralrecord ) throws Exception {
		return addUpdateSaleIntegralRecord ( saleintegralrecord , false);
	}

	public static BaseSaleIntegralRecord addUpdateSaleIntegralRecord ( BaseSaleIntegralRecord saleintegralrecord, boolean singleTransaction  ) throws Exception {
		if(saleintegralrecord.getSaleIntegralRecordId() == null) return addToSaleIntegralRecord(saleintegralrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setDataFromBase(saleintegralrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(saleintegralrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSaleIntegralRecord ( BaseSaleIntegralRecord bean ) throws Exception {
		SaleIntegralRecord dao = new SaleIntegralRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSaleIntegralRecord updateSaleIntegralRecord ( BaseSaleIntegralRecord saleintegralrecord ) throws Exception {
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setSaleIntegralRecordId( saleintegralrecord.getSaleIntegralRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(saleintegralrecord);
			result = dao.update();
		}
		return result == 1 ? saleintegralrecord : null ;
	}

	public static BaseSaleIntegralRecord updateSaleIntegralRecordDirect( BaseSaleIntegralRecord saleintegralrecord ) throws Exception {
		SaleIntegralRecord dao = new SaleIntegralRecord();
		int result = 0;
		dao.setDataFromBase(saleintegralrecord);
		result = dao.update();
		return result == 1 ? saleintegralrecord : null ;
	}

	public static int setDeleteConditions(BaseSaleIntegralRecord bean, SaleIntegralRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSaleIntegralRecordId() != null) {
			dao.setConditionSaleIntegralRecordId("=", bean.getSaleIntegralRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessName() != null) {
				dao.setConditionBusinessName("=", bean.getBusinessName());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
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
		}
		return count;
	}

	public static int setConditions(BaseSaleIntegralRecord bean, SaleIntegralRecord dao){
		int count = 0;
		if(bean.getSaleIntegralRecordId() != null) {
			dao.setConditionSaleIntegralRecordId("=", bean.getSaleIntegralRecordId());
			count++;
		}
		if(bean.getBusinessName() != null) {
			if(bean.getBusinessName().indexOf("%") >= 0)
				dao.setConditionBusinessName("like", bean.getBusinessName());
			else
				dao.setConditionBusinessName("=", bean.getBusinessName());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getCurrentRevenue() != null) {
			dao.setConditionCurrentRevenue("=", bean.getCurrentRevenue());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getSaleIntegral() != null) {
			dao.setConditionSaleIntegral("=", bean.getSaleIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSaleIntegralRecord bean = new BaseSaleIntegralRecord();
		bean.setDataFromJSON(json);
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSaleIntegralRecord> rlist = new BaseCollection<>();
		BaseSaleIntegralRecord bean = new BaseSaleIntegralRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SaleIntegralRecord dao = new SaleIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSaleIntegralRecord> result = dao.conditionalLoad(addtion);
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
		BaseSaleIntegralRecord bean = new BaseSaleIntegralRecord();
		bean.setDataFromJSON(json);
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSaleIntegralRecord bean = new BaseSaleIntegralRecord();
		bean.setDataFromJSON(json);
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSaleIntegralRecord bean = new BaseSaleIntegralRecord();
		bean.setDataFromJSON(json);
		SaleIntegralRecord dao = new SaleIntegralRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSaleIntegralRecord bean = new BaseSaleIntegralRecord();
		bean.setDataFromJSON(json);
		SaleIntegralRecord dao = new SaleIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



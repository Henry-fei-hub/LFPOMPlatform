package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierInfoChangeRecord;
import com.pomplatform.db.dao.SupplierInfoChangeRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierInfoChangeRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierInfoChangeRecordHandler.class);

	public static BaseSupplierInfoChangeRecord getSupplierInfoChangeRecordById( 
		java.lang.Integer supplier_info_change_record_id
	) throws Exception
	{
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setSupplierInfoChangeRecordId(supplier_info_change_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierInfoChangeRecordExists( com.pomplatform.db.bean.BaseSupplierInfoChangeRecord bean, String additional ) throws Exception {

		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierInfoChangeRecord( com.pomplatform.db.bean.BaseSupplierInfoChangeRecord bean, String additional ) throws Exception {

		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierInfoChangeRecord> querySupplierInfoChangeRecord( com.pomplatform.db.bean.BaseSupplierInfoChangeRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierInfoChangeRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierInfoChangeRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierInfoChangeRecord addToSupplierInfoChangeRecord ( BaseSupplierInfoChangeRecord supplierinfochangerecord )  throws Exception {
		return addToSupplierInfoChangeRecord ( supplierinfochangerecord , false);
	}

	public static BaseSupplierInfoChangeRecord addToSupplierInfoChangeRecord ( BaseSupplierInfoChangeRecord supplierinfochangerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setDataFromBase(supplierinfochangerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierInfoChangeRecord addUpdateSupplierInfoChangeRecord ( BaseSupplierInfoChangeRecord supplierinfochangerecord ) throws Exception {
		return addUpdateSupplierInfoChangeRecord ( supplierinfochangerecord , false);
	}

	public static BaseSupplierInfoChangeRecord addUpdateSupplierInfoChangeRecord ( BaseSupplierInfoChangeRecord supplierinfochangerecord, boolean singleTransaction  ) throws Exception {
		if(supplierinfochangerecord.getSupplierInfoChangeRecordId() == null) return addToSupplierInfoChangeRecord(supplierinfochangerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setDataFromBase(supplierinfochangerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(supplierinfochangerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierInfoChangeRecord ( BaseSupplierInfoChangeRecord bean ) throws Exception {
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierInfoChangeRecord updateSupplierInfoChangeRecord ( BaseSupplierInfoChangeRecord supplierinfochangerecord ) throws Exception {
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setSupplierInfoChangeRecordId( supplierinfochangerecord.getSupplierInfoChangeRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(supplierinfochangerecord);
			result = dao.update();
		}
		return result == 1 ? supplierinfochangerecord : null ;
	}

	public static BaseSupplierInfoChangeRecord updateSupplierInfoChangeRecordDirect( BaseSupplierInfoChangeRecord supplierinfochangerecord ) throws Exception {
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		int result = 0;
		dao.setDataFromBase(supplierinfochangerecord);
		result = dao.update();
		return result == 1 ? supplierinfochangerecord : null ;
	}

	public static int setDeleteConditions(BaseSupplierInfoChangeRecord bean, SupplierInfoChangeRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierInfoChangeRecordId() != null) {
			dao.setConditionSupplierInfoChangeRecordId("=", bean.getSupplierInfoChangeRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getChangeContent() != null) {
				dao.setConditionChangeContent("=", bean.getChangeContent());
				count++;
			}
			if(bean.getChangeEmployeeId() != null) {
				dao.setConditionChangeEmployeeId("=", bean.getChangeEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplierInfoChangeRecord bean, SupplierInfoChangeRecord dao){
		int count = 0;
		if(bean.getSupplierInfoChangeRecordId() != null) {
			dao.setConditionSupplierInfoChangeRecordId("=", bean.getSupplierInfoChangeRecordId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getChangeContent() != null) {
			if(bean.getChangeContent().indexOf("%") >= 0)
				dao.setConditionChangeContent("like", bean.getChangeContent());
			else
				dao.setConditionChangeContent("=", bean.getChangeContent());
			count++;
		}
		if(bean.getChangeEmployeeId() != null) {
			dao.setConditionChangeEmployeeId("=", bean.getChangeEmployeeId());
			count++;
		}
		if(bean.getChangeDate() != null) {
			dao.setConditionChangeDate(">=", bean.getChangeDate());
			count++;
		}
		if(bean.getChangeTime() != null) {
			dao.setConditionChangeTime(">=", bean.getChangeTime());
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
		BaseSupplierInfoChangeRecord bean = new BaseSupplierInfoChangeRecord();
		bean.setDataFromJSON(json);
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierInfoChangeRecord> rlist = new BaseCollection<>();
		BaseSupplierInfoChangeRecord bean = new BaseSupplierInfoChangeRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierInfoChangeRecord> result = dao.conditionalLoad(addtion);
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
		BaseSupplierInfoChangeRecord bean = new BaseSupplierInfoChangeRecord();
		bean.setDataFromJSON(json);
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierInfoChangeRecord bean = new BaseSupplierInfoChangeRecord();
		bean.setDataFromJSON(json);
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierInfoChangeRecord bean = new BaseSupplierInfoChangeRecord();
		bean.setDataFromJSON(json);
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierInfoChangeRecord bean = new BaseSupplierInfoChangeRecord();
		bean.setDataFromJSON(json);
		SupplierInfoChangeRecord dao = new SupplierInfoChangeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



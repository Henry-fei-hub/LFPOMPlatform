package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseEquipmentRecord;
import java.util.List;
import com.pomplatform.db.dao.EquipmentRecord;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class EquipmentRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EquipmentRecordHandler.class);

	public static BaseEquipmentRecord getEquipmentRecordById( 

	) throws Exception
	{
		EquipmentRecord dao = new EquipmentRecord();
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEquipmentRecordExists( com.pomplatform.db.bean.BaseEquipmentRecord bean, String additional ) throws Exception {

		EquipmentRecord dao = new EquipmentRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEquipmentRecord( com.pomplatform.db.bean.BaseEquipmentRecord bean, String additional ) throws Exception {

		EquipmentRecord dao = new EquipmentRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEquipmentRecord> queryEquipmentRecord( com.pomplatform.db.bean.BaseEquipmentRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EquipmentRecord dao = new EquipmentRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEquipmentRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEquipmentRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEquipmentRecord addToEquipmentRecord ( BaseEquipmentRecord equipmentrecord )  throws Exception {
		return addToEquipmentRecord ( equipmentrecord , false);
	}

	public static BaseEquipmentRecord addToEquipmentRecord ( BaseEquipmentRecord equipmentrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EquipmentRecord dao = new EquipmentRecord();
		dao.setDataFromBase(equipmentrecord);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEquipmentRecord addUpdateEquipmentRecord ( BaseEquipmentRecord equipmentrecord ) throws Exception {
		return addUpdateEquipmentRecord ( equipmentrecord , false);
	}

	public static BaseEquipmentRecord addUpdateEquipmentRecord ( BaseEquipmentRecord equipmentrecord, boolean singleTransaction  ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EquipmentRecord dao = new EquipmentRecord();
		dao.setDataFromBase(equipmentrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(equipmentrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEquipmentRecord ( BaseEquipmentRecord bean ) throws Exception {
		EquipmentRecord dao = new EquipmentRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEquipmentRecord updateEquipmentRecord ( BaseEquipmentRecord equipmentrecord ) throws Exception {
		EquipmentRecord dao = new EquipmentRecord();
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(equipmentrecord);
			result = dao.update();
		}
		return result == 1 ? equipmentrecord : null ;
	}

	public static BaseEquipmentRecord updateEquipmentRecordDirect( BaseEquipmentRecord equipmentrecord ) throws Exception {
		EquipmentRecord dao = new EquipmentRecord();
		int result = 0;
		dao.setDataFromBase(equipmentrecord);
		result = dao.update();
		return result == 1 ? equipmentrecord : null ;
	}

	public static int setDeleteConditions(BaseEquipmentRecord bean, EquipmentRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(!foundKey) {
			if(bean.getOperationType() != null) {
				dao.setConditionOperationType("=", bean.getOperationType());
				count++;
			}
			if(bean.getCount() != null) {
				dao.setConditionCount("=", bean.getCount());
				count++;
			}
			if(bean.getFollowStatus() != null) {
				dao.setConditionFollowStatus("=", bean.getFollowStatus());
				count++;
			}
			if(bean.getOperationPerson() != null) {
				dao.setConditionOperationPerson("=", bean.getOperationPerson());
				count++;
			}
			if(bean.getEquipmentId() != null) {
				dao.setConditionEquipmentId("=", bean.getEquipmentId());
				count++;
			}
			if(bean.getFollowId() != null) {
				dao.setConditionFollowId("=", bean.getFollowId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEquipmentRecord bean, EquipmentRecord dao){
		int count = 0;
		if(bean.getOperationType() != null) {
			dao.setConditionOperationType("=", bean.getOperationType());
			count++;
		}
		if(bean.getCount() != null) {
			dao.setConditionCount("=", bean.getCount());
			count++;
		}
		if(bean.getFollowStatus() != null) {
			dao.setConditionFollowStatus("=", bean.getFollowStatus());
			count++;
		}
		if(bean.getOperationPerson() != null) {
			dao.setConditionOperationPerson("=", bean.getOperationPerson());
			count++;
		}
		if(bean.getOperationTime() != null) {
			dao.setConditionOperationTime(">=", bean.getOperationTime());
			count++;
		}
		if(bean.getEquipmentId() != null) {
			dao.setConditionEquipmentId("=", bean.getEquipmentId());
			count++;
		}
		if(bean.getFollowId() != null) {
			dao.setConditionFollowId("=", bean.getFollowId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEquipmentRecord bean = new BaseEquipmentRecord();
		bean.setDataFromJSON(json);
		EquipmentRecord dao = new EquipmentRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEquipmentRecord> rlist = new BaseCollection<>();
		BaseEquipmentRecord bean = new BaseEquipmentRecord();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EquipmentRecord dao = new EquipmentRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEquipmentRecord> result = dao.conditionalLoad(addtion);
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
		BaseEquipmentRecord bean = new BaseEquipmentRecord();
		bean.setDataFromJSON(json);
		EquipmentRecord dao = new EquipmentRecord();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEquipmentRecord bean = new BaseEquipmentRecord();
		bean.setDataFromJSON(json);
		EquipmentRecord dao = new EquipmentRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEquipmentRecord bean = new BaseEquipmentRecord();
		bean.setDataFromJSON(json);
		EquipmentRecord dao = new EquipmentRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEquipmentRecord bean = new BaseEquipmentRecord();
		bean.setDataFromJSON(json);
		EquipmentRecord dao = new EquipmentRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



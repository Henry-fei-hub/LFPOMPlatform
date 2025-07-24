package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseStorageArea;
import com.pomplatform.db.dao.StorageArea;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class StorageAreaHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StorageAreaHandler.class);

	public static BaseStorageArea getStorageAreaById( 
		java.lang.Integer storage_area_id
	) throws Exception
	{
		StorageArea dao = new StorageArea();
		dao.setStorageAreaId(storage_area_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStorageAreaExists( com.pomplatform.db.bean.BaseStorageArea bean, String additional ) throws Exception {

		StorageArea dao = new StorageArea();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStorageArea( com.pomplatform.db.bean.BaseStorageArea bean, String additional ) throws Exception {

		StorageArea dao = new StorageArea();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStorageArea> queryStorageArea( com.pomplatform.db.bean.BaseStorageArea bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		StorageArea dao = new StorageArea();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStorageArea> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStorageArea> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStorageArea addToStorageArea ( BaseStorageArea storagearea )  throws Exception {
		return addToStorageArea ( storagearea , false);
	}

	public static BaseStorageArea addToStorageArea ( BaseStorageArea storagearea, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StorageArea dao = new StorageArea();
		dao.setDataFromBase(storagearea);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStorageArea addUpdateStorageArea ( BaseStorageArea storagearea ) throws Exception {
		return addUpdateStorageArea ( storagearea , false);
	}

	public static BaseStorageArea addUpdateStorageArea ( BaseStorageArea storagearea, boolean singleTransaction  ) throws Exception {
		if(storagearea.getStorageAreaId() == null) return addToStorageArea(storagearea);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		StorageArea dao = new StorageArea();
		dao.setDataFromBase(storagearea);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(storagearea); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStorageArea ( BaseStorageArea bean ) throws Exception {
		StorageArea dao = new StorageArea();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStorageArea updateStorageArea ( BaseStorageArea storagearea ) throws Exception {
		StorageArea dao = new StorageArea();
		dao.setStorageAreaId( storagearea.getStorageAreaId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(storagearea);
			result = dao.update();
		}
		return result == 1 ? storagearea : null ;
	}

	public static BaseStorageArea updateStorageAreaDirect( BaseStorageArea storagearea ) throws Exception {
		StorageArea dao = new StorageArea();
		int result = 0;
		dao.setDataFromBase(storagearea);
		result = dao.update();
		return result == 1 ? storagearea : null ;
	}

	public static int setDeleteConditions(BaseStorageArea bean, StorageArea dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStorageAreaId() != null) {
			dao.setConditionStorageAreaId("=", bean.getStorageAreaId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAreaCode() != null) {
				dao.setConditionAreaCode("=", bean.getAreaCode());
				count++;
			}
			if(bean.getAreaName() != null) {
				dao.setConditionAreaName("=", bean.getAreaName());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStorageArea bean, StorageArea dao){
		int count = 0;
		if(bean.getStorageAreaId() != null) {
			dao.setConditionStorageAreaId("=", bean.getStorageAreaId());
			count++;
		}
		if(bean.getAreaCode() != null) {
			if(bean.getAreaCode().indexOf("%") >= 0)
				dao.setConditionAreaCode("like", bean.getAreaCode());
			else
				dao.setConditionAreaCode("=", bean.getAreaCode());
			count++;
		}
		if(bean.getAreaName() != null) {
			if(bean.getAreaName().indexOf("%") >= 0)
				dao.setConditionAreaName("like", bean.getAreaName());
			else
				dao.setConditionAreaName("=", bean.getAreaName());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
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
		BaseStorageArea bean = new BaseStorageArea();
		bean.setDataFromJSON(json);
		StorageArea dao = new StorageArea();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStorageArea> rlist = new BaseCollection<>();
		BaseStorageArea bean = new BaseStorageArea();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		StorageArea dao = new StorageArea();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStorageArea> result = dao.conditionalLoad(addtion);
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
		BaseStorageArea bean = new BaseStorageArea();
		bean.setDataFromJSON(json);
		StorageArea dao = new StorageArea();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStorageArea bean = new BaseStorageArea();
		bean.setDataFromJSON(json);
		StorageArea dao = new StorageArea();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStorageArea bean = new BaseStorageArea();
		bean.setDataFromJSON(json);
		StorageArea dao = new StorageArea();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStorageArea bean = new BaseStorageArea();
		bean.setDataFromJSON(json);
		StorageArea dao = new StorageArea();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



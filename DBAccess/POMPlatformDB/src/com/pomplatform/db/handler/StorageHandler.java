package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseStorage;
import com.pomplatform.db.dao.Storage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class StorageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StorageHandler.class);

	public static BaseStorage getStorageById( 
		java.lang.Integer storage_id
	) throws Exception
	{
		Storage dao = new Storage();
		dao.setStorageId(storage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStorageExists( com.pomplatform.db.bean.BaseStorage bean, String additional ) throws Exception {

		Storage dao = new Storage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStorage( com.pomplatform.db.bean.BaseStorage bean, String additional ) throws Exception {

		Storage dao = new Storage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStorage> queryStorage( com.pomplatform.db.bean.BaseStorage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Storage dao = new Storage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStorage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStorage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStorage addToStorage ( BaseStorage storage )  throws Exception {
		return addToStorage ( storage , false);
	}

	public static BaseStorage addToStorage ( BaseStorage storage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Storage dao = new Storage();
		dao.setDataFromBase(storage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStorage addUpdateStorage ( BaseStorage storage ) throws Exception {
		return addUpdateStorage ( storage , false);
	}

	public static BaseStorage addUpdateStorage ( BaseStorage storage, boolean singleTransaction  ) throws Exception {
		if(storage.getStorageId() == null) return addToStorage(storage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Storage dao = new Storage();
		dao.setDataFromBase(storage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(storage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStorage ( BaseStorage bean ) throws Exception {
		Storage dao = new Storage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStorage updateStorage ( BaseStorage storage ) throws Exception {
		Storage dao = new Storage();
		dao.setStorageId( storage.getStorageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(storage);
			result = dao.update();
		}
		return result == 1 ? storage : null ;
	}

	public static BaseStorage updateStorageDirect( BaseStorage storage ) throws Exception {
		Storage dao = new Storage();
		int result = 0;
		dao.setDataFromBase(storage);
		result = dao.update();
		return result == 1 ? storage : null ;
	}

	public static int setDeleteConditions(BaseStorage bean, Storage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStorageId() != null) {
			dao.setConditionStorageId("=", bean.getStorageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getStorageCode() != null) {
				dao.setConditionStorageCode("=", bean.getStorageCode());
				count++;
			}
			if(bean.getStorageName() != null) {
				dao.setConditionStorageName("=", bean.getStorageName());
				count++;
			}
			if(bean.getStorageType() != null) {
				dao.setConditionStorageType("=", bean.getStorageType());
				count++;
			}
			if(bean.getStorageAreaId() != null) {
				dao.setConditionStorageAreaId("=", bean.getStorageAreaId());
				count++;
			}
			if(bean.getCountry() != null) {
				dao.setConditionCountry("=", bean.getCountry());
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
			if(bean.getAddress() != null) {
				dao.setConditionAddress("=", bean.getAddress());
				count++;
			}
			if(bean.getContactEmployeeId() != null) {
				dao.setConditionContactEmployeeId("=", bean.getContactEmployeeId());
				count++;
			}
			if(bean.getContactPhone() != null) {
				dao.setConditionContactPhone("=", bean.getContactPhone());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStorage bean, Storage dao){
		int count = 0;
		if(bean.getStorageId() != null) {
			dao.setConditionStorageId("=", bean.getStorageId());
			count++;
		}
		if(bean.getStorageCode() != null) {
			if(bean.getStorageCode().indexOf("%") >= 0)
				dao.setConditionStorageCode("like", bean.getStorageCode());
			else
				dao.setConditionStorageCode("=", bean.getStorageCode());
			count++;
		}
		if(bean.getStorageName() != null) {
			if(bean.getStorageName().indexOf("%") >= 0)
				dao.setConditionStorageName("like", bean.getStorageName());
			else
				dao.setConditionStorageName("=", bean.getStorageName());
			count++;
		}
		if(bean.getStorageType() != null) {
			dao.setConditionStorageType("=", bean.getStorageType());
			count++;
		}
		if(bean.getStorageAreaId() != null) {
			dao.setConditionStorageAreaId("=", bean.getStorageAreaId());
			count++;
		}
		if(bean.getCountry() != null) {
			dao.setConditionCountry("=", bean.getCountry());
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
		if(bean.getAddress() != null) {
			if(bean.getAddress().indexOf("%") >= 0)
				dao.setConditionAddress("like", bean.getAddress());
			else
				dao.setConditionAddress("=", bean.getAddress());
			count++;
		}
		if(bean.getContactEmployeeId() != null) {
			dao.setConditionContactEmployeeId("=", bean.getContactEmployeeId());
			count++;
		}
		if(bean.getContactPhone() != null) {
			if(bean.getContactPhone().indexOf("%") >= 0)
				dao.setConditionContactPhone("like", bean.getContactPhone());
			else
				dao.setConditionContactPhone("=", bean.getContactPhone());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
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
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
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
		BaseStorage bean = new BaseStorage();
		bean.setDataFromJSON(json);
		Storage dao = new Storage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStorage> rlist = new BaseCollection<>();
		BaseStorage bean = new BaseStorage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Storage dao = new Storage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStorage> result = dao.conditionalLoad(addtion);
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
		BaseStorage bean = new BaseStorage();
		bean.setDataFromJSON(json);
		Storage dao = new Storage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStorage bean = new BaseStorage();
		bean.setDataFromJSON(json);
		Storage dao = new Storage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStorage bean = new BaseStorage();
		bean.setDataFromJSON(json);
		Storage dao = new Storage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStorage bean = new BaseStorage();
		bean.setDataFromJSON(json);
		Storage dao = new Storage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



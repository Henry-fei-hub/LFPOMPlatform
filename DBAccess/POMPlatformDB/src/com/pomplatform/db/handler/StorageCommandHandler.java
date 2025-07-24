package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseStorageCommand;
import com.pomplatform.db.dao.StorageCommand;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class StorageCommandHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(StorageCommandHandler.class);

	public static BaseStorageCommand getStorageCommandById( 
		java.lang.Integer storage_command_id
	) throws Exception
	{
		StorageCommand dao = new StorageCommand();
		dao.setStorageCommandId(storage_command_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isStorageCommandExists( com.pomplatform.db.bean.BaseStorageCommand bean, String additional ) throws Exception {

		StorageCommand dao = new StorageCommand();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countStorageCommand( com.pomplatform.db.bean.BaseStorageCommand bean, String additional ) throws Exception {

		StorageCommand dao = new StorageCommand();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseStorageCommand> queryStorageCommand( com.pomplatform.db.bean.BaseStorageCommand bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		StorageCommand dao = new StorageCommand();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseStorageCommand> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseStorageCommand> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseStorageCommand addToStorageCommand ( BaseStorageCommand storagecommand )  throws Exception {
		return addToStorageCommand ( storagecommand , false);
	}

	public static BaseStorageCommand addToStorageCommand ( BaseStorageCommand storagecommand, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StorageCommand dao = new StorageCommand();
		dao.setDataFromBase(storagecommand);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseStorageCommand addUpdateStorageCommand ( BaseStorageCommand storagecommand ) throws Exception {
		return addUpdateStorageCommand ( storagecommand , false);
	}

	public static BaseStorageCommand addUpdateStorageCommand ( BaseStorageCommand storagecommand, boolean singleTransaction  ) throws Exception {
		if(storagecommand.getStorageCommandId() == null) return addToStorageCommand(storagecommand);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		StorageCommand dao = new StorageCommand();
		dao.setDataFromBase(storagecommand);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(storagecommand); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteStorageCommand ( BaseStorageCommand bean ) throws Exception {
		StorageCommand dao = new StorageCommand();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseStorageCommand updateStorageCommand ( BaseStorageCommand storagecommand ) throws Exception {
		StorageCommand dao = new StorageCommand();
		dao.setStorageCommandId( storagecommand.getStorageCommandId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(storagecommand);
			result = dao.update();
		}
		return result == 1 ? storagecommand : null ;
	}

	public static BaseStorageCommand updateStorageCommandDirect( BaseStorageCommand storagecommand ) throws Exception {
		StorageCommand dao = new StorageCommand();
		int result = 0;
		dao.setDataFromBase(storagecommand);
		result = dao.update();
		return result == 1 ? storagecommand : null ;
	}

	public static int setDeleteConditions(BaseStorageCommand bean, StorageCommand dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getStorageCommandId() != null) {
			dao.setConditionStorageCommandId("=", bean.getStorageCommandId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCommandType() != null) {
				dao.setConditionCommandType("=", bean.getCommandType());
				count++;
			}
			if(bean.getWorkplaceId() != null) {
				dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getCopyType() != null) {
				dao.setConditionCopyType("=", bean.getCopyType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseStorageCommand bean, StorageCommand dao){
		int count = 0;
		if(bean.getStorageCommandId() != null) {
			dao.setConditionStorageCommandId("=", bean.getStorageCommandId());
			count++;
		}
		if(bean.getCommandType() != null) {
			dao.setConditionCommandType("=", bean.getCommandType());
			count++;
		}
		if(bean.getWorkplaceId() != null) {
			dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getCompleteTime() != null) {
			dao.setConditionCompleteTime(">=", bean.getCompleteTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getCopyType() != null) {
			dao.setConditionCopyType("=", bean.getCopyType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseStorageCommand bean = new BaseStorageCommand();
		bean.setDataFromJSON(json);
		StorageCommand dao = new StorageCommand();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseStorageCommand> rlist = new BaseCollection<>();
		BaseStorageCommand bean = new BaseStorageCommand();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		StorageCommand dao = new StorageCommand();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseStorageCommand> result = dao.conditionalLoad(addtion);
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
		BaseStorageCommand bean = new BaseStorageCommand();
		bean.setDataFromJSON(json);
		StorageCommand dao = new StorageCommand();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseStorageCommand bean = new BaseStorageCommand();
		bean.setDataFromJSON(json);
		StorageCommand dao = new StorageCommand();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseStorageCommand bean = new BaseStorageCommand();
		bean.setDataFromJSON(json);
		StorageCommand dao = new StorageCommand();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseStorageCommand bean = new BaseStorageCommand();
		bean.setDataFromJSON(json);
		StorageCommand dao = new StorageCommand();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



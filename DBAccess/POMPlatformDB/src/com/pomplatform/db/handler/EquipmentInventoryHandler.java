package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEquipmentInventory;
import com.pomplatform.db.dao.EquipmentInventory;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EquipmentInventoryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EquipmentInventoryHandler.class);

	public static BaseEquipmentInventory getEquipmentInventoryById( 
		java.lang.Integer equipment_inventory_id
	) throws Exception
	{
		EquipmentInventory dao = new EquipmentInventory();
		dao.setEquipmentInventoryId(equipment_inventory_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEquipmentInventoryExists( com.pomplatform.db.bean.BaseEquipmentInventory bean, String additional ) throws Exception {

		EquipmentInventory dao = new EquipmentInventory();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEquipmentInventory( com.pomplatform.db.bean.BaseEquipmentInventory bean, String additional ) throws Exception {

		EquipmentInventory dao = new EquipmentInventory();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEquipmentInventory> queryEquipmentInventory( com.pomplatform.db.bean.BaseEquipmentInventory bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EquipmentInventory dao = new EquipmentInventory();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEquipmentInventory> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEquipmentInventory> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEquipmentInventory addToEquipmentInventory ( BaseEquipmentInventory equipmentinventory )  throws Exception {
		return addToEquipmentInventory ( equipmentinventory , false);
	}

	public static BaseEquipmentInventory addToEquipmentInventory ( BaseEquipmentInventory equipmentinventory, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EquipmentInventory dao = new EquipmentInventory();
		dao.setDataFromBase(equipmentinventory);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEquipmentInventory addUpdateEquipmentInventory ( BaseEquipmentInventory equipmentinventory ) throws Exception {
		return addUpdateEquipmentInventory ( equipmentinventory , false);
	}

	public static BaseEquipmentInventory addUpdateEquipmentInventory ( BaseEquipmentInventory equipmentinventory, boolean singleTransaction  ) throws Exception {
		if(equipmentinventory.getEquipmentInventoryId() == null) return addToEquipmentInventory(equipmentinventory);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EquipmentInventory dao = new EquipmentInventory();
		dao.setDataFromBase(equipmentinventory);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(equipmentinventory); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEquipmentInventory ( BaseEquipmentInventory bean ) throws Exception {
		EquipmentInventory dao = new EquipmentInventory();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEquipmentInventory updateEquipmentInventory ( BaseEquipmentInventory equipmentinventory ) throws Exception {
		EquipmentInventory dao = new EquipmentInventory();
		dao.setEquipmentInventoryId( equipmentinventory.getEquipmentInventoryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(equipmentinventory);
			result = dao.update();
		}
		return result == 1 ? equipmentinventory : null ;
	}

	public static BaseEquipmentInventory updateEquipmentInventoryDirect( BaseEquipmentInventory equipmentinventory ) throws Exception {
		EquipmentInventory dao = new EquipmentInventory();
		int result = 0;
		dao.setDataFromBase(equipmentinventory);
		result = dao.update();
		return result == 1 ? equipmentinventory : null ;
	}

	public static int setDeleteConditions(BaseEquipmentInventory bean, EquipmentInventory dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEquipmentInventoryId() != null) {
			dao.setConditionEquipmentInventoryId("=", bean.getEquipmentInventoryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getAmount() != null) {
				dao.setConditionAmount("=", bean.getAmount());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEquipmentInventory bean, EquipmentInventory dao){
		int count = 0;
		if(bean.getEquipmentInventoryId() != null) {
			dao.setConditionEquipmentInventoryId("=", bean.getEquipmentInventoryId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getPrice() != null) {
			dao.setConditionPrice("=", bean.getPrice());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getInputDate() != null) {
			dao.setConditionInputDate(">=", bean.getInputDate());
			count++;
		}
		if(bean.getPullDate() != null) {
			dao.setConditionPullDate(">=", bean.getPullDate());
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
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEquipmentInventory bean = new BaseEquipmentInventory();
		bean.setDataFromJSON(json);
		EquipmentInventory dao = new EquipmentInventory();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEquipmentInventory> rlist = new BaseCollection<>();
		BaseEquipmentInventory bean = new BaseEquipmentInventory();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EquipmentInventory dao = new EquipmentInventory();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEquipmentInventory> result = dao.conditionalLoad(addtion);
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
		BaseEquipmentInventory bean = new BaseEquipmentInventory();
		bean.setDataFromJSON(json);
		EquipmentInventory dao = new EquipmentInventory();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEquipmentInventory bean = new BaseEquipmentInventory();
		bean.setDataFromJSON(json);
		EquipmentInventory dao = new EquipmentInventory();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEquipmentInventory bean = new BaseEquipmentInventory();
		bean.setDataFromJSON(json);
		EquipmentInventory dao = new EquipmentInventory();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEquipmentInventory bean = new BaseEquipmentInventory();
		bean.setDataFromJSON(json);
		EquipmentInventory dao = new EquipmentInventory();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



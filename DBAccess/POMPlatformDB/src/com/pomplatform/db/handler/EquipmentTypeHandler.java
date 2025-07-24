package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseEquipmentType;
import java.util.List;
import com.pomplatform.db.dao.EquipmentType;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class EquipmentTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EquipmentTypeHandler.class);

	public static BaseEquipmentType getEquipmentTypeById( 
		java.lang.Integer equipment_type_id
	) throws Exception
	{
		EquipmentType dao = new EquipmentType();
		dao.setEquipmentTypeId(equipment_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEquipmentTypeExists( com.pomplatform.db.bean.BaseEquipmentType bean, String additional ) throws Exception {

		EquipmentType dao = new EquipmentType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEquipmentType( com.pomplatform.db.bean.BaseEquipmentType bean, String additional ) throws Exception {

		EquipmentType dao = new EquipmentType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEquipmentType> queryEquipmentType( com.pomplatform.db.bean.BaseEquipmentType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EquipmentType dao = new EquipmentType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEquipmentType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEquipmentType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEquipmentType addToEquipmentType ( BaseEquipmentType equipmenttype )  throws Exception {
		return addToEquipmentType ( equipmenttype , false);
	}

	public static BaseEquipmentType addToEquipmentType ( BaseEquipmentType equipmenttype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EquipmentType dao = new EquipmentType();
		dao.setDataFromBase(equipmenttype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEquipmentType addUpdateEquipmentType ( BaseEquipmentType equipmenttype ) throws Exception {
		return addUpdateEquipmentType ( equipmenttype , false);
	}

	public static BaseEquipmentType addUpdateEquipmentType ( BaseEquipmentType equipmenttype, boolean singleTransaction  ) throws Exception {
		if(equipmenttype.getEquipmentTypeId() == null) return addToEquipmentType(equipmenttype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EquipmentType dao = new EquipmentType();
		dao.setDataFromBase(equipmenttype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(equipmenttype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEquipmentType ( BaseEquipmentType bean ) throws Exception {
		EquipmentType dao = new EquipmentType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEquipmentType updateEquipmentType ( BaseEquipmentType equipmenttype ) throws Exception {
		EquipmentType dao = new EquipmentType();
		dao.setEquipmentTypeId( equipmenttype.getEquipmentTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(equipmenttype);
			result = dao.update();
		}
		return result == 1 ? equipmenttype : null ;
	}

	public static BaseEquipmentType updateEquipmentTypeDirect( BaseEquipmentType equipmenttype ) throws Exception {
		EquipmentType dao = new EquipmentType();
		int result = 0;
		dao.setDataFromBase(equipmenttype);
		result = dao.update();
		return result == 1 ? equipmenttype : null ;
	}

	public static int setDeleteConditions(BaseEquipmentType bean, EquipmentType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEquipmentTypeId() != null) {
			dao.setConditionEquipmentTypeId("=", bean.getEquipmentTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getUpdatePerson() != null) {
				dao.setConditionUpdatePerson("=", bean.getUpdatePerson());
				count++;
			}
			if(bean.getCount() != null) {
				dao.setConditionCount("=", bean.getCount());
				count++;
			}
			if(bean.getIsDelete() != null) {
				dao.setConditionIsDelete("=", bean.getIsDelete());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEquipmentType bean, EquipmentType dao){
		int count = 0;
		if(bean.getEquipmentTypeId() != null) {
			dao.setConditionEquipmentTypeId("=", bean.getEquipmentTypeId());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		if(bean.getPrice() != null) {
			dao.setConditionPrice("=", bean.getPrice());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getUpdatePerson() != null) {
			dao.setConditionUpdatePerson("=", bean.getUpdatePerson());
			count++;
		}
		if(bean.getCount() != null) {
			dao.setConditionCount("=", bean.getCount());
			count++;
		}
		if(bean.getIsDelete() != null) {
			dao.setConditionIsDelete("=", bean.getIsDelete());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEquipmentType bean = new BaseEquipmentType();
		bean.setDataFromJSON(json);
		EquipmentType dao = new EquipmentType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEquipmentType> rlist = new BaseCollection<>();
		BaseEquipmentType bean = new BaseEquipmentType();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EquipmentType dao = new EquipmentType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEquipmentType> result = dao.conditionalLoad(addtion);
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
		BaseEquipmentType bean = new BaseEquipmentType();
		bean.setDataFromJSON(json);
		EquipmentType dao = new EquipmentType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEquipmentType bean = new BaseEquipmentType();
		bean.setDataFromJSON(json);
		EquipmentType dao = new EquipmentType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEquipmentType bean = new BaseEquipmentType();
		bean.setDataFromJSON(json);
		EquipmentType dao = new EquipmentType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEquipmentType bean = new BaseEquipmentType();
		bean.setDataFromJSON(json);
		EquipmentType dao = new EquipmentType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



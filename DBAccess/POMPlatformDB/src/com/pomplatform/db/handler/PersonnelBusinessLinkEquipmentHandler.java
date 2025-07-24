package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment;
import java.util.List;
import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class PersonnelBusinessLinkEquipmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PersonnelBusinessLinkEquipmentHandler.class);

	public static BasePersonnelBusinessLinkEquipment getPersonnelBusinessLinkEquipmentById( 
		java.lang.Integer personnel_business_link_equipment_id
	) throws Exception
	{
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setPersonnelBusinessLinkEquipmentId(personnel_business_link_equipment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPersonnelBusinessLinkEquipmentExists( com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment bean, String additional ) throws Exception {

		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPersonnelBusinessLinkEquipment( com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment bean, String additional ) throws Exception {

		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePersonnelBusinessLinkEquipment> queryPersonnelBusinessLinkEquipment( com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePersonnelBusinessLinkEquipment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePersonnelBusinessLinkEquipment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePersonnelBusinessLinkEquipment addToPersonnelBusinessLinkEquipment ( BasePersonnelBusinessLinkEquipment personnelbusinesslinkequipment )  throws Exception {
		return addToPersonnelBusinessLinkEquipment ( personnelbusinesslinkequipment , false);
	}

	public static BasePersonnelBusinessLinkEquipment addToPersonnelBusinessLinkEquipment ( BasePersonnelBusinessLinkEquipment personnelbusinesslinkequipment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setDataFromBase(personnelbusinesslinkequipment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePersonnelBusinessLinkEquipment addUpdatePersonnelBusinessLinkEquipment ( BasePersonnelBusinessLinkEquipment personnelbusinesslinkequipment ) throws Exception {
		return addUpdatePersonnelBusinessLinkEquipment ( personnelbusinesslinkequipment , false);
	}

	public static BasePersonnelBusinessLinkEquipment addUpdatePersonnelBusinessLinkEquipment ( BasePersonnelBusinessLinkEquipment personnelbusinesslinkequipment, boolean singleTransaction  ) throws Exception {
		if(personnelbusinesslinkequipment.getPersonnelBusinessLinkEquipmentId() == null) return addToPersonnelBusinessLinkEquipment(personnelbusinesslinkequipment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setDataFromBase(personnelbusinesslinkequipment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(personnelbusinesslinkequipment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePersonnelBusinessLinkEquipment ( BasePersonnelBusinessLinkEquipment bean ) throws Exception {
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePersonnelBusinessLinkEquipment updatePersonnelBusinessLinkEquipment ( BasePersonnelBusinessLinkEquipment personnelbusinesslinkequipment ) throws Exception {
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setPersonnelBusinessLinkEquipmentId( personnelbusinesslinkequipment.getPersonnelBusinessLinkEquipmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(personnelbusinesslinkequipment);
			result = dao.update();
		}
		return result == 1 ? personnelbusinesslinkequipment : null ;
	}

	public static BasePersonnelBusinessLinkEquipment updatePersonnelBusinessLinkEquipmentDirect( BasePersonnelBusinessLinkEquipment personnelbusinesslinkequipment ) throws Exception {
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		int result = 0;
		dao.setDataFromBase(personnelbusinesslinkequipment);
		result = dao.update();
		return result == 1 ? personnelbusinesslinkequipment : null ;
	}

	public static int setDeleteConditions(BasePersonnelBusinessLinkEquipment bean, PersonnelBusinessLinkEquipment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPersonnelBusinessLinkEquipmentId() != null) {
			dao.setConditionPersonnelBusinessLinkEquipmentId("=", bean.getPersonnelBusinessLinkEquipmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getAmount() != null) {
				dao.setConditionAmount("=", bean.getAmount());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsAllowed() != null) {
				dao.setConditionIsAllowed("=", bean.getIsAllowed());
				count++;
			}
			if(bean.getIsReturn() != null) {
				dao.setConditionIsReturn("=", bean.getIsReturn());
				count++;
			}
			if(bean.getReturnAmount() != null) {
				dao.setConditionReturnAmount("=", bean.getReturnAmount());
				count++;
			}
			if(bean.getRemainingReturn() != null) {
				dao.setConditionRemainingReturn("=", bean.getRemainingReturn());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePersonnelBusinessLinkEquipment bean, PersonnelBusinessLinkEquipment dao){
		int count = 0;
		if(bean.getPersonnelBusinessLinkEquipmentId() != null) {
			dao.setConditionPersonnelBusinessLinkEquipmentId("=", bean.getPersonnelBusinessLinkEquipmentId());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getPrice() != null) {
			dao.setConditionPrice("=", bean.getPrice());
			count++;
		}
		if(bean.getTotalPrice() != null) {
			dao.setConditionTotalPrice("=", bean.getTotalPrice());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIsAllowed() != null) {
			dao.setConditionIsAllowed("=", bean.getIsAllowed());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getIsReturn() != null) {
			dao.setConditionIsReturn("=", bean.getIsReturn());
			count++;
		}
		if(bean.getReturnAmount() != null) {
			dao.setConditionReturnAmount("=", bean.getReturnAmount());
			count++;
		}
		if(bean.getRemainingReturn() != null) {
			dao.setConditionRemainingReturn("=", bean.getRemainingReturn());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePersonnelBusinessLinkEquipment bean = new BasePersonnelBusinessLinkEquipment();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePersonnelBusinessLinkEquipment> rlist = new BaseCollection<>();
		BasePersonnelBusinessLinkEquipment bean = new BasePersonnelBusinessLinkEquipment();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePersonnelBusinessLinkEquipment> result = dao.conditionalLoad(addtion);
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
		BasePersonnelBusinessLinkEquipment bean = new BasePersonnelBusinessLinkEquipment();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePersonnelBusinessLinkEquipment bean = new BasePersonnelBusinessLinkEquipment();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePersonnelBusinessLinkEquipment bean = new BasePersonnelBusinessLinkEquipment();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePersonnelBusinessLinkEquipment bean = new BasePersonnelBusinessLinkEquipment();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkEquipment dao = new PersonnelBusinessLinkEquipment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



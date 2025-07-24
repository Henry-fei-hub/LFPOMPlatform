package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkReturn;
import java.util.List;
import com.pomplatform.db.dao.PersonnelBusinessLinkReturn;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class PersonnelBusinessLinkReturnHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PersonnelBusinessLinkReturnHandler.class);

	public static BasePersonnelBusinessLinkReturn getPersonnelBusinessLinkReturnById( 
		java.lang.Integer personnel_business_link_return_id
	) throws Exception
	{
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setPersonnelBusinessLinkReturnId(personnel_business_link_return_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPersonnelBusinessLinkReturnExists( com.pomplatform.db.bean.BasePersonnelBusinessLinkReturn bean, String additional ) throws Exception {

		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPersonnelBusinessLinkReturn( com.pomplatform.db.bean.BasePersonnelBusinessLinkReturn bean, String additional ) throws Exception {

		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePersonnelBusinessLinkReturn> queryPersonnelBusinessLinkReturn( com.pomplatform.db.bean.BasePersonnelBusinessLinkReturn bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePersonnelBusinessLinkReturn> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePersonnelBusinessLinkReturn> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePersonnelBusinessLinkReturn addToPersonnelBusinessLinkReturn ( BasePersonnelBusinessLinkReturn personnelbusinesslinkreturn )  throws Exception {
		return addToPersonnelBusinessLinkReturn ( personnelbusinesslinkreturn , false);
	}

	public static BasePersonnelBusinessLinkReturn addToPersonnelBusinessLinkReturn ( BasePersonnelBusinessLinkReturn personnelbusinesslinkreturn, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setDataFromBase(personnelbusinesslinkreturn);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePersonnelBusinessLinkReturn addUpdatePersonnelBusinessLinkReturn ( BasePersonnelBusinessLinkReturn personnelbusinesslinkreturn ) throws Exception {
		return addUpdatePersonnelBusinessLinkReturn ( personnelbusinesslinkreturn , false);
	}

	public static BasePersonnelBusinessLinkReturn addUpdatePersonnelBusinessLinkReturn ( BasePersonnelBusinessLinkReturn personnelbusinesslinkreturn, boolean singleTransaction  ) throws Exception {
		if(personnelbusinesslinkreturn.getPersonnelBusinessLinkReturnId() == null) return addToPersonnelBusinessLinkReturn(personnelbusinesslinkreturn);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setDataFromBase(personnelbusinesslinkreturn);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(personnelbusinesslinkreturn); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePersonnelBusinessLinkReturn ( BasePersonnelBusinessLinkReturn bean ) throws Exception {
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePersonnelBusinessLinkReturn updatePersonnelBusinessLinkReturn ( BasePersonnelBusinessLinkReturn personnelbusinesslinkreturn ) throws Exception {
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setPersonnelBusinessLinkReturnId( personnelbusinesslinkreturn.getPersonnelBusinessLinkReturnId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(personnelbusinesslinkreturn);
			result = dao.update();
		}
		return result == 1 ? personnelbusinesslinkreturn : null ;
	}

	public static BasePersonnelBusinessLinkReturn updatePersonnelBusinessLinkReturnDirect( BasePersonnelBusinessLinkReturn personnelbusinesslinkreturn ) throws Exception {
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		int result = 0;
		dao.setDataFromBase(personnelbusinesslinkreturn);
		result = dao.update();
		return result == 1 ? personnelbusinesslinkreturn : null ;
	}

	public static int setDeleteConditions(BasePersonnelBusinessLinkReturn bean, PersonnelBusinessLinkReturn dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPersonnelBusinessLinkReturnId() != null) {
			dao.setConditionPersonnelBusinessLinkReturnId("=", bean.getPersonnelBusinessLinkReturnId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getPersonnelBusinessLinkEquipmentId() != null) {
				dao.setConditionPersonnelBusinessLinkEquipmentId("=", bean.getPersonnelBusinessLinkEquipmentId());
				count++;
			}
			if(bean.getReturnAmount() != null) {
				dao.setConditionReturnAmount("=", bean.getReturnAmount());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePersonnelBusinessLinkReturn bean, PersonnelBusinessLinkReturn dao){
		int count = 0;
		if(bean.getPersonnelBusinessLinkReturnId() != null) {
			dao.setConditionPersonnelBusinessLinkReturnId("=", bean.getPersonnelBusinessLinkReturnId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getPersonnelBusinessLinkEquipmentId() != null) {
			dao.setConditionPersonnelBusinessLinkEquipmentId("=", bean.getPersonnelBusinessLinkEquipmentId());
			count++;
		}
		if(bean.getReturnAmount() != null) {
			dao.setConditionReturnAmount("=", bean.getReturnAmount());
			count++;
		}
		if(bean.getReturnTime() != null) {
			dao.setConditionReturnTime(">=", bean.getReturnTime());
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
		BasePersonnelBusinessLinkReturn bean = new BasePersonnelBusinessLinkReturn();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePersonnelBusinessLinkReturn> rlist = new BaseCollection<>();
		BasePersonnelBusinessLinkReturn bean = new BasePersonnelBusinessLinkReturn();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePersonnelBusinessLinkReturn> result = dao.conditionalLoad(addtion);
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
		BasePersonnelBusinessLinkReturn bean = new BasePersonnelBusinessLinkReturn();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePersonnelBusinessLinkReturn bean = new BasePersonnelBusinessLinkReturn();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePersonnelBusinessLinkReturn bean = new BasePersonnelBusinessLinkReturn();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePersonnelBusinessLinkReturn bean = new BasePersonnelBusinessLinkReturn();
		bean.setDataFromJSON(json);
		PersonnelBusinessLinkReturn dao = new PersonnelBusinessLinkReturn();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



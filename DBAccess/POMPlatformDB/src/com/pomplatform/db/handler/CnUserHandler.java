package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnUser;
import java.util.List;
import com.pomplatform.db.dao.CnUser;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnUserHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnUserHandler.class);

	public static BaseCnUser getCnUserById( 
		java.lang.Integer user_id
	) throws Exception
	{
		CnUser dao = new CnUser();
		dao.setUserId(user_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnUserExists( com.pomplatform.db.bean.BaseCnUser bean, String additional ) throws Exception {

		CnUser dao = new CnUser();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnUser( com.pomplatform.db.bean.BaseCnUser bean, String additional ) throws Exception {

		CnUser dao = new CnUser();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnUser> queryCnUser( com.pomplatform.db.bean.BaseCnUser bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnUser dao = new CnUser();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnUser> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnUser> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnUser addToCnUser ( BaseCnUser cnuser )  throws Exception {
		return addToCnUser ( cnuser , false);
	}

	public static BaseCnUser addToCnUser ( BaseCnUser cnuser, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnUser dao = new CnUser();
		dao.setDataFromBase(cnuser);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnUser addUpdateCnUser ( BaseCnUser cnuser ) throws Exception {
		return addUpdateCnUser ( cnuser , false);
	}

	public static BaseCnUser addUpdateCnUser ( BaseCnUser cnuser, boolean singleTransaction  ) throws Exception {
		if(cnuser.getUserId() == null) return addToCnUser(cnuser);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnUser dao = new CnUser();
		dao.setDataFromBase(cnuser);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnuser); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnUser ( BaseCnUser bean ) throws Exception {
		CnUser dao = new CnUser();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnUser updateCnUser ( BaseCnUser cnuser ) throws Exception {
		CnUser dao = new CnUser();
		dao.setUserId( cnuser.getUserId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnuser);
			result = dao.update();
		}
		return result == 1 ? cnuser : null ;
	}

	public static BaseCnUser updateCnUserDirect( BaseCnUser cnuser ) throws Exception {
		CnUser dao = new CnUser();
		int result = 0;
		dao.setDataFromBase(cnuser);
		result = dao.update();
		return result == 1 ? cnuser : null ;
	}

	public static int setDeleteConditions(BaseCnUser bean, CnUser dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getUserId() != null) {
			dao.setConditionUserId("=", bean.getUserId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getUserName() != null) {
				dao.setConditionUserName("=", bean.getUserName());
				count++;
			}
			if(bean.getUserPassword() != null) {
				dao.setConditionUserPassword("=", bean.getUserPassword());
				count++;
			}
			if(bean.getPhone() != null) {
				dao.setConditionPhone("=", bean.getPhone());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
			if(bean.getUserFileImage() != null) {
				dao.setConditionUserFileImage("=", bean.getUserFileImage());
				count++;
			}
			if(bean.getProfessionalTypeId() != null) {
				dao.setConditionProfessionalTypeId("=", bean.getProfessionalTypeId());
				count++;
			}
			if(bean.getUserAutograph() != null) {
				dao.setConditionUserAutograph("=", bean.getUserAutograph());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnUser bean, CnUser dao){
		int count = 0;
		if(bean.getUserId() != null) {
			dao.setConditionUserId("=", bean.getUserId());
			count++;
		}
		if(bean.getUserName() != null) {
			if(bean.getUserName().indexOf("%") >= 0)
				dao.setConditionUserName("like", bean.getUserName());
			else
				dao.setConditionUserName("=", bean.getUserName());
			count++;
		}
		if(bean.getUserPassword() != null) {
			if(bean.getUserPassword().indexOf("%") >= 0)
				dao.setConditionUserPassword("like", bean.getUserPassword());
			else
				dao.setConditionUserPassword("=", bean.getUserPassword());
			count++;
		}
		if(bean.getPhone() != null) {
			if(bean.getPhone().indexOf("%") >= 0)
				dao.setConditionPhone("like", bean.getPhone());
			else
				dao.setConditionPhone("=", bean.getPhone());
			count++;
		}
		if(bean.getOrganizationId() != null) {
			dao.setConditionOrganizationId("=", bean.getOrganizationId());
			count++;
		}
		if(bean.getUserFileImage() != null) {
			dao.setConditionUserFileImage("=", bean.getUserFileImage());
			count++;
		}
		if(bean.getProfessionalTypeId() != null) {
			dao.setConditionProfessionalTypeId("=", bean.getProfessionalTypeId());
			count++;
		}
		if(bean.getUserAutograph() != null) {
			if(bean.getUserAutograph().indexOf("%") >= 0)
				dao.setConditionUserAutograph("like", bean.getUserAutograph());
			else
				dao.setConditionUserAutograph("=", bean.getUserAutograph());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCnUser bean = new BaseCnUser();
		bean.setDataFromJSON(json);
		CnUser dao = new CnUser();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnUser> rlist = new BaseCollection<>();
		BaseCnUser bean = new BaseCnUser();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnUser dao = new CnUser();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnUser> result = dao.conditionalLoad(addtion);
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
		BaseCnUser bean = new BaseCnUser();
		bean.setDataFromJSON(json);
		CnUser dao = new CnUser();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnUser bean = new BaseCnUser();
		bean.setDataFromJSON(json);
		CnUser dao = new CnUser();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnUser bean = new BaseCnUser();
		bean.setDataFromJSON(json);
		CnUser dao = new CnUser();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnUser bean = new BaseCnUser();
		bean.setDataFromJSON(json);
		CnUser dao = new CnUser();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



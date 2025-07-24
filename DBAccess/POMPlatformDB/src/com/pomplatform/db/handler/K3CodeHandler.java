package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseK3Code;
import com.pomplatform.db.dao.K3Code;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class K3CodeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(K3CodeHandler.class);

	public static BaseK3Code getK3CodeById( 
		java.lang.Integer k3_code_id
	) throws Exception
	{
		K3Code dao = new K3Code();
		dao.setK3CodeId(k3_code_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isK3CodeExists( com.pomplatform.db.bean.BaseK3Code bean, String additional ) throws Exception {

		K3Code dao = new K3Code();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countK3Code( com.pomplatform.db.bean.BaseK3Code bean, String additional ) throws Exception {

		K3Code dao = new K3Code();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseK3Code> queryK3Code( com.pomplatform.db.bean.BaseK3Code bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		K3Code dao = new K3Code();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseK3Code> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseK3Code> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseK3Code addToK3Code ( BaseK3Code k3code )  throws Exception {
		return addToK3Code ( k3code , false);
	}

	public static BaseK3Code addToK3Code ( BaseK3Code k3code, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		K3Code dao = new K3Code();
		dao.setDataFromBase(k3code);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseK3Code addUpdateK3Code ( BaseK3Code k3code ) throws Exception {
		return addUpdateK3Code ( k3code , false);
	}

	public static BaseK3Code addUpdateK3Code ( BaseK3Code k3code, boolean singleTransaction  ) throws Exception {
		if(k3code.getK3CodeId() == null) return addToK3Code(k3code);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		K3Code dao = new K3Code();
		dao.setDataFromBase(k3code);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(k3code); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteK3Code ( BaseK3Code bean ) throws Exception {
		K3Code dao = new K3Code();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseK3Code updateK3Code ( BaseK3Code k3code ) throws Exception {
		K3Code dao = new K3Code();
		dao.setK3CodeId( k3code.getK3CodeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(k3code);
			result = dao.update();
		}
		return result == 1 ? k3code : null ;
	}

	public static BaseK3Code updateK3CodeDirect( BaseK3Code k3code ) throws Exception {
		K3Code dao = new K3Code();
		int result = 0;
		dao.setDataFromBase(k3code);
		result = dao.update();
		return result == 1 ? k3code : null ;
	}

	public static int setDeleteConditions(BaseK3Code bean, K3Code dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getK3CodeId() != null) {
			dao.setConditionK3CodeId("=", bean.getK3CodeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getK3Code() != null) {
				dao.setConditionK3Code("=", bean.getK3Code());
				count++;
			}
			if(bean.getK3Name() != null) {
				dao.setConditionK3Name("=", bean.getK3Name());
				count++;
			}
			if(bean.getDepartmentType() != null) {
				dao.setConditionDepartmentType("=", bean.getDepartmentType());
				count++;
			}
			if(bean.getAdditionalBusinessId() != null) {
				dao.setConditionAdditionalBusinessId("=", bean.getAdditionalBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseK3Code bean, K3Code dao){
		int count = 0;
		if(bean.getK3CodeId() != null) {
			dao.setConditionK3CodeId("=", bean.getK3CodeId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getK3Code() != null) {
			if(bean.getK3Code().indexOf("%") >= 0)
				dao.setConditionK3Code("like", bean.getK3Code());
			else
				dao.setConditionK3Code("=", bean.getK3Code());
			count++;
		}
		if(bean.getK3Name() != null) {
			if(bean.getK3Name().indexOf("%") >= 0)
				dao.setConditionK3Name("like", bean.getK3Name());
			else
				dao.setConditionK3Name("=", bean.getK3Name());
			count++;
		}
		if(bean.getDepartmentType() != null) {
			dao.setConditionDepartmentType("=", bean.getDepartmentType());
			count++;
		}
		if(bean.getAdditionalBusinessId() != null) {
			dao.setConditionAdditionalBusinessId("=", bean.getAdditionalBusinessId());
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
		BaseK3Code bean = new BaseK3Code();
		bean.setDataFromJSON(json);
		K3Code dao = new K3Code();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseK3Code> rlist = new BaseCollection<>();
		BaseK3Code bean = new BaseK3Code();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		K3Code dao = new K3Code();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseK3Code> result = dao.conditionalLoad(addtion);
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
		BaseK3Code bean = new BaseK3Code();
		bean.setDataFromJSON(json);
		K3Code dao = new K3Code();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseK3Code bean = new BaseK3Code();
		bean.setDataFromJSON(json);
		K3Code dao = new K3Code();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseK3Code bean = new BaseK3Code();
		bean.setDataFromJSON(json);
		K3Code dao = new K3Code();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseK3Code bean = new BaseK3Code();
		bean.setDataFromJSON(json);
		K3Code dao = new K3Code();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



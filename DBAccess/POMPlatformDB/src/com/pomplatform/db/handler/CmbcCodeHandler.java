package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCmbcCode;
import com.pomplatform.db.dao.CmbcCode;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CmbcCodeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CmbcCodeHandler.class);

	public static BaseCmbcCode getCmbcCodeById( 
		java.lang.Integer cmbc_code_id
	) throws Exception
	{
		CmbcCode dao = new CmbcCode();
		dao.setCmbcCodeId(cmbc_code_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCmbcCodeExists( com.pomplatform.db.bean.BaseCmbcCode bean, String additional ) throws Exception {

		CmbcCode dao = new CmbcCode();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCmbcCode( com.pomplatform.db.bean.BaseCmbcCode bean, String additional ) throws Exception {

		CmbcCode dao = new CmbcCode();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCmbcCode> queryCmbcCode( com.pomplatform.db.bean.BaseCmbcCode bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CmbcCode dao = new CmbcCode();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCmbcCode> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCmbcCode> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCmbcCode addToCmbcCode ( BaseCmbcCode cmbccode )  throws Exception {
		return addToCmbcCode ( cmbccode , false);
	}

	public static BaseCmbcCode addToCmbcCode ( BaseCmbcCode cmbccode, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CmbcCode dao = new CmbcCode();
		dao.setDataFromBase(cmbccode);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCmbcCode addUpdateCmbcCode ( BaseCmbcCode cmbccode ) throws Exception {
		return addUpdateCmbcCode ( cmbccode , false);
	}

	public static BaseCmbcCode addUpdateCmbcCode ( BaseCmbcCode cmbccode, boolean singleTransaction  ) throws Exception {
		if(cmbccode.getCmbcCodeId() == null) return addToCmbcCode(cmbccode);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CmbcCode dao = new CmbcCode();
		dao.setDataFromBase(cmbccode);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cmbccode); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCmbcCode ( BaseCmbcCode bean ) throws Exception {
		CmbcCode dao = new CmbcCode();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCmbcCode updateCmbcCode ( BaseCmbcCode cmbccode ) throws Exception {
		CmbcCode dao = new CmbcCode();
		dao.setCmbcCodeId( cmbccode.getCmbcCodeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cmbccode);
			result = dao.update();
		}
		return result == 1 ? cmbccode : null ;
	}

	public static BaseCmbcCode updateCmbcCodeDirect( BaseCmbcCode cmbccode ) throws Exception {
		CmbcCode dao = new CmbcCode();
		int result = 0;
		dao.setDataFromBase(cmbccode);
		result = dao.update();
		return result == 1 ? cmbccode : null ;
	}

	public static int setDeleteConditions(BaseCmbcCode bean, CmbcCode dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCmbcCodeId() != null) {
			dao.setConditionCmbcCodeId("=", bean.getCmbcCodeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCodeName() != null) {
				dao.setConditionCodeName("=", bean.getCodeName());
				count++;
			}
			if(bean.getCodeId() != null) {
				dao.setConditionCodeId("=", bean.getCodeId());
				count++;
			}
			if(bean.getCodeValue() != null) {
				dao.setConditionCodeValue("=", bean.getCodeValue());
				count++;
			}
			if(bean.getCodeRemark() != null) {
				dao.setConditionCodeRemark("=", bean.getCodeRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCmbcCode bean, CmbcCode dao){
		int count = 0;
		if(bean.getCmbcCodeId() != null) {
			dao.setConditionCmbcCodeId("=", bean.getCmbcCodeId());
			count++;
		}
		if(bean.getCodeName() != null) {
			if(bean.getCodeName().indexOf("%") >= 0)
				dao.setConditionCodeName("like", bean.getCodeName());
			else
				dao.setConditionCodeName("=", bean.getCodeName());
			count++;
		}
		if(bean.getCodeId() != null) {
			if(bean.getCodeId().indexOf("%") >= 0)
				dao.setConditionCodeId("like", bean.getCodeId());
			else
				dao.setConditionCodeId("=", bean.getCodeId());
			count++;
		}
		if(bean.getCodeValue() != null) {
			if(bean.getCodeValue().indexOf("%") >= 0)
				dao.setConditionCodeValue("like", bean.getCodeValue());
			else
				dao.setConditionCodeValue("=", bean.getCodeValue());
			count++;
		}
		if(bean.getCodeRemark() != null) {
			if(bean.getCodeRemark().indexOf("%") >= 0)
				dao.setConditionCodeRemark("like", bean.getCodeRemark());
			else
				dao.setConditionCodeRemark("=", bean.getCodeRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCmbcCode bean = new BaseCmbcCode();
		bean.setDataFromJSON(json);
		CmbcCode dao = new CmbcCode();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCmbcCode> rlist = new BaseCollection<>();
		BaseCmbcCode bean = new BaseCmbcCode();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CmbcCode dao = new CmbcCode();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCmbcCode> result = dao.conditionalLoad(addtion);
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
		BaseCmbcCode bean = new BaseCmbcCode();
		bean.setDataFromJSON(json);
		CmbcCode dao = new CmbcCode();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCmbcCode bean = new BaseCmbcCode();
		bean.setDataFromJSON(json);
		CmbcCode dao = new CmbcCode();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCmbcCode bean = new BaseCmbcCode();
		bean.setDataFromJSON(json);
		CmbcCode dao = new CmbcCode();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCmbcCode bean = new BaseCmbcCode();
		bean.setDataFromJSON(json);
		CmbcCode dao = new CmbcCode();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



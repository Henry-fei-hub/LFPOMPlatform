package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseHrEmpFace;
import com.pomplatform.db.dao.HrEmpFace;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class HrEmpFaceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(HrEmpFaceHandler.class);

	public static BaseHrEmpFace getHrEmpFaceById( 
		java.lang.Integer hr_emp_face_id
	) throws Exception
	{
		HrEmpFace dao = new HrEmpFace();
		dao.setHrEmpFaceId(hr_emp_face_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isHrEmpFaceExists( com.pomplatform.db.bean.BaseHrEmpFace bean, String additional ) throws Exception {

		HrEmpFace dao = new HrEmpFace();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countHrEmpFace( com.pomplatform.db.bean.BaseHrEmpFace bean, String additional ) throws Exception {

		HrEmpFace dao = new HrEmpFace();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseHrEmpFace> queryHrEmpFace( com.pomplatform.db.bean.BaseHrEmpFace bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		HrEmpFace dao = new HrEmpFace();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseHrEmpFace> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseHrEmpFace> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseHrEmpFace addToHrEmpFace ( BaseHrEmpFace hrempface )  throws Exception {
		return addToHrEmpFace ( hrempface , false);
	}

	public static BaseHrEmpFace addToHrEmpFace ( BaseHrEmpFace hrempface, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		HrEmpFace dao = new HrEmpFace();
		dao.setDataFromBase(hrempface);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseHrEmpFace addUpdateHrEmpFace ( BaseHrEmpFace hrempface ) throws Exception {
		return addUpdateHrEmpFace ( hrempface , false);
	}

	public static BaseHrEmpFace addUpdateHrEmpFace ( BaseHrEmpFace hrempface, boolean singleTransaction  ) throws Exception {
		if(hrempface.getHrEmpFaceId() == null) return addToHrEmpFace(hrempface);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		HrEmpFace dao = new HrEmpFace();
		dao.setDataFromBase(hrempface);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(hrempface); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteHrEmpFace ( BaseHrEmpFace bean ) throws Exception {
		HrEmpFace dao = new HrEmpFace();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseHrEmpFace updateHrEmpFace ( BaseHrEmpFace hrempface ) throws Exception {
		HrEmpFace dao = new HrEmpFace();
		dao.setHrEmpFaceId( hrempface.getHrEmpFaceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(hrempface);
			result = dao.update();
		}
		return result == 1 ? hrempface : null ;
	}

	public static BaseHrEmpFace updateHrEmpFaceDirect( BaseHrEmpFace hrempface ) throws Exception {
		HrEmpFace dao = new HrEmpFace();
		int result = 0;
		dao.setDataFromBase(hrempface);
		result = dao.update();
		return result == 1 ? hrempface : null ;
	}

	public static int setDeleteConditions(BaseHrEmpFace bean, HrEmpFace dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getHrEmpFaceId() != null) {
			dao.setConditionHrEmpFaceId("=", bean.getHrEmpFaceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getSn() != null) {
				dao.setConditionSn("=", bean.getSn());
				count++;
			}
			if(bean.getEmpCode() != null) {
				dao.setConditionEmpCode("=", bean.getEmpCode());
				count++;
			}
			if(bean.getTmp() != null) {
				dao.setConditionTmp("=", bean.getTmp());
				count++;
			}
			if(bean.getSize() != null) {
				dao.setConditionSize("=", bean.getSize());
				count++;
			}
			if(bean.getValid() != null) {
				dao.setConditionValid("=", bean.getValid());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
			if(bean.getFid() != null) {
				dao.setConditionFid("=", bean.getFid());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseHrEmpFace bean, HrEmpFace dao){
		int count = 0;
		if(bean.getHrEmpFaceId() != null) {
			dao.setConditionHrEmpFaceId("=", bean.getHrEmpFaceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getSn() != null) {
			if(bean.getSn().indexOf("%") >= 0)
				dao.setConditionSn("like", bean.getSn());
			else
				dao.setConditionSn("=", bean.getSn());
			count++;
		}
		if(bean.getEmpCode() != null) {
			if(bean.getEmpCode().indexOf("%") >= 0)
				dao.setConditionEmpCode("like", bean.getEmpCode());
			else
				dao.setConditionEmpCode("=", bean.getEmpCode());
			count++;
		}
		if(bean.getTmp() != null) {
			if(bean.getTmp().indexOf("%") >= 0)
				dao.setConditionTmp("like", bean.getTmp());
			else
				dao.setConditionTmp("=", bean.getTmp());
			count++;
		}
		if(bean.getSize() != null) {
			dao.setConditionSize("=", bean.getSize());
			count++;
		}
		if(bean.getValid() != null) {
			dao.setConditionValid("=", bean.getValid());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		if(bean.getFid() != null) {
			dao.setConditionFid("=", bean.getFid());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseHrEmpFace bean = new BaseHrEmpFace();
		bean.setDataFromJSON(json);
		HrEmpFace dao = new HrEmpFace();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseHrEmpFace> rlist = new BaseCollection<>();
		BaseHrEmpFace bean = new BaseHrEmpFace();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		HrEmpFace dao = new HrEmpFace();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseHrEmpFace> result = dao.conditionalLoad(addtion);
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
		BaseHrEmpFace bean = new BaseHrEmpFace();
		bean.setDataFromJSON(json);
		HrEmpFace dao = new HrEmpFace();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseHrEmpFace bean = new BaseHrEmpFace();
		bean.setDataFromJSON(json);
		HrEmpFace dao = new HrEmpFace();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseHrEmpFace bean = new BaseHrEmpFace();
		bean.setDataFromJSON(json);
		HrEmpFace dao = new HrEmpFace();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseHrEmpFace bean = new BaseHrEmpFace();
		bean.setDataFromJSON(json);
		HrEmpFace dao = new HrEmpFace();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



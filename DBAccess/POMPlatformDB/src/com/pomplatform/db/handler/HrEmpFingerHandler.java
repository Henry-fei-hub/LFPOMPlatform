package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseHrEmpFinger;
import com.pomplatform.db.dao.HrEmpFinger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class HrEmpFingerHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(HrEmpFingerHandler.class);

	public static BaseHrEmpFinger getHrEmpFingerById( 
		java.lang.Integer hr_emp_finger_id
	) throws Exception
	{
		HrEmpFinger dao = new HrEmpFinger();
		dao.setHrEmpFingerId(hr_emp_finger_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isHrEmpFingerExists( com.pomplatform.db.bean.BaseHrEmpFinger bean, String additional ) throws Exception {

		HrEmpFinger dao = new HrEmpFinger();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countHrEmpFinger( com.pomplatform.db.bean.BaseHrEmpFinger bean, String additional ) throws Exception {

		HrEmpFinger dao = new HrEmpFinger();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseHrEmpFinger> queryHrEmpFinger( com.pomplatform.db.bean.BaseHrEmpFinger bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		HrEmpFinger dao = new HrEmpFinger();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseHrEmpFinger> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseHrEmpFinger> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseHrEmpFinger addToHrEmpFinger ( BaseHrEmpFinger hrempfinger )  throws Exception {
		return addToHrEmpFinger ( hrempfinger , false);
	}

	public static BaseHrEmpFinger addToHrEmpFinger ( BaseHrEmpFinger hrempfinger, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		HrEmpFinger dao = new HrEmpFinger();
		dao.setDataFromBase(hrempfinger);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseHrEmpFinger addUpdateHrEmpFinger ( BaseHrEmpFinger hrempfinger ) throws Exception {
		return addUpdateHrEmpFinger ( hrempfinger , false);
	}

	public static BaseHrEmpFinger addUpdateHrEmpFinger ( BaseHrEmpFinger hrempfinger, boolean singleTransaction  ) throws Exception {
		if(hrempfinger.getHrEmpFingerId() == null) return addToHrEmpFinger(hrempfinger);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		HrEmpFinger dao = new HrEmpFinger();
		dao.setDataFromBase(hrempfinger);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(hrempfinger); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteHrEmpFinger ( BaseHrEmpFinger bean ) throws Exception {
		HrEmpFinger dao = new HrEmpFinger();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseHrEmpFinger updateHrEmpFinger ( BaseHrEmpFinger hrempfinger ) throws Exception {
		HrEmpFinger dao = new HrEmpFinger();
		dao.setHrEmpFingerId( hrempfinger.getHrEmpFingerId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(hrempfinger);
			result = dao.update();
		}
		return result == 1 ? hrempfinger : null ;
	}

	public static BaseHrEmpFinger updateHrEmpFingerDirect( BaseHrEmpFinger hrempfinger ) throws Exception {
		HrEmpFinger dao = new HrEmpFinger();
		int result = 0;
		dao.setDataFromBase(hrempfinger);
		result = dao.update();
		return result == 1 ? hrempfinger : null ;
	}

	public static int setDeleteConditions(BaseHrEmpFinger bean, HrEmpFinger dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getHrEmpFingerId() != null) {
			dao.setConditionHrEmpFingerId("=", bean.getHrEmpFingerId());
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
			if(bean.getTemplate() != null) {
				dao.setConditionTemplate("=", bean.getTemplate());
				count++;
			}
			if(bean.getFpversion() != null) {
				dao.setConditionFpversion("=", bean.getFpversion());
				count++;
			}
			if(bean.getFingerType() != null) {
				dao.setConditionFingerType("=", bean.getFingerType());
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
			if(bean.getIsActive() != null) {
				dao.setConditionIsActive("=", bean.getIsActive());
				count++;
			}
			if(bean.getFid() != null) {
				dao.setConditionFid("=", bean.getFid());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseHrEmpFinger bean, HrEmpFinger dao){
		int count = 0;
		if(bean.getHrEmpFingerId() != null) {
			dao.setConditionHrEmpFingerId("=", bean.getHrEmpFingerId());
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
		if(bean.getTemplate() != null) {
			if(bean.getTemplate().indexOf("%") >= 0)
				dao.setConditionTemplate("like", bean.getTemplate());
			else
				dao.setConditionTemplate("=", bean.getTemplate());
			count++;
		}
		if(bean.getFpversion() != null) {
			dao.setConditionFpversion("=", bean.getFpversion());
			count++;
		}
		if(bean.getFingerType() != null) {
			dao.setConditionFingerType("=", bean.getFingerType());
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
		if(bean.getIsActive() != null) {
			dao.setConditionIsActive("=", bean.getIsActive());
			count++;
		}
		if(bean.getFid() != null) {
			dao.setConditionFid("=", bean.getFid());
			count++;
		}
		if(bean.getUtime() != null) {
			dao.setConditionUtime(">=", bean.getUtime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseHrEmpFinger bean = new BaseHrEmpFinger();
		bean.setDataFromJSON(json);
		HrEmpFinger dao = new HrEmpFinger();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseHrEmpFinger> rlist = new BaseCollection<>();
		BaseHrEmpFinger bean = new BaseHrEmpFinger();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		HrEmpFinger dao = new HrEmpFinger();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseHrEmpFinger> result = dao.conditionalLoad(addtion);
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
		BaseHrEmpFinger bean = new BaseHrEmpFinger();
		bean.setDataFromJSON(json);
		HrEmpFinger dao = new HrEmpFinger();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseHrEmpFinger bean = new BaseHrEmpFinger();
		bean.setDataFromJSON(json);
		HrEmpFinger dao = new HrEmpFinger();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseHrEmpFinger bean = new BaseHrEmpFinger();
		bean.setDataFromJSON(json);
		HrEmpFinger dao = new HrEmpFinger();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseHrEmpFinger bean = new BaseHrEmpFinger();
		bean.setDataFromJSON(json);
		HrEmpFinger dao = new HrEmpFinger();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;
import com.pomplatform.db.dao.CapitalDistributionLinkDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalDistributionLinkDepartmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionLinkDepartmentHandler.class);

	public static BaseCapitalDistributionLinkDepartment getCapitalDistributionLinkDepartmentById( 
		java.lang.Integer capital_distribution_link_department_id
	) throws Exception
	{
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setCapitalDistributionLinkDepartmentId(capital_distribution_link_department_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalDistributionLinkDepartmentExists( com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment bean, String additional ) throws Exception {

		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalDistributionLinkDepartment( com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment bean, String additional ) throws Exception {

		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalDistributionLinkDepartment> queryCapitalDistributionLinkDepartment( com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalDistributionLinkDepartment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalDistributionLinkDepartment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalDistributionLinkDepartment addToCapitalDistributionLinkDepartment ( BaseCapitalDistributionLinkDepartment capitaldistributionlinkdepartment )  throws Exception {
		return addToCapitalDistributionLinkDepartment ( capitaldistributionlinkdepartment , false);
	}

	public static BaseCapitalDistributionLinkDepartment addToCapitalDistributionLinkDepartment ( BaseCapitalDistributionLinkDepartment capitaldistributionlinkdepartment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setDataFromBase(capitaldistributionlinkdepartment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalDistributionLinkDepartment addUpdateCapitalDistributionLinkDepartment ( BaseCapitalDistributionLinkDepartment capitaldistributionlinkdepartment ) throws Exception {
		return addUpdateCapitalDistributionLinkDepartment ( capitaldistributionlinkdepartment , false);
	}

	public static BaseCapitalDistributionLinkDepartment addUpdateCapitalDistributionLinkDepartment ( BaseCapitalDistributionLinkDepartment capitaldistributionlinkdepartment, boolean singleTransaction  ) throws Exception {
		if(capitaldistributionlinkdepartment.getCapitalDistributionLinkDepartmentId() == null) return addToCapitalDistributionLinkDepartment(capitaldistributionlinkdepartment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setDataFromBase(capitaldistributionlinkdepartment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitaldistributionlinkdepartment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalDistributionLinkDepartment ( BaseCapitalDistributionLinkDepartment bean ) throws Exception {
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalDistributionLinkDepartment updateCapitalDistributionLinkDepartment ( BaseCapitalDistributionLinkDepartment capitaldistributionlinkdepartment ) throws Exception {
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setCapitalDistributionLinkDepartmentId( capitaldistributionlinkdepartment.getCapitalDistributionLinkDepartmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitaldistributionlinkdepartment);
			result = dao.update();
		}
		return result == 1 ? capitaldistributionlinkdepartment : null ;
	}

	public static BaseCapitalDistributionLinkDepartment updateCapitalDistributionLinkDepartmentDirect( BaseCapitalDistributionLinkDepartment capitaldistributionlinkdepartment ) throws Exception {
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		int result = 0;
		dao.setDataFromBase(capitaldistributionlinkdepartment);
		result = dao.update();
		return result == 1 ? capitaldistributionlinkdepartment : null ;
	}

	public static int setDeleteConditions(BaseCapitalDistributionLinkDepartment bean, CapitalDistributionLinkDepartment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalDistributionLinkDepartmentId() != null) {
			dao.setConditionCapitalDistributionLinkDepartmentId("=", bean.getCapitalDistributionLinkDepartmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCapitalDistributionId() != null) {
				dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalDistributionLinkDepartment bean, CapitalDistributionLinkDepartment dao){
		int count = 0;
		if(bean.getCapitalDistributionLinkDepartmentId() != null) {
			dao.setConditionCapitalDistributionLinkDepartmentId("=", bean.getCapitalDistributionLinkDepartmentId());
			count++;
		}
		if(bean.getCapitalDistributionId() != null) {
			dao.setConditionCapitalDistributionId("=", bean.getCapitalDistributionId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getMoney() != null) {
			dao.setConditionMoney("=", bean.getMoney());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalDistributionLinkDepartment bean = new BaseCapitalDistributionLinkDepartment();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalDistributionLinkDepartment> rlist = new BaseCollection<>();
		BaseCapitalDistributionLinkDepartment bean = new BaseCapitalDistributionLinkDepartment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalDistributionLinkDepartment> result = dao.conditionalLoad(addtion);
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
		BaseCapitalDistributionLinkDepartment bean = new BaseCapitalDistributionLinkDepartment();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalDistributionLinkDepartment bean = new BaseCapitalDistributionLinkDepartment();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalDistributionLinkDepartment bean = new BaseCapitalDistributionLinkDepartment();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalDistributionLinkDepartment bean = new BaseCapitalDistributionLinkDepartment();
		bean.setDataFromJSON(json);
		CapitalDistributionLinkDepartment dao = new CapitalDistributionLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



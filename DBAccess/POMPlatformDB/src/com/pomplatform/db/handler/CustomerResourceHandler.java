package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCustomerResource;
import com.pomplatform.db.dao.CustomerResource;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomerResourceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CustomerResourceHandler.class);

	public static BaseCustomerResource getCustomerResourceById( 
		java.lang.Integer customer_resource_id
	) throws Exception
	{
		CustomerResource dao = new CustomerResource();
		dao.setCustomerResourceId(customer_resource_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCustomerResourceExists( com.pomplatform.db.bean.BaseCustomerResource bean, String additional ) throws Exception {

		CustomerResource dao = new CustomerResource();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCustomerResource( com.pomplatform.db.bean.BaseCustomerResource bean, String additional ) throws Exception {

		CustomerResource dao = new CustomerResource();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCustomerResource> queryCustomerResource( com.pomplatform.db.bean.BaseCustomerResource bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CustomerResource dao = new CustomerResource();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCustomerResource> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCustomerResource> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCustomerResource addToCustomerResource ( BaseCustomerResource customerresource )  throws Exception {
		return addToCustomerResource ( customerresource , false);
	}

	public static BaseCustomerResource addToCustomerResource ( BaseCustomerResource customerresource, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CustomerResource dao = new CustomerResource();
		dao.setDataFromBase(customerresource);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCustomerResource addUpdateCustomerResource ( BaseCustomerResource customerresource ) throws Exception {
		return addUpdateCustomerResource ( customerresource , false);
	}

	public static BaseCustomerResource addUpdateCustomerResource ( BaseCustomerResource customerresource, boolean singleTransaction  ) throws Exception {
		if(customerresource.getCustomerResourceId() == null) return addToCustomerResource(customerresource);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CustomerResource dao = new CustomerResource();
		dao.setDataFromBase(customerresource);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(customerresource); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCustomerResource ( BaseCustomerResource bean ) throws Exception {
		CustomerResource dao = new CustomerResource();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCustomerResource updateCustomerResource ( BaseCustomerResource customerresource ) throws Exception {
		CustomerResource dao = new CustomerResource();
		dao.setCustomerResourceId( customerresource.getCustomerResourceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(customerresource);
			result = dao.update();
		}
		return result == 1 ? customerresource : null ;
	}

	public static BaseCustomerResource updateCustomerResourceDirect( BaseCustomerResource customerresource ) throws Exception {
		CustomerResource dao = new CustomerResource();
		int result = 0;
		dao.setDataFromBase(customerresource);
		result = dao.update();
		return result == 1 ? customerresource : null ;
	}

	public static int setDeleteConditions(BaseCustomerResource bean, CustomerResource dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCustomerResourceId() != null) {
			dao.setConditionCustomerResourceId("=", bean.getCustomerResourceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyName() != null) {
				dao.setConditionCompanyName("=", bean.getCompanyName());
				count++;
			}
			if(bean.getCompanyAddress() != null) {
				dao.setConditionCompanyAddress("=", bean.getCompanyAddress());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getGrade() != null) {
				dao.setConditionGrade("=", bean.getGrade());
				count++;
			}
			if(bean.getTelephone() != null) {
				dao.setConditionTelephone("=", bean.getTelephone());
				count++;
			}
			if(bean.getEmail() != null) {
				dao.setConditionEmail("=", bean.getEmail());
				count++;
			}
			if(bean.getGender() != null) {
				dao.setConditionGender("=", bean.getGender());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCustomerResource bean, CustomerResource dao){
		int count = 0;
		if(bean.getCustomerResourceId() != null) {
			dao.setConditionCustomerResourceId("=", bean.getCustomerResourceId());
			count++;
		}
		if(bean.getCompanyName() != null) {
			if(bean.getCompanyName().indexOf("%") >= 0)
				dao.setConditionCompanyName("like", bean.getCompanyName());
			else
				dao.setConditionCompanyName("=", bean.getCompanyName());
			count++;
		}
		if(bean.getCompanyAddress() != null) {
			if(bean.getCompanyAddress().indexOf("%") >= 0)
				dao.setConditionCompanyAddress("like", bean.getCompanyAddress());
			else
				dao.setConditionCompanyAddress("=", bean.getCompanyAddress());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getGrade() != null) {
			if(bean.getGrade().indexOf("%") >= 0)
				dao.setConditionGrade("like", bean.getGrade());
			else
				dao.setConditionGrade("=", bean.getGrade());
			count++;
		}
		if(bean.getTelephone() != null) {
			if(bean.getTelephone().indexOf("%") >= 0)
				dao.setConditionTelephone("like", bean.getTelephone());
			else
				dao.setConditionTelephone("=", bean.getTelephone());
			count++;
		}
		if(bean.getEmail() != null) {
			if(bean.getEmail().indexOf("%") >= 0)
				dao.setConditionEmail("like", bean.getEmail());
			else
				dao.setConditionEmail("=", bean.getEmail());
			count++;
		}
		if(bean.getBirthDate() != null) {
			dao.setConditionBirthDate(">=", bean.getBirthDate());
			count++;
		}
		if(bean.getGender() != null) {
			dao.setConditionGender("=", bean.getGender());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BaseCustomerResource bean = new BaseCustomerResource();
		bean.setDataFromJSON(json);
		CustomerResource dao = new CustomerResource();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCustomerResource> rlist = new BaseCollection<>();
		BaseCustomerResource bean = new BaseCustomerResource();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CustomerResource dao = new CustomerResource();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCustomerResource> result = dao.conditionalLoad(addtion);
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
		BaseCustomerResource bean = new BaseCustomerResource();
		bean.setDataFromJSON(json);
		CustomerResource dao = new CustomerResource();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCustomerResource bean = new BaseCustomerResource();
		bean.setDataFromJSON(json);
		CustomerResource dao = new CustomerResource();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCustomerResource bean = new BaseCustomerResource();
		bean.setDataFromJSON(json);
		CustomerResource dao = new CustomerResource();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCustomerResource bean = new BaseCustomerResource();
		bean.setDataFromJSON(json);
		CustomerResource dao = new CustomerResource();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



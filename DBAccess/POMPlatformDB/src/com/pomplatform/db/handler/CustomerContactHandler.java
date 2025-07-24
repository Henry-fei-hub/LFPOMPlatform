package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCustomerContact;
import com.pomplatform.db.dao.CustomerContact;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomerContactHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CustomerContactHandler.class);

	public static BaseCustomerContact getCustomerContactById( 
		java.lang.Integer customer_contact_id
	) throws Exception
	{
		CustomerContact dao = new CustomerContact();
		dao.setCustomerContactId(customer_contact_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCustomerContactExists( com.pomplatform.db.bean.BaseCustomerContact bean, String additional ) throws Exception {

		CustomerContact dao = new CustomerContact();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCustomerContact( com.pomplatform.db.bean.BaseCustomerContact bean, String additional ) throws Exception {

		CustomerContact dao = new CustomerContact();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCustomerContact> queryCustomerContact( com.pomplatform.db.bean.BaseCustomerContact bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CustomerContact dao = new CustomerContact();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCustomerContact> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCustomerContact> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCustomerContact addToCustomerContact ( BaseCustomerContact customercontact )  throws Exception {
		return addToCustomerContact ( customercontact , false);
	}

	public static BaseCustomerContact addToCustomerContact ( BaseCustomerContact customercontact, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CustomerContact dao = new CustomerContact();
		dao.setDataFromBase(customercontact);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCustomerContact addUpdateCustomerContact ( BaseCustomerContact customercontact ) throws Exception {
		return addUpdateCustomerContact ( customercontact , false);
	}

	public static BaseCustomerContact addUpdateCustomerContact ( BaseCustomerContact customercontact, boolean singleTransaction  ) throws Exception {
		if(customercontact.getCustomerContactId() == null) return addToCustomerContact(customercontact);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CustomerContact dao = new CustomerContact();
		dao.setDataFromBase(customercontact);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(customercontact); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCustomerContact ( BaseCustomerContact bean ) throws Exception {
		CustomerContact dao = new CustomerContact();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCustomerContact updateCustomerContact ( BaseCustomerContact customercontact ) throws Exception {
		CustomerContact dao = new CustomerContact();
		dao.setCustomerContactId( customercontact.getCustomerContactId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(customercontact);
			result = dao.update();
		}
		return result == 1 ? customercontact : null ;
	}

	public static BaseCustomerContact updateCustomerContactDirect( BaseCustomerContact customercontact ) throws Exception {
		CustomerContact dao = new CustomerContact();
		int result = 0;
		dao.setDataFromBase(customercontact);
		result = dao.update();
		return result == 1 ? customercontact : null ;
	}

	public static int setDeleteConditions(BaseCustomerContact bean, CustomerContact dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCustomerContactId() != null) {
			dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCustomerId() != null) {
				dao.setConditionCustomerId("=", bean.getCustomerId());
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
			if(bean.getMobile() != null) {
				dao.setConditionMobile("=", bean.getMobile());
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
			if(bean.getEmployeeType() != null) {
				dao.setConditionEmployeeType("=", bean.getEmployeeType());
				count++;
			}
			if(bean.getPersonalInfluence() != null) {
				dao.setConditionPersonalInfluence("=", bean.getPersonalInfluence());
				count++;
			}
			if(bean.getCooperationRelation() != null) {
				dao.setConditionCooperationRelation("=", bean.getCooperationRelation());
				count++;
			}
			if(bean.getCooperationAttitude() != null) {
				dao.setConditionCooperationAttitude("=", bean.getCooperationAttitude());
				count++;
			}
			if(bean.getWorkAddress() != null) {
				dao.setConditionWorkAddress("=", bean.getWorkAddress());
				count++;
			}
			if(bean.getGiftRecord() != null) {
				dao.setConditionGiftRecord("=", bean.getGiftRecord());
				count++;
			}
			if(bean.getComplaintAdvice() != null) {
				dao.setConditionComplaintAdvice("=", bean.getComplaintAdvice());
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

	public static int setConditions(BaseCustomerContact bean, CustomerContact dao){
		int count = 0;
		if(bean.getCustomerContactId() != null) {
			dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
			count++;
		}
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
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
		if(bean.getMobile() != null) {
			if(bean.getMobile().indexOf("%") >= 0)
				dao.setConditionMobile("like", bean.getMobile());
			else
				dao.setConditionMobile("=", bean.getMobile());
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
		if(bean.getEmployeeType() != null) {
			dao.setConditionEmployeeType("=", bean.getEmployeeType());
			count++;
		}
		if(bean.getPersonalInfluence() != null) {
			dao.setConditionPersonalInfluence("=", bean.getPersonalInfluence());
			count++;
		}
		if(bean.getCooperationRelation() != null) {
			dao.setConditionCooperationRelation("=", bean.getCooperationRelation());
			count++;
		}
		if(bean.getCooperationAttitude() != null) {
			dao.setConditionCooperationAttitude("=", bean.getCooperationAttitude());
			count++;
		}
		if(bean.getWorkAddress() != null) {
			if(bean.getWorkAddress().indexOf("%") >= 0)
				dao.setConditionWorkAddress("like", bean.getWorkAddress());
			else
				dao.setConditionWorkAddress("=", bean.getWorkAddress());
			count++;
		}
		if(bean.getGiftRecord() != null) {
			if(bean.getGiftRecord().indexOf("%") >= 0)
				dao.setConditionGiftRecord("like", bean.getGiftRecord());
			else
				dao.setConditionGiftRecord("=", bean.getGiftRecord());
			count++;
		}
		if(bean.getComplaintAdvice() != null) {
			if(bean.getComplaintAdvice().indexOf("%") >= 0)
				dao.setConditionComplaintAdvice("like", bean.getComplaintAdvice());
			else
				dao.setConditionComplaintAdvice("=", bean.getComplaintAdvice());
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
		BaseCustomerContact bean = new BaseCustomerContact();
		bean.setDataFromJSON(json);
		CustomerContact dao = new CustomerContact();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCustomerContact> rlist = new BaseCollection<>();
		BaseCustomerContact bean = new BaseCustomerContact();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CustomerContact dao = new CustomerContact();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCustomerContact> result = dao.conditionalLoad(addtion);
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
		BaseCustomerContact bean = new BaseCustomerContact();
		bean.setDataFromJSON(json);
		CustomerContact dao = new CustomerContact();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCustomerContact bean = new BaseCustomerContact();
		bean.setDataFromJSON(json);
		CustomerContact dao = new CustomerContact();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCustomerContact bean = new BaseCustomerContact();
		bean.setDataFromJSON(json);
		CustomerContact dao = new CustomerContact();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCustomerContact bean = new BaseCustomerContact();
		bean.setDataFromJSON(json);
		CustomerContact dao = new CustomerContact();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



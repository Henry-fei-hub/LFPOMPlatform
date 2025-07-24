package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplierContact;
import com.pomplatform.db.dao.SupplierContact;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierContactHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierContactHandler.class);

	public static BaseSupplierContact getSupplierContactById( 
		java.lang.Integer supplier_contact_id
	) throws Exception
	{
		SupplierContact dao = new SupplierContact();
		dao.setSupplierContactId(supplier_contact_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierContactExists( com.pomplatform.db.bean.BaseSupplierContact bean, String additional ) throws Exception {

		SupplierContact dao = new SupplierContact();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplierContact( com.pomplatform.db.bean.BaseSupplierContact bean, String additional ) throws Exception {

		SupplierContact dao = new SupplierContact();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplierContact> querySupplierContact( com.pomplatform.db.bean.BaseSupplierContact bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SupplierContact dao = new SupplierContact();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplierContact> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplierContact> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplierContact addToSupplierContact ( BaseSupplierContact suppliercontact )  throws Exception {
		return addToSupplierContact ( suppliercontact , false);
	}

	public static BaseSupplierContact addToSupplierContact ( BaseSupplierContact suppliercontact, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SupplierContact dao = new SupplierContact();
		dao.setDataFromBase(suppliercontact);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplierContact addUpdateSupplierContact ( BaseSupplierContact suppliercontact ) throws Exception {
		return addUpdateSupplierContact ( suppliercontact , false);
	}

	public static BaseSupplierContact addUpdateSupplierContact ( BaseSupplierContact suppliercontact, boolean singleTransaction  ) throws Exception {
		if(suppliercontact.getSupplierContactId() == null) return addToSupplierContact(suppliercontact);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SupplierContact dao = new SupplierContact();
		dao.setDataFromBase(suppliercontact);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(suppliercontact); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplierContact ( BaseSupplierContact bean ) throws Exception {
		SupplierContact dao = new SupplierContact();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplierContact updateSupplierContact ( BaseSupplierContact suppliercontact ) throws Exception {
		SupplierContact dao = new SupplierContact();
		dao.setSupplierContactId( suppliercontact.getSupplierContactId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(suppliercontact);
			result = dao.update();
		}
		return result == 1 ? suppliercontact : null ;
	}

	public static BaseSupplierContact updateSupplierContactDirect( BaseSupplierContact suppliercontact ) throws Exception {
		SupplierContact dao = new SupplierContact();
		int result = 0;
		dao.setDataFromBase(suppliercontact);
		result = dao.update();
		return result == 1 ? suppliercontact : null ;
	}

	public static int setDeleteConditions(BaseSupplierContact bean, SupplierContact dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierContactId() != null) {
			dao.setConditionSupplierContactId("=", bean.getSupplierContactId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getContactName() != null) {
				dao.setConditionContactName("=", bean.getContactName());
				count++;
			}
			if(bean.getContactPosition() != null) {
				dao.setConditionContactPosition("=", bean.getContactPosition());
				count++;
			}
			if(bean.getContactGender() != null) {
				dao.setConditionContactGender("=", bean.getContactGender());
				count++;
			}
			if(bean.getContactPhone() != null) {
				dao.setConditionContactPhone("=", bean.getContactPhone());
				count++;
			}
			if(bean.getContactEmail() != null) {
				dao.setConditionContactEmail("=", bean.getContactEmail());
				count++;
			}
			if(bean.getContactFax() != null) {
				dao.setConditionContactFax("=", bean.getContactFax());
				count++;
			}
			if(bean.getContactType() != null) {
				dao.setConditionContactType("=", bean.getContactType());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplierContact bean, SupplierContact dao){
		int count = 0;
		if(bean.getSupplierContactId() != null) {
			dao.setConditionSupplierContactId("=", bean.getSupplierContactId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getContactName() != null) {
			if(bean.getContactName().indexOf("%") >= 0)
				dao.setConditionContactName("like", bean.getContactName());
			else
				dao.setConditionContactName("=", bean.getContactName());
			count++;
		}
		if(bean.getContactPosition() != null) {
			if(bean.getContactPosition().indexOf("%") >= 0)
				dao.setConditionContactPosition("like", bean.getContactPosition());
			else
				dao.setConditionContactPosition("=", bean.getContactPosition());
			count++;
		}
		if(bean.getContactGender() != null) {
			dao.setConditionContactGender("=", bean.getContactGender());
			count++;
		}
		if(bean.getContactPhone() != null) {
			if(bean.getContactPhone().indexOf("%") >= 0)
				dao.setConditionContactPhone("like", bean.getContactPhone());
			else
				dao.setConditionContactPhone("=", bean.getContactPhone());
			count++;
		}
		if(bean.getContactEmail() != null) {
			if(bean.getContactEmail().indexOf("%") >= 0)
				dao.setConditionContactEmail("like", bean.getContactEmail());
			else
				dao.setConditionContactEmail("=", bean.getContactEmail());
			count++;
		}
		if(bean.getContactFax() != null) {
			if(bean.getContactFax().indexOf("%") >= 0)
				dao.setConditionContactFax("like", bean.getContactFax());
			else
				dao.setConditionContactFax("=", bean.getContactFax());
			count++;
		}
		if(bean.getContactType() != null) {
			dao.setConditionContactType("=", bean.getContactType());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
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
		BaseSupplierContact bean = new BaseSupplierContact();
		bean.setDataFromJSON(json);
		SupplierContact dao = new SupplierContact();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierContact> rlist = new BaseCollection<>();
		BaseSupplierContact bean = new BaseSupplierContact();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierContact dao = new SupplierContact();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierContact> result = dao.conditionalLoad(addtion);
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
		BaseSupplierContact bean = new BaseSupplierContact();
		bean.setDataFromJSON(json);
		SupplierContact dao = new SupplierContact();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierContact bean = new BaseSupplierContact();
		bean.setDataFromJSON(json);
		SupplierContact dao = new SupplierContact();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierContact bean = new BaseSupplierContact();
		bean.setDataFromJSON(json);
		SupplierContact dao = new SupplierContact();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierContact bean = new BaseSupplierContact();
		bean.setDataFromJSON(json);
		SupplierContact dao = new SupplierContact();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



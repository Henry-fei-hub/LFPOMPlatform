package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.dao.NormalReimbursementLinkDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class NormalReimbursementLinkDepartmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(NormalReimbursementLinkDepartmentHandler.class);

	public static BaseNormalReimbursementLinkDepartment getNormalReimbursementLinkDepartmentById( 
		java.lang.Integer normal_reimbursement_link_department_id
	) throws Exception
	{
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setNormalReimbursementLinkDepartmentId(normal_reimbursement_link_department_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isNormalReimbursementLinkDepartmentExists( com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment bean, String additional ) throws Exception {

		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countNormalReimbursementLinkDepartment( com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment bean, String additional ) throws Exception {

		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseNormalReimbursementLinkDepartment> queryNormalReimbursementLinkDepartment( com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseNormalReimbursementLinkDepartment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseNormalReimbursementLinkDepartment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseNormalReimbursementLinkDepartment addToNormalReimbursementLinkDepartment ( BaseNormalReimbursementLinkDepartment normalreimbursementlinkdepartment )  throws Exception {
		return addToNormalReimbursementLinkDepartment ( normalreimbursementlinkdepartment , false);
	}

	public static BaseNormalReimbursementLinkDepartment addToNormalReimbursementLinkDepartment ( BaseNormalReimbursementLinkDepartment normalreimbursementlinkdepartment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setDataFromBase(normalreimbursementlinkdepartment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseNormalReimbursementLinkDepartment addUpdateNormalReimbursementLinkDepartment ( BaseNormalReimbursementLinkDepartment normalreimbursementlinkdepartment ) throws Exception {
		return addUpdateNormalReimbursementLinkDepartment ( normalreimbursementlinkdepartment , false);
	}

	public static BaseNormalReimbursementLinkDepartment addUpdateNormalReimbursementLinkDepartment ( BaseNormalReimbursementLinkDepartment normalreimbursementlinkdepartment, boolean singleTransaction  ) throws Exception {
		if(normalreimbursementlinkdepartment.getNormalReimbursementLinkDepartmentId() == null) return addToNormalReimbursementLinkDepartment(normalreimbursementlinkdepartment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setDataFromBase(normalreimbursementlinkdepartment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(normalreimbursementlinkdepartment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteNormalReimbursementLinkDepartment ( BaseNormalReimbursementLinkDepartment bean ) throws Exception {
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseNormalReimbursementLinkDepartment updateNormalReimbursementLinkDepartment ( BaseNormalReimbursementLinkDepartment normalreimbursementlinkdepartment ) throws Exception {
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setNormalReimbursementLinkDepartmentId( normalreimbursementlinkdepartment.getNormalReimbursementLinkDepartmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(normalreimbursementlinkdepartment);
			result = dao.update();
		}
		return result == 1 ? normalreimbursementlinkdepartment : null ;
	}

	public static BaseNormalReimbursementLinkDepartment updateNormalReimbursementLinkDepartmentDirect( BaseNormalReimbursementLinkDepartment normalreimbursementlinkdepartment ) throws Exception {
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		int result = 0;
		dao.setDataFromBase(normalreimbursementlinkdepartment);
		result = dao.update();
		return result == 1 ? normalreimbursementlinkdepartment : null ;
	}

	public static int setDeleteConditions(BaseNormalReimbursementLinkDepartment bean, NormalReimbursementLinkDepartment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getNormalReimbursementLinkDepartmentId() != null) {
			dao.setConditionNormalReimbursementLinkDepartmentId("=", bean.getNormalReimbursementLinkDepartmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectNormalReimbursementId() != null) {
				dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getMainItemId() != null) {
				dao.setConditionMainItemId("=", bean.getMainItemId());
				count++;
			}
			if(bean.getSubItemId() != null) {
				dao.setConditionSubItemId("=", bean.getSubItemId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getHaveElectronicInvoice() != null) {
				dao.setConditionHaveElectronicInvoice("=", bean.getHaveElectronicInvoice());
				count++;
			}
			if(bean.getInvoiceLinkKey() != null) {
				dao.setConditionInvoiceLinkKey("=", bean.getInvoiceLinkKey());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseNormalReimbursementLinkDepartment bean, NormalReimbursementLinkDepartment dao){
		int count = 0;
		if(bean.getNormalReimbursementLinkDepartmentId() != null) {
			dao.setConditionNormalReimbursementLinkDepartmentId("=", bean.getNormalReimbursementLinkDepartmentId());
			count++;
		}
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getInputTax() != null) {
			dao.setConditionInputTax("=", bean.getInputTax());
			count++;
		}
		if(bean.getFinalAmount() != null) {
			dao.setConditionFinalAmount("=", bean.getFinalAmount());
			count++;
		}
		if(bean.getMainItemId() != null) {
			dao.setConditionMainItemId("=", bean.getMainItemId());
			count++;
		}
		if(bean.getSubItemId() != null) {
			dao.setConditionSubItemId("=", bean.getSubItemId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getInputTaxRebate() != null) {
			dao.setConditionInputTaxRebate("=", bean.getInputTaxRebate());
			count++;
		}
		if(bean.getHaveElectronicInvoice() != null) {
			dao.setConditionHaveElectronicInvoice("=", bean.getHaveElectronicInvoice());
			count++;
		}
		if(bean.getInvoiceLinkKey() != null) {
			dao.setConditionInvoiceLinkKey("=", bean.getInvoiceLinkKey());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseNormalReimbursementLinkDepartment bean = new BaseNormalReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseNormalReimbursementLinkDepartment> rlist = new BaseCollection<>();
		BaseNormalReimbursementLinkDepartment bean = new BaseNormalReimbursementLinkDepartment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseNormalReimbursementLinkDepartment> result = dao.conditionalLoad(addtion);
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
		BaseNormalReimbursementLinkDepartment bean = new BaseNormalReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseNormalReimbursementLinkDepartment bean = new BaseNormalReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseNormalReimbursementLinkDepartment bean = new BaseNormalReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseNormalReimbursementLinkDepartment bean = new BaseNormalReimbursementLinkDepartment();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkDepartment dao = new NormalReimbursementLinkDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



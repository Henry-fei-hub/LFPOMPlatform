package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject;
import com.pomplatform.db.dao.NormalReimbursementLinkMainProject;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class NormalReimbursementLinkMainProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(NormalReimbursementLinkMainProjectHandler.class);

	public static BaseNormalReimbursementLinkMainProject getNormalReimbursementLinkMainProjectById( 
		java.lang.Integer normal_reimbursement_link_main_project_id
	) throws Exception
	{
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setNormalReimbursementLinkMainProjectId(normal_reimbursement_link_main_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isNormalReimbursementLinkMainProjectExists( com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject bean, String additional ) throws Exception {

		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countNormalReimbursementLinkMainProject( com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject bean, String additional ) throws Exception {

		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseNormalReimbursementLinkMainProject> queryNormalReimbursementLinkMainProject( com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseNormalReimbursementLinkMainProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseNormalReimbursementLinkMainProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseNormalReimbursementLinkMainProject addToNormalReimbursementLinkMainProject ( BaseNormalReimbursementLinkMainProject normalreimbursementlinkmainproject )  throws Exception {
		return addToNormalReimbursementLinkMainProject ( normalreimbursementlinkmainproject , false);
	}

	public static BaseNormalReimbursementLinkMainProject addToNormalReimbursementLinkMainProject ( BaseNormalReimbursementLinkMainProject normalreimbursementlinkmainproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setDataFromBase(normalreimbursementlinkmainproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseNormalReimbursementLinkMainProject addUpdateNormalReimbursementLinkMainProject ( BaseNormalReimbursementLinkMainProject normalreimbursementlinkmainproject ) throws Exception {
		return addUpdateNormalReimbursementLinkMainProject ( normalreimbursementlinkmainproject , false);
	}

	public static BaseNormalReimbursementLinkMainProject addUpdateNormalReimbursementLinkMainProject ( BaseNormalReimbursementLinkMainProject normalreimbursementlinkmainproject, boolean singleTransaction  ) throws Exception {
		if(normalreimbursementlinkmainproject.getNormalReimbursementLinkMainProjectId() == null) return addToNormalReimbursementLinkMainProject(normalreimbursementlinkmainproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setDataFromBase(normalreimbursementlinkmainproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(normalreimbursementlinkmainproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteNormalReimbursementLinkMainProject ( BaseNormalReimbursementLinkMainProject bean ) throws Exception {
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseNormalReimbursementLinkMainProject updateNormalReimbursementLinkMainProject ( BaseNormalReimbursementLinkMainProject normalreimbursementlinkmainproject ) throws Exception {
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setNormalReimbursementLinkMainProjectId( normalreimbursementlinkmainproject.getNormalReimbursementLinkMainProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(normalreimbursementlinkmainproject);
			result = dao.update();
		}
		return result == 1 ? normalreimbursementlinkmainproject : null ;
	}

	public static BaseNormalReimbursementLinkMainProject updateNormalReimbursementLinkMainProjectDirect( BaseNormalReimbursementLinkMainProject normalreimbursementlinkmainproject ) throws Exception {
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		int result = 0;
		dao.setDataFromBase(normalreimbursementlinkmainproject);
		result = dao.update();
		return result == 1 ? normalreimbursementlinkmainproject : null ;
	}

	public static int setDeleteConditions(BaseNormalReimbursementLinkMainProject bean, NormalReimbursementLinkMainProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getNormalReimbursementLinkMainProjectId() != null) {
			dao.setConditionNormalReimbursementLinkMainProjectId("=", bean.getNormalReimbursementLinkMainProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectNormalReimbursementId() != null) {
				dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getMainProjectName() != null) {
				dao.setConditionMainProjectName("=", bean.getMainProjectName());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getIsPersonalFee() != null) {
				dao.setConditionIsPersonalFee("=", bean.getIsPersonalFee());
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

	public static int setConditions(BaseNormalReimbursementLinkMainProject bean, NormalReimbursementLinkMainProject dao){
		int count = 0;
		if(bean.getNormalReimbursementLinkMainProjectId() != null) {
			dao.setConditionNormalReimbursementLinkMainProjectId("=", bean.getNormalReimbursementLinkMainProjectId());
			count++;
		}
		if(bean.getProjectNormalReimbursementId() != null) {
			dao.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getMainProjectName() != null) {
			if(bean.getMainProjectName().indexOf("%") >= 0)
				dao.setConditionMainProjectName("like", bean.getMainProjectName());
			else
				dao.setConditionMainProjectName("=", bean.getMainProjectName());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		if(bean.getIsPersonalFee() != null) {
			dao.setConditionIsPersonalFee("=", bean.getIsPersonalFee());
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
		BaseNormalReimbursementLinkMainProject bean = new BaseNormalReimbursementLinkMainProject();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseNormalReimbursementLinkMainProject> rlist = new BaseCollection<>();
		BaseNormalReimbursementLinkMainProject bean = new BaseNormalReimbursementLinkMainProject();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseNormalReimbursementLinkMainProject> result = dao.conditionalLoad(addtion);
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
		BaseNormalReimbursementLinkMainProject bean = new BaseNormalReimbursementLinkMainProject();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseNormalReimbursementLinkMainProject bean = new BaseNormalReimbursementLinkMainProject();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseNormalReimbursementLinkMainProject bean = new BaseNormalReimbursementLinkMainProject();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseNormalReimbursementLinkMainProject bean = new BaseNormalReimbursementLinkMainProject();
		bean.setDataFromJSON(json);
		NormalReimbursementLinkMainProject dao = new NormalReimbursementLinkMainProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



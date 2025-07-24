package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseContractReceivableTemplate;
import java.util.List;
import com.pomplatform.db.dao.ContractReceivableTemplate;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ContractReceivableTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractReceivableTemplateHandler.class);

	public static BaseContractReceivableTemplate getContractReceivableTemplateById( 
		java.lang.Integer contract_receivable_template_id
	) throws Exception
	{
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setContractReceivableTemplateId(contract_receivable_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractReceivableTemplateExists( com.pomplatform.db.bean.BaseContractReceivableTemplate bean, String additional ) throws Exception {

		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractReceivableTemplate( com.pomplatform.db.bean.BaseContractReceivableTemplate bean, String additional ) throws Exception {

		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractReceivableTemplate> queryContractReceivableTemplate( com.pomplatform.db.bean.BaseContractReceivableTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractReceivableTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractReceivableTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractReceivableTemplate addToContractReceivableTemplate ( BaseContractReceivableTemplate contractreceivabletemplate )  throws Exception {
		return addToContractReceivableTemplate ( contractreceivabletemplate , false);
	}

	public static BaseContractReceivableTemplate addToContractReceivableTemplate ( BaseContractReceivableTemplate contractreceivabletemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setDataFromBase(contractreceivabletemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractReceivableTemplate addUpdateContractReceivableTemplate ( BaseContractReceivableTemplate contractreceivabletemplate ) throws Exception {
		return addUpdateContractReceivableTemplate ( contractreceivabletemplate , false);
	}

	public static BaseContractReceivableTemplate addUpdateContractReceivableTemplate ( BaseContractReceivableTemplate contractreceivabletemplate, boolean singleTransaction  ) throws Exception {
		if(contractreceivabletemplate.getContractReceivableTemplateId() == null) return addToContractReceivableTemplate(contractreceivabletemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setDataFromBase(contractreceivabletemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractreceivabletemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractReceivableTemplate ( BaseContractReceivableTemplate bean ) throws Exception {
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractReceivableTemplate updateContractReceivableTemplate ( BaseContractReceivableTemplate contractreceivabletemplate ) throws Exception {
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setContractReceivableTemplateId( contractreceivabletemplate.getContractReceivableTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractreceivabletemplate);
			result = dao.update();
		}
		return result == 1 ? contractreceivabletemplate : null ;
	}

	public static BaseContractReceivableTemplate updateContractReceivableTemplateDirect( BaseContractReceivableTemplate contractreceivabletemplate ) throws Exception {
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		int result = 0;
		dao.setDataFromBase(contractreceivabletemplate);
		result = dao.update();
		return result == 1 ? contractreceivabletemplate : null ;
	}

	public static int setDeleteConditions(BaseContractReceivableTemplate bean, ContractReceivableTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractReceivableTemplateId() != null) {
			dao.setConditionContractReceivableTemplateId("=", bean.getContractReceivableTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReceivableName() != null) {
				dao.setConditionReceivableName("=", bean.getReceivableName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractReceivableTemplate bean, ContractReceivableTemplate dao){
		int count = 0;
		if(bean.getContractReceivableTemplateId() != null) {
			dao.setConditionContractReceivableTemplateId("=", bean.getContractReceivableTemplateId());
			count++;
		}
		if(bean.getReceivableName() != null) {
			if(bean.getReceivableName().indexOf("%") >= 0)
				dao.setConditionReceivableName("like", bean.getReceivableName());
			else
				dao.setConditionReceivableName("=", bean.getReceivableName());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getReceivablePercentage() != null) {
			dao.setConditionReceivablePercentage("=", bean.getReceivablePercentage());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractReceivableTemplate bean = new BaseContractReceivableTemplate();
		bean.setDataFromJSON(json);
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractReceivableTemplate> rlist = new BaseCollection<>();
		BaseContractReceivableTemplate bean = new BaseContractReceivableTemplate();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractReceivableTemplate> result = dao.conditionalLoad(addtion);
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
		BaseContractReceivableTemplate bean = new BaseContractReceivableTemplate();
		bean.setDataFromJSON(json);
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractReceivableTemplate bean = new BaseContractReceivableTemplate();
		bean.setDataFromJSON(json);
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractReceivableTemplate bean = new BaseContractReceivableTemplate();
		bean.setDataFromJSON(json);
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractReceivableTemplate bean = new BaseContractReceivableTemplate();
		bean.setDataFromJSON(json);
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



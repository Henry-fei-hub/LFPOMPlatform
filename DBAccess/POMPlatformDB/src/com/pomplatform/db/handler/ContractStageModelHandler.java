package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractStageModel;
import com.pomplatform.db.dao.ContractStageModel;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractStageModelHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractStageModelHandler.class);

	public static BaseContractStageModel getContractStageModelById( 
		java.lang.Integer contract_stage_model_id
	) throws Exception
	{
		ContractStageModel dao = new ContractStageModel();
		dao.setContractStageModelId(contract_stage_model_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractStageModelExists( com.pomplatform.db.bean.BaseContractStageModel bean, String additional ) throws Exception {

		ContractStageModel dao = new ContractStageModel();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractStageModel( com.pomplatform.db.bean.BaseContractStageModel bean, String additional ) throws Exception {

		ContractStageModel dao = new ContractStageModel();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractStageModel> queryContractStageModel( com.pomplatform.db.bean.BaseContractStageModel bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractStageModel dao = new ContractStageModel();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractStageModel> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractStageModel> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractStageModel addToContractStageModel ( BaseContractStageModel contractstagemodel )  throws Exception {
		return addToContractStageModel ( contractstagemodel , false);
	}

	public static BaseContractStageModel addToContractStageModel ( BaseContractStageModel contractstagemodel, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractStageModel dao = new ContractStageModel();
		dao.setDataFromBase(contractstagemodel);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractStageModel addUpdateContractStageModel ( BaseContractStageModel contractstagemodel ) throws Exception {
		return addUpdateContractStageModel ( contractstagemodel , false);
	}

	public static BaseContractStageModel addUpdateContractStageModel ( BaseContractStageModel contractstagemodel, boolean singleTransaction  ) throws Exception {
		if(contractstagemodel.getContractStageModelId() == null) return addToContractStageModel(contractstagemodel);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractStageModel dao = new ContractStageModel();
		dao.setDataFromBase(contractstagemodel);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractstagemodel); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractStageModel ( BaseContractStageModel bean ) throws Exception {
		ContractStageModel dao = new ContractStageModel();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractStageModel updateContractStageModel ( BaseContractStageModel contractstagemodel ) throws Exception {
		ContractStageModel dao = new ContractStageModel();
		dao.setContractStageModelId( contractstagemodel.getContractStageModelId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractstagemodel);
			result = dao.update();
		}
		return result == 1 ? contractstagemodel : null ;
	}

	public static BaseContractStageModel updateContractStageModelDirect( BaseContractStageModel contractstagemodel ) throws Exception {
		ContractStageModel dao = new ContractStageModel();
		int result = 0;
		dao.setDataFromBase(contractstagemodel);
		result = dao.update();
		return result == 1 ? contractstagemodel : null ;
	}

	public static int setDeleteConditions(BaseContractStageModel bean, ContractStageModel dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractStageModelId() != null) {
			dao.setConditionContractStageModelId("=", bean.getContractStageModelId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getStageModelId() != null) {
				dao.setConditionStageModelId("=", bean.getStageModelId());
				count++;
			}
			if(bean.getStageModelName() != null) {
				dao.setConditionStageModelName("=", bean.getStageModelName());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getLeafNode() != null) {
				dao.setConditionLeafNode("=", bean.getLeafNode());
				count++;
			}
			if(bean.getOrderNo() != null) {
				dao.setConditionOrderNo("=", bean.getOrderNo());
				count++;
			}
			if(bean.getNeedManagerAudit() != null) {
				dao.setConditionNeedManagerAudit("=", bean.getNeedManagerAudit());
				count++;
			}
			if(bean.getNeedDesignDirectorAudit() != null) {
				dao.setConditionNeedDesignDirectorAudit("=", bean.getNeedDesignDirectorAudit());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getManagerComment() != null) {
				dao.setConditionManagerComment("=", bean.getManagerComment());
				count++;
			}
			if(bean.getManagerId() != null) {
				dao.setConditionManagerId("=", bean.getManagerId());
				count++;
			}
			if(bean.getDesignDirectorComment() != null) {
				dao.setConditionDesignDirectorComment("=", bean.getDesignDirectorComment());
				count++;
			}
			if(bean.getDesignDirectorId() != null) {
				dao.setConditionDesignDirectorId("=", bean.getDesignDirectorId());
				count++;
			}
			if(bean.getLocked() != null) {
				dao.setConditionLocked("=", bean.getLocked());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
			if(bean.getHasEvidence() != null) {
				dao.setConditionHasEvidence("=", bean.getHasEvidence());
				count++;
			}
			if(bean.getEvidence() != null) {
				dao.setConditionEvidence("=", bean.getEvidence());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractStageModel bean, ContractStageModel dao){
		int count = 0;
		if(bean.getContractStageModelId() != null) {
			dao.setConditionContractStageModelId("=", bean.getContractStageModelId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getStageModelId() != null) {
			dao.setConditionStageModelId("=", bean.getStageModelId());
			count++;
		}
		if(bean.getStageModelName() != null) {
			if(bean.getStageModelName().indexOf("%") >= 0)
				dao.setConditionStageModelName("like", bean.getStageModelName());
			else
				dao.setConditionStageModelName("=", bean.getStageModelName());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getLeafNode() != null) {
			dao.setConditionLeafNode("=", bean.getLeafNode());
			count++;
		}
		if(bean.getOrderNo() != null) {
			dao.setConditionOrderNo("=", bean.getOrderNo());
			count++;
		}
		if(bean.getNeedManagerAudit() != null) {
			dao.setConditionNeedManagerAudit("=", bean.getNeedManagerAudit());
			count++;
		}
		if(bean.getNeedDesignDirectorAudit() != null) {
			dao.setConditionNeedDesignDirectorAudit("=", bean.getNeedDesignDirectorAudit());
			count++;
		}
		if(bean.getActualPercent() != null) {
			dao.setConditionActualPercent("=", bean.getActualPercent());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getManagerComment() != null) {
			if(bean.getManagerComment().indexOf("%") >= 0)
				dao.setConditionManagerComment("like", bean.getManagerComment());
			else
				dao.setConditionManagerComment("=", bean.getManagerComment());
			count++;
		}
		if(bean.getManagerId() != null) {
			dao.setConditionManagerId("=", bean.getManagerId());
			count++;
		}
		if(bean.getManagerAuditDate() != null) {
			dao.setConditionManagerAuditDate(">=", bean.getManagerAuditDate());
			count++;
		}
		if(bean.getDesignDirectorComment() != null) {
			if(bean.getDesignDirectorComment().indexOf("%") >= 0)
				dao.setConditionDesignDirectorComment("like", bean.getDesignDirectorComment());
			else
				dao.setConditionDesignDirectorComment("=", bean.getDesignDirectorComment());
			count++;
		}
		if(bean.getDesignDirectorId() != null) {
			dao.setConditionDesignDirectorId("=", bean.getDesignDirectorId());
			count++;
		}
		if(bean.getDesignDirectorAuditDate() != null) {
			dao.setConditionDesignDirectorAuditDate(">=", bean.getDesignDirectorAuditDate());
			count++;
		}
		if(bean.getLocked() != null) {
			dao.setConditionLocked("=", bean.getLocked());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
			count++;
		}
		if(bean.getConfirmDate() != null) {
			dao.setConditionConfirmDate(">=", bean.getConfirmDate());
			count++;
		}
		if(bean.getHasEvidence() != null) {
			dao.setConditionHasEvidence("=", bean.getHasEvidence());
			count++;
		}
		if(bean.getEvidence() != null) {
			if(bean.getEvidence().indexOf("%") >= 0)
				dao.setConditionEvidence("like", bean.getEvidence());
			else
				dao.setConditionEvidence("=", bean.getEvidence());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractStageModel bean = new BaseContractStageModel();
		bean.setDataFromJSON(json);
		ContractStageModel dao = new ContractStageModel();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractStageModel> rlist = new BaseCollection<>();
		BaseContractStageModel bean = new BaseContractStageModel();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractStageModel dao = new ContractStageModel();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractStageModel> result = dao.conditionalLoad(addtion);
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
		BaseContractStageModel bean = new BaseContractStageModel();
		bean.setDataFromJSON(json);
		ContractStageModel dao = new ContractStageModel();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractStageModel bean = new BaseContractStageModel();
		bean.setDataFromJSON(json);
		ContractStageModel dao = new ContractStageModel();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractStageModel bean = new BaseContractStageModel();
		bean.setDataFromJSON(json);
		ContractStageModel dao = new ContractStageModel();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractStageModel bean = new BaseContractStageModel();
		bean.setDataFromJSON(json);
		ContractStageModel dao = new ContractStageModel();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}



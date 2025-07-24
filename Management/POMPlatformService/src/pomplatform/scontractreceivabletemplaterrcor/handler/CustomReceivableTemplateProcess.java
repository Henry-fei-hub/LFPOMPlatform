package pomplatform.scontractreceivabletemplaterrcor.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseContractReceivable;
import com.pomplatform.db.bean.BaseContractReceivableTemplate;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractReceivable;
import com.pomplatform.db.dao.ContractReceivableTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.sinvoiceitior.bean.CustomBaseIddStrVal;

public class CustomReceivableTemplateProcess implements GenericProcessor {

	private final static String GET_PARENT_TEMPLATE = "getParentTemplate";// 获取所有顶级的模板

	private final static String APPLY_TEMPLATE = "applyTemplate";// 应用模板
	
	private final static String SAVE_OR_UPDATE_TEMPLATE = "saveOrUpdateTemplate";//新增模板

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GET_PARENT_TEMPLATE:
				return getParentTemplate();
			case APPLY_TEMPLATE:
				return applyTemplate(result);
			case SAVE_OR_UPDATE_TEMPLATE:
				return saveOrUpdateTemplate(result);
			}
		}
		return null;
	}
	
	
	/**
	 * 新增模板
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String saveOrUpdateTemplate(Map<String, Object> params) throws SQLException {
		int status = 1;
		String str ="";
		BaseCollection<BaseContractReceivableTemplate> bc = new BaseCollection<>();
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		//父节点id
		int parentId = BaseHelpUtils.getIntValue(params,"parentId");
		//主键id
		int contractReceivableTemplateId = BaseHelpUtils.getIntValue(params,"contractReceivableTemplateId");
		BigDecimal receivablePercentage = BaseHelpUtils.getBigDecimalValue(params.get("receivablePercentage"));
		
		//id大于0表示更新  ，等于0表示新增
		if(contractReceivableTemplateId>0) {
			dao.setConditionParentId("=", parentId);
			dao.setConditionReceivablePercentage(">", BigDecimal.ZERO);
			dao.setConditionContractReceivableTemplateId("!=",contractReceivableTemplateId);
			List<BaseContractReceivableTemplate> list = dao.conditionalLoad();
			BigDecimal percentSum = BigDecimal.ZERO;
			for (BaseContractReceivableTemplate baseContractReceivableTemplate : list) {
				BigDecimal percent = BaseHelpUtils.getBigDecimalValue(baseContractReceivableTemplate.getReceivablePercentage());
				percentSum =percentSum.add(percent);
			}
			percentSum=percentSum.add(receivablePercentage);
			if(percentSum.compareTo(new BigDecimal(100))>0) {
				status = -1;
				str ="收款比例之和不能大于100";
			}else {
				dao.clear();
				dao.setConditionContractReceivableTemplateId("=", contractReceivableTemplateId);
				dao.setParentId(parentId);
				dao.setRemark(BaseHelpUtils.getString(params.get("remark")));
				dao.setReceivablePercentage(receivablePercentage);
				dao.setUpdateTime(new Date());
				dao.setReceivableName(BaseHelpUtils.getString(params.get("receivableName")));
				dao.setOperator(BaseHelpUtils.getIntValue(params.get("employeeId")));
				dao.conditionalUpdate();
			}
		}else {
			dao.setConditionParentId("=", parentId);
			dao.setConditionReceivablePercentage(">", BigDecimal.ZERO);
//			dao.setConditionContractReceivableTemplateId("!=",contractReceivableTemplateId);
			List<BaseContractReceivableTemplate> list = dao.conditionalLoad();
			BigDecimal percentSum = BigDecimal.ZERO;
			for (BaseContractReceivableTemplate baseContractReceivableTemplate : list) {
				BigDecimal percent = BaseHelpUtils.getBigDecimalValue(baseContractReceivableTemplate.getReceivablePercentage());
				percentSum =percentSum.add(percent);
			}
			percentSum=percentSum.add(receivablePercentage);
			if(percentSum.compareTo(new BigDecimal(100))>0) {
				status = -1;
				str ="收款比例之和不能大于100";
			}else {
				dao.clear();
				dao.setParentId(parentId);
				dao.setRemark(BaseHelpUtils.getString(params.get("remark")));
				dao.setReceivablePercentage(receivablePercentage);
				dao.setUpdateTime(new Date());
				dao.setReceivableName(BaseHelpUtils.getString(params.get("receivableName")));
				dao.setOperator(BaseHelpUtils.getIntValue(params.get("employeeId")));
				dao.save();
			}
			
		}
		return bc.toJSON(status, str);
	}
	
	
	
	/**
	 * 应用模板
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String applyTemplate(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		int contractId = BaseHelpUtils.getIntValue(params, "contractId");
		int templateId = BaseHelpUtils.getIntValue(params, "templateId");
		BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(params.get("signingMoneySum"));
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		if(cDao.load()){
			ContractReceivableTemplate crtDao = new ContractReceivableTemplate();
			crtDao.setContractReceivableTemplateId(templateId);
			if(crtDao.load()){
				String contractCode = cDao.getContractCode();
				String infoCode = cDao.getInfoCode();
				String projectCode = cDao.getProjectCode();
				ContractReceivable crDao = new ContractReceivable();
				crtDao.clear();
				crtDao.setConditionParentId("=", templateId);
				List<BaseContractReceivableTemplate> list = crtDao.conditionalLoad();
				if(list.size()<=0) {
					status = -1;
					errorMsg = "模板下没有收款阶段" ;
				}else {
					ThreadConnection.beginTransaction();
					//向收款阶段表插入子级模板
					List<BaseContractReceivable> baseList =new ArrayList<>();
					BigDecimal hundred = new BigDecimal(100);
					BigDecimal value  =BigDecimal.ZERO;
					for (int i = 0; i < list.size(); i++) {
						BaseContractReceivableTemplate baseContractReceivableTemplate = list.get(i);
						BigDecimal receivablePercentage = BaseHelpUtils.getBigDecimalValue(baseContractReceivableTemplate.getReceivablePercentage());
						BigDecimal receivableSumMoney = BigDecimal.ZERO;
						if(i==(list.size()-1)) {
							receivableSumMoney=signingMoneySum.subtract(value);
						}else {
							receivableSumMoney = receivablePercentage.multiply(signingMoneySum).divide(hundred, 2, BigDecimal.ROUND_HALF_UP);
							value =value.add(receivableSumMoney);
						}
						BaseContractReceivable base =new BaseContractReceivable();
//						crDao.setParentId(parentId);
						base.setContractCode(contractCode);
						base.setContractId(contractId);
						base.setInfoCode(infoCode);
						base.setProjectCode(projectCode);
						base.setReceivableName(baseContractReceivableTemplate.getReceivableName());
						base.setReceivablePercentage(receivablePercentage);
						base.setReceivableSumMoney(receivableSumMoney);
						baseList.add(base);
					}
					
					crDao.clear();
					crDao.setConditionContractId("=", contractId);
					crDao.conditionalDelete();
					
					crDao.clear();
					crDao.save(baseList);
					ThreadConnection.commit();
				}
			}else{
				status = -1;
				errorMsg = "顶级模板不存在 templateId = " + templateId;
			}
			
		}else{
			status = -1;
			errorMsg = "合同不存在  contractId = " + contractId;
		}
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}

	/**
	 * 获取所有顶级的模板
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String getParentTemplate() throws SQLException {
		int status = 1;
		BaseCollection<CustomBaseIddStrVal> bc = new BaseCollection<>();
		ContractReceivableTemplate dao = new ContractReceivableTemplate();
		dao.setConditionParentId("=", 0);
		List<BaseContractReceivableTemplate> list = dao.conditionalLoad();
		List<CustomBaseIddStrVal> dataList = new ArrayList<>();
		for (BaseContractReceivableTemplate baseContractReceivableTemplate : list) {
			CustomBaseIddStrVal tmpBean = new CustomBaseIddStrVal();
			tmpBean.setIdd(baseContractReceivableTemplate.getContractReceivableTemplateId().toString());
			tmpBean.setVal(baseContractReceivableTemplate.getReceivableName());
			dataList.add(tmpBean);
		}
		bc.setCollections(dataList);
		return bc.toJSON(status, null);
	}

}

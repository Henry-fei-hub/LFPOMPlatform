package pomplatform.contractsRecords.handler;

import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseContractsRecords;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractsRecords;
import com.pomplatform.db.dao.PreProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AddContractsRecords implements GenericProcessor {
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		/*
		 * 注 ContractsRecords 中contract_amount字段
		 * 与
		 * Contract 中signing_money_sum
		 * 字段 相等  
		 * 表示合同金额
		 */
		int status=-1;
		BaseCollection bc = new BaseCollection<>();
		Date currentDate = new Date();
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		BaseContractsRecords bean=new BaseContractsRecords();
		ContractsRecords dao=new ContractsRecords();
		Contract cDao=new Contract();
		//获取合同id
		int contractId = BaseHelpUtils.getIntValue(params,"contractId");
		//获取前期项目ID
		int prePojectId=BaseHelpUtils.getIntValue(params,"prePojectId");
		if(prePojectId>0) {
			PreProject pDao=new PreProject();
			pDao.setPreProjectId(prePojectId);
			if(pDao.load()) {//如果前期项目存在此项目
				String relevantEmployees=params.get("relevantEmployees").toString().replace("[", "").replace("]", "");  
				String relevantEmployeesName=params.get("relevantEmployeesName").toString().replace("[", "").replace("]", ""); 
				params.put("relevantEmployees", relevantEmployees);
				params.put("relevantEmployeesName", relevantEmployeesName);
				//插入ContractsRecords表数据
				bean.setDataFromMap(params);
				bean.setTrackDate(new Date());
				bean.setRegisterDate(new Date());
				dao.setDataFromBase(bean);
				dao.save();
				//获取infoCode
				String infoCode=bean.getInfoCode();
				if(infoCode.length()>0) {
					dao.setConditionInfoCode("=", infoCode);
					List<BaseContractsRecords> list=dao.conditionalLoad();
					int contractIds=0;
					String contractName=null;
					for (BaseContractsRecords baseContractsRecords : list) {
						//获取合同id
						contractIds=BaseHelpUtils.getIntValue(baseContractsRecords.getContractId());
						contractName=BaseHelpUtils.getString(baseContractsRecords.getContractName());
						if(contractIds>0&&contractName.length()>0) {
							break;
						}
					}
					dao.setConditionContractsRecordsId("=", BaseHelpUtils.getIntValue(dao.getContractsRecordsId()));
					dao.setContractName(contractName);
					dao.conditionalUpdate();
					dao.clear();
					cDao.setContractId(contractIds);
					if(cDao.load()) {
						//同时更新合同Contract里的签约合同金额与客户名称与合同签订状态,合同跟进人
						cDao.setSigningMoneySum(BaseHelpUtils.getBigDecimalValue(params.get("contractAmount")));//签约合同金额
						cDao.setContractSigningStatus(BaseHelpUtils.getIntValue(params.get("contractStatus")));//合同签订状态
						cDao.setCustomerName(BaseHelpUtils.getString(params.get("customerName")));//客户名称
						cDao.setRelevantEmployeesName(BaseHelpUtils.getString(params.get("relevantEmployeesName")));//合同跟进人
						cDao.setRelevantEmployees(BaseHelpUtils.getString(params.get("relevantEmployees")));//合同跟进人id
						Long contractDateL=BaseHelpUtils.getLongValue(params.get("contractDate"));
						Long sendingDateL=BaseHelpUtils.getLongValue(params.get("sendingDate"));
						if(!BaseHelpUtils.isNullOrEmpty(contractDateL)&&contractDateL>0) {
							cDao.setContractDate(new Date(contractDateL));//合同签订日期
						}
						if(!BaseHelpUtils.isNullOrEmpty(sendingDateL)&&sendingDateL>0) {
							cDao.setSendingDate(new Date(sendingDateL));//合同寄出日期
						}
						cDao.update();
						cDao.clear();
					}
				}
				status=1;
			}
			return bc.toJSON(status,"保存异常");
		}else if(contractId>0) {
			cDao.setContractId(contractId);
			if(cDao.load()) {
				String relevantEmployees=params.get("relevantEmployees").toString().replace("[", "").replace("]", "");  
				String relevantEmployeesName=params.get("relevantEmployeesName").toString().replace("[", "").replace("]", ""); 
				params.put("relevantEmployees", relevantEmployees);
				params.put("relevantEmployeesName", relevantEmployeesName);
				//插入ContractsRecords表数据
				bean.setDataFromMap(params);
				bean.setTrackDate(new Date());
				bean.setRegisterDate(new Date());
				bean.setContractName(cDao.getContractName());
				dao.setDataFromBase(bean);
				dao.save();
				//同时更新合同Contract里的签约合同金额与客户名称与合同签订状态,合同跟进人
				cDao.setSigningMoneySum(BaseHelpUtils.getBigDecimalValue(params.get("contractAmount")));//签约合同金额
				cDao.setContractSigningStatus(BaseHelpUtils.getIntValue(params.get("contractStatus")));//合同签订状态
				cDao.setCustomerName(BaseHelpUtils.getString(params.get("customerName")));//客户名称
				cDao.setRelevantEmployeesName(BaseHelpUtils.getString(params.get("relevantEmployeesName")));//合同跟进人
				cDao.setRelevantEmployees(BaseHelpUtils.getString(params.get("relevantEmployees")));//合同跟进人id
				Long contractDateL=BaseHelpUtils.getLongValue(params.get("contractDate"));
				Long sendingDateL=BaseHelpUtils.getLongValue(params.get("sendingDate"));
				if(!BaseHelpUtils.isNullOrEmpty(contractDateL)&&contractDateL>0) {
					cDao.setContractDate(new Date(contractDateL));//合同签订日期
				}
				if(!BaseHelpUtils.isNullOrEmpty(sendingDateL)&&sendingDateL>0) {
					cDao.setSendingDate(new Date(sendingDateL));//合同寄出日期
				}
				cDao.update();
				status=1;
			}
			return bc.toJSON(status,"保存异常");
		}
		return bc.toJSON(status,"保存异常");
	}
}

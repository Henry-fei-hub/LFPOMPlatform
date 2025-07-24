package pomplatform.contractreceivablecipor.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCapitalDistribution;
import com.pomplatform.db.bean.BaseContractReceivable;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.CustomBaseCapitalDistribution;
import com.pomplatform.db.dao.BudgetAttachment;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistribution;
import com.pomplatform.db.dao.CapitalLog;
import com.pomplatform.db.dao.ContractReceivable;
import com.pomplatform.db.dao.PaymentSequence;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.capitaldistribution.bean.BaseAutoFitInfo;
import pomplatform.capitaldistribution.bean.BaseGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.BaseGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.BaseLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.BaseSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.BaseSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.BaseSumCapitalDistribution;
import pomplatform.capitaldistribution.bean.BaseSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionAutoFitInfo;
import pomplatform.capitaldistribution.bean.ConditionGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.ConditionGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.ConditionLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.ConditionSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.query.QueryAutoFitInfo;
import pomplatform.capitaldistribution.query.QueryGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.query.QueryGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.query.QueryLeftCapitalAmount;
import pomplatform.capitaldistribution.query.QuerySearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumCapitalBorrowMoney;
import pomplatform.capitaldistribution.query.QuerySumCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumDepartmentCapitalDistribution;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;

public class ContractReceivableProcessor implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {
		case "saveContractReceivable":
			return saveContractReceivable(params);
		case "saveContractReceivableList":
			return saveContractReceivableList(params);
		default:
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("contractId",2009);
		params.put("contractReceivableId",8249);
		params.put("signingMoneySum",2000000);
		params.put("receivablePercentage",5);
		saveContractReceivable(params);
	}
	
	
	public static String saveContractReceivableList(Map<String, Object> params) throws Exception {
		ThreadConnection.beginTransaction();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		if(contractId<=0) {
			throw new SQLException("合同信息获取失败");
		}
		List<BaseContractReceivable> contractReceivableList = GenericBase.__getList(params.get("contractReceivableList"),BaseContractReceivable.newInstance());
		if(contractReceivableList.size()<=-0) {
			throw new SQLException("数据集为空！");
		}else {
			ContractReceivable cr =new ContractReceivable();
			cr.setConditionContractId("=", contractId);
			cr.conditionalDelete();
			
			BigDecimal percent =BigDecimal.ZERO;
			for (BaseContractReceivable baseContractReceivable : contractReceivableList) {
				BigDecimal value = BaseHelpUtils.getBigDecimalValue(baseContractReceivable.getReceivablePercentage());
				if(value.compareTo(BigDecimal.ZERO)<=0) {
					throw new SQLException("收款阶段比例不能小于等于0");
				}
				percent =percent.add(value);
			}
			
			if(percent.compareTo(new BigDecimal(100))!=0) {
				throw new SQLException("收款阶段比例不等于100");
			}
			cr.clear();
			cr.save(contractReceivableList);
		}
		ThreadConnection.commit();
		return bc.toJSON();
	}
	

	public static String saveContractReceivable(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		
		if(BaseHelpUtils.getIntValue(params.get("contractId"))<=0) {
			throw new SQLException("合同信息获取失败");
		}
		ContractReceivable cr =new ContractReceivable();
		if(BaseHelpUtils.getIntValue(params.get("parentId"))==0) {//父节点
			cr.setConditionContractId("=", BaseHelpUtils.getIntValue(params.get("contractId")));
			cr.setConditionParentId("=", 0);
			cr.setConditionContractReceivableId("!=", BaseHelpUtils.getIntValue(params.get("contractReceivableId")));
			List<BaseContractReceivable> conditionalLoad = cr.conditionalLoad();
			BigDecimal receivableSumMoneySum =BigDecimal.ZERO;
			BigDecimal receivableSumMoney =BigDecimal.ZERO;
			BigDecimal receivablePercentageSum =BigDecimal.ZERO;
			BigDecimal hundred =new BigDecimal(100);
			if(conditionalLoad.size()>0) {
				for (BaseContractReceivable baseContractReceivable : conditionalLoad) {
					receivablePercentageSum =receivablePercentageSum.add(BaseHelpUtils.getBigDecimalValue(baseContractReceivable.getReceivablePercentage()));	
					receivableSumMoneySum =receivableSumMoneySum.add(BaseHelpUtils.getBigDecimalValue(baseContractReceivable.getReceivableSumMoney()));	
				}
			}
			BigDecimal subtract = hundred.subtract(receivablePercentageSum);
			
			BigDecimal receivablePercentage = BaseHelpUtils.getBigDecimalValue(params.get("receivablePercentage"));
			
			BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(params.get("signingMoneySum"));
			
			if(receivablePercentageSum.compareTo(hundred)>0||subtract.compareTo(hundred)>0||subtract.compareTo(BigDecimal.ZERO)<=0) {
				throw new SQLException("其余父节点收款阶段已经达到100%");
			}else if(receivablePercentage.compareTo(BigDecimal.ZERO)<0 ||receivablePercentage.compareTo(hundred)>0){
				throw new SQLException("本父节点阶段比例取值范围应在0-100%，请重新赋值");
			}else if(receivablePercentage.compareTo(subtract)>0) {
				throw new SQLException("剩余父节点阶段比例取值范围应在0-"+subtract.setScale(2)+"%，请重新赋值");
			}
			
			if((receivablePercentageSum.add(receivablePercentage)).compareTo(hundred)==0) {
				receivableSumMoney= signingMoneySum.subtract(receivableSumMoneySum);
			}else {
				receivableSumMoney = signingMoneySum.multiply(receivablePercentage).multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
			}
			
			BaseContractReceivable base =new BaseContractReceivable();
			base.setDataFromMap(params);
			base.setReceivableSumMoney(receivableSumMoney);
			cr.clear();
			cr.setDataFromBase(base);
			if(BaseHelpUtils.getIntValue(params.get("contractReceivableId"))>0) {
				cr.setUpdateTime(new Date());
				cr.update();
			}else {
				cr.setCreateTime(new Date());
				cr.save();
			}
		}else {
			BigDecimal hundred =new BigDecimal(100);
			BigDecimal receivableSumMoneySum =BigDecimal.ZERO;
			BigDecimal receivableSumMoney =BigDecimal.ZERO;
			BigDecimal receivablePercentageSum =BigDecimal.ZERO;
			BigDecimal receivablePercentage = BaseHelpUtils.getBigDecimalValue(params.get("receivablePercentage"));
			BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(params.get("signingMoneySum"));
			
			
			cr.setConditionContractId("=", BaseHelpUtils.getIntValue(params.get("contractId")));
//			cr.setConditionParentId("=", 0);
			cr.setConditionContractReceivableId("=", BaseHelpUtils.getIntValue(params.get("parentId")));
			BaseContractReceivable executeQueryOneRow = cr.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
				 hundred = BaseHelpUtils.getBigDecimalValue(executeQueryOneRow.getReceivablePercentage());
				 signingMoneySum = BaseHelpUtils.getBigDecimalValue(executeQueryOneRow.getReceivableSumMoney());
			}
			
			cr.clear();
			cr.setConditionContractId("=", BaseHelpUtils.getIntValue(params.get("contractId")));
			cr.setConditionParentId(">", 0);
			cr.setConditionContractReceivableId("!=", BaseHelpUtils.getIntValue(params.get("contractReceivableId")));
			List<BaseContractReceivable> conditionalLoad = cr.conditionalLoad();
			if(conditionalLoad.size()>0) {
				for (BaseContractReceivable baseContractReceivable : conditionalLoad) {
					receivablePercentageSum =receivablePercentageSum.add(BaseHelpUtils.getBigDecimalValue(baseContractReceivable.getReceivablePercentage()));	
					receivableSumMoneySum =receivableSumMoneySum.add(BaseHelpUtils.getBigDecimalValue(baseContractReceivable.getReceivableSumMoney()));	
				}
			}
			
			BigDecimal subtract = hundred.subtract(receivablePercentageSum);
			if(receivablePercentageSum.compareTo(hundred)>0||subtract.compareTo(hundred)>0||subtract.compareTo(BigDecimal.ZERO)<=0) {
				throw new SQLException("其余收款阶段已经达到"+hundred+"%");
			}else if(receivablePercentage.compareTo(BigDecimal.ZERO)<0 ||receivablePercentage.compareTo(hundred)>0){
				throw new SQLException("本阶段比例取值范围应在0-"+hundred+"%,请重新赋值");
			}else if(receivablePercentage.compareTo(subtract)>0) {
				throw new SQLException("剩余阶段比例取值范围应在0-"+subtract.setScale(2)+"%，请重新赋值");
			}
			
			if((receivablePercentageSum.add(receivablePercentage)).compareTo(hundred)==0) {
				receivableSumMoney= signingMoneySum.subtract(receivableSumMoneySum);
			}else {
				signingMoneySum = BaseHelpUtils.getBigDecimalValue(params.get("signingMoneySum"));
				receivableSumMoney = signingMoneySum.multiply(receivablePercentage).multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
			}
			
			BaseContractReceivable base =new BaseContractReceivable();
			base.setDataFromMap(params);
			base.setReceivableSumMoney(receivableSumMoney);
			cr.clear();
			cr.setDataFromBase(base);
			if(BaseHelpUtils.getIntValue(params.get("contractReceivableId"))>0) {
				cr.setUpdateTime(new Date());
				cr.update();
			}else {
				cr.setCreateTime(new Date());
				cr.save();
			}
		}
		
		ThreadConnection.commit();
		return bc.toJSON();
	}
}

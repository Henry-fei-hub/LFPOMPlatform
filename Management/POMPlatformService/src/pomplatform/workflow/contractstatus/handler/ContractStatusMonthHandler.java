package pomplatform.workflow.contractstatus.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.contractstatus.bean.BaseContractStatusMonth;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatusMonth;
import pomplatform.workflow.contractstatus.query.QueryContractStatusMonth;

public class ContractStatusMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractStatusMonthHandler.class);

	public static BaseCollection<BaseContractStatusMonth> executeQueryContractStatusMonth(ConditionContractStatusMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryContractStatusMonth dao = new QueryContractStatusMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractStatusMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		BaseCollection<BaseContractStatusMonth> result = new BaseCollection<>();
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        int projectManager = BaseHelpUtils.getIntValue(params.get("projectManager"));
		ConditionContractStatusMonth c = new ConditionContractStatusMonth();
		c.setDataFromMap(params);
		KeyValuePair kv = new KeyValuePair();
		kv.setKey("and b.new_status = ?");
//		switch(c.getProcessType()) {
//		case StaticUtils.PROCESS_TYPE_64:
//			//可以申请【项目暂停】的合同状态：未出结果、项目缓慢
//			kv.setValue(String.format("and b.new_status = ? and b.new_status in (%1$s, %2$s)", StaticUtils.CONTRACT_STATUS_1, StaticUtils.CONTRACT_STATUS_4));
//			break;
//		case StaticUtils.PROCESS_TYPE_65:
//			//可以申请【项目终止】的合同状态：未出结果、项目缓慢、项目暂停
//			if(projectManager > 0) {
//				//项目终止不通过点按钮走流程，所以这里直接返回空就行
//				return result.toJSON();
//			}else {
//				//留个口给运营中心的人提项目终止申请
//				kv.setValue(String.format("and b.new_status = ? and b.new_status in (%1$s, %2$s, %3$s)", StaticUtils.CONTRACT_STATUS_1, StaticUtils.CONTRACT_STATUS_4, StaticUtils.CONTRACT_STATUS_5));
//				break;
//			}
//		case StaticUtils.PROCESS_TYPE_66:
//			//可以申请【合同暂停】的合同状态：合同运行、合同收尾、合同缓慢
//			kv.setValue(String.format("and b.new_status = ? and b.new_status in (%1$s, %2$s, %3$s)", StaticUtils.CONTRACT_STATUS_6, StaticUtils.CONTRACT_STATUS_7, StaticUtils.CONTRACT_STATUS_9));
//			break;
//		case StaticUtils.PROCESS_TYPE_67:
//			//可以申请【合同终止】的合同状态：合同运行、合同收尾、合同缓慢、合同暂停
//			kv.setValue(String.format("and b.new_status = ? and b.new_status in (%1$s, %2$s, %3$s, %4$s)", StaticUtils.CONTRACT_STATUS_6, StaticUtils.CONTRACT_STATUS_7, StaticUtils.CONTRACT_STATUS_9, StaticUtils.CONTRACT_STATUS_8));
//			break;
//		case StaticUtils.PROCESS_TYPE_69:
//			//可以申请【项目重启】的合同状态：项目暂停
//			c.setNewStatus(StaticUtils.CONTRACT_STATUS_5);
//			break;   
//		case StaticUtils.PROCESS_TYPE_70:
//			//可以申请【合同重启】的合同状态：合同暂停
//			c.setNewStatus(StaticUtils.CONTRACT_STATUS_8);
//			break;   
//		default:
//			break;
//		}
		Set<KeyValuePair> set = new HashSet<>();
		if(!BaseHelpUtils.isNullOrEmpty(kv.getValue())) {
			set.add(kv);
		}
		if(projectManager > 0) {
			KeyValuePair projectManagerKV = new KeyValuePair();
			projectManagerKV.setKey("group by k.contract_id, k.contract_age");
			projectManagerKV.setValue(String.format("where c.contract_id in (select DISTINCT contract_id from projects where project_type = %1$s and contract_id > 0 and project_manage_id = %2$s) group by k.contract_id, k.contract_age", StaticUtils.PROJECT_TYPE_16, projectManager));
			set.add(projectManagerKV);
		}
		int size = set.size();
		if(size > 0) {
			KeyValuePair[] kvs = new KeyValuePair[size];
			int i = 0;
			for(KeyValuePair obj : set) {
				kvs[i] = obj;
				i++;
			}
			c.setKeyValues(kvs);
		}
		result = executeQueryContractStatusMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractStatusMonth> result;
		ConditionContractStatusMonth c = new ConditionContractStatusMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractStatusMonth dao = new QueryContractStatusMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractStatusMonth.ALL_CAPTIONS);
			for(BaseContractStatusMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



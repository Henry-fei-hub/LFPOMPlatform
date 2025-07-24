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
import pomplatform.workflow.contractstatus.bean.BaseChangeContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionChangeContractStatus;
import pomplatform.workflow.contractstatus.query.QueryChangeContractStatus;

public class ChangeContractStatusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ChangeContractStatusHandler.class);

	public static BaseCollection<BaseChangeContractStatus> executeQueryChangeContractStatus(ConditionChangeContractStatus c, KeyValuePair[] replacements ) throws Exception {
		QueryChangeContractStatus dao = new QueryChangeContractStatus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseChangeContractStatus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        int projectManager = BaseHelpUtils.getIntValue(params.get("projectManager"));
		ConditionChangeContractStatus c = new ConditionChangeContractStatus();
		c.setDataFromMap(params);
		Set<KeyValuePair> set = new HashSet<>();
		if(projectManager > 0) {
			KeyValuePair projectManagerKV = new KeyValuePair();
			projectManagerKV.setKey("where c.contract_id = ?");
			projectManagerKV.setValue(String.format("where c.contract_id = ? and c.contract_id in (select DISTINCT contract_id from projects where contract_id > 0 and project_manage_id = %1$s and (parent_id = 0 or (parent_id = 1 and project_type = %2$s)))", projectManager, StaticUtils.PROJECT_TYPE_16));
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
		BaseCollection<BaseChangeContractStatus> result = executeQueryChangeContractStatus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseChangeContractStatus> result;
		ConditionChangeContractStatus c = new ConditionChangeContractStatus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryChangeContractStatus dao = new QueryChangeContractStatus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseChangeContractStatus.ALL_CAPTIONS);
			for(BaseChangeContractStatus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.workflow.contractstatus.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.contractstatus.bean.BaseApplyListOfChangeContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionApplyListOfChangeContractStatus;
import pomplatform.workflow.contractstatus.query.QueryApplyListOfChangeContractStatus;

public class ApplyListOfChangeContractStatusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ApplyListOfChangeContractStatusHandler.class);

	public static BaseCollection<BaseApplyListOfChangeContractStatus> executeQueryApplyListOfChangeContractStatus(ConditionApplyListOfChangeContractStatus c, KeyValuePair[] replacements ) throws Exception {
		QueryApplyListOfChangeContractStatus dao = new QueryApplyListOfChangeContractStatus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseApplyListOfChangeContractStatus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionApplyListOfChangeContractStatus c = new ConditionApplyListOfChangeContractStatus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseApplyListOfChangeContractStatus> result = executeQueryApplyListOfChangeContractStatus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseApplyListOfChangeContractStatus> result;
		ConditionApplyListOfChangeContractStatus c = new ConditionApplyListOfChangeContractStatus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryApplyListOfChangeContractStatus dao = new QueryApplyListOfChangeContractStatus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseApplyListOfChangeContractStatus.ALL_CAPTIONS);
			for(BaseApplyListOfChangeContractStatus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



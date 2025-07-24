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
import pomplatform.workflow.contractstatus.bean.BaseSelectContracts;
import pomplatform.workflow.contractstatus.bean.ConditionSelectContracts;
import pomplatform.workflow.contractstatus.query.QuerySelectContracts;

public class SelectContractsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectContractsHandler.class);

	public static BaseCollection<BaseSelectContracts> executeQuerySelectContracts(ConditionSelectContracts c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectContracts dao = new QuerySelectContracts();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectContracts> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectContracts c = new ConditionSelectContracts();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectContracts> result = executeQuerySelectContracts(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectContracts> result;
		ConditionSelectContracts c = new ConditionSelectContracts();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectContracts dao = new QuerySelectContracts();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectContracts.ALL_CAPTIONS);
			for(BaseSelectContracts b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



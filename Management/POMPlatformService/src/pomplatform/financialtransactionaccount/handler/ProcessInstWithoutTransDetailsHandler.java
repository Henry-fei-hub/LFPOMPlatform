package pomplatform.financialtransactionaccount.handler;

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
import pomplatform.financialtransactionaccount.bean.BaseProcessInstWithoutTransDetails;
import pomplatform.financialtransactionaccount.bean.ConditionProcessInstWithoutTransDetails;
import pomplatform.financialtransactionaccount.query.QueryProcessInstWithoutTransDetails;

public class ProcessInstWithoutTransDetailsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProcessInstWithoutTransDetailsHandler.class);

	public static BaseCollection<BaseProcessInstWithoutTransDetails> executeQueryProcessInstWithoutTransDetails(ConditionProcessInstWithoutTransDetails c, KeyValuePair[] replacements ) throws Exception {
		QueryProcessInstWithoutTransDetails dao = new QueryProcessInstWithoutTransDetails();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProcessInstWithoutTransDetails> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProcessInstWithoutTransDetails c = new ConditionProcessInstWithoutTransDetails();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProcessInstWithoutTransDetails> result = executeQueryProcessInstWithoutTransDetails(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProcessInstWithoutTransDetails> result;
		ConditionProcessInstWithoutTransDetails c = new ConditionProcessInstWithoutTransDetails();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProcessInstWithoutTransDetails dao = new QueryProcessInstWithoutTransDetails();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProcessInstWithoutTransDetails.ALL_CAPTIONS);
			for(BaseProcessInstWithoutTransDetails b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



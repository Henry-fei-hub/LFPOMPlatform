package pomplatform.workflow.contractstatus.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.contractstatus.bean.BaseContractThatCanEnd;
import pomplatform.workflow.contractstatus.bean.ConditionContractThatCanEnd;
import pomplatform.workflow.contractstatus.query.QueryContractThatCanEnd;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class ContractThatCanEndHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractThatCanEndHandler.class);

	public static BaseCollection<BaseContractThatCanEnd> executeQueryContractThatCanEnd(ConditionContractThatCanEnd c, KeyValuePair[] replacements ) throws Exception {
		QueryContractThatCanEnd dao = new QueryContractThatCanEnd();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractThatCanEnd> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractThatCanEnd c = new ConditionContractThatCanEnd();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractThatCanEnd> result = executeQueryContractThatCanEnd(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractThatCanEnd> result;
		ConditionContractThatCanEnd c = new ConditionContractThatCanEnd();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractThatCanEnd dao = new QueryContractThatCanEnd();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractThatCanEnd.ALL_CAPTIONS);
			for(BaseContractThatCanEnd b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



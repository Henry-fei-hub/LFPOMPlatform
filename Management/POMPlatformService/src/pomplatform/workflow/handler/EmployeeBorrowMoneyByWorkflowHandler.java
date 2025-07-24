package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseEmployeeBorrowMoneyByWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeBorrowMoneyByWorkflow;
import pomplatform.workflow.query.QueryEmployeeBorrowMoneyByWorkflow;
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

public class EmployeeBorrowMoneyByWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeBorrowMoneyByWorkflowHandler.class);

	public static BaseCollection<BaseEmployeeBorrowMoneyByWorkflow> executeQueryEmployeeBorrowMoneyByWorkflow(ConditionEmployeeBorrowMoneyByWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeBorrowMoneyByWorkflow dao = new QueryEmployeeBorrowMoneyByWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeBorrowMoneyByWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeBorrowMoneyByWorkflow c = new ConditionEmployeeBorrowMoneyByWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeBorrowMoneyByWorkflow> result = executeQueryEmployeeBorrowMoneyByWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeBorrowMoneyByWorkflow> result;
		ConditionEmployeeBorrowMoneyByWorkflow c = new ConditionEmployeeBorrowMoneyByWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeBorrowMoneyByWorkflow dao = new QueryEmployeeBorrowMoneyByWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeBorrowMoneyByWorkflow.ALL_CAPTIONS);
			for(BaseEmployeeBorrowMoneyByWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



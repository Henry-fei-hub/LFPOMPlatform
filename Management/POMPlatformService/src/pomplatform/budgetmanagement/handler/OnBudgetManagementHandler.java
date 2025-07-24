package pomplatform.budgetmanagement.handler;

import org.apache.log4j.Logger;
import pomplatform.budgetmanagement.bean.BaseOnBudgetManagement;
import pomplatform.budgetmanagement.bean.ConditionOnBudgetManagement;
import pomplatform.budgetmanagement.query.QueryOnBudgetManagement;
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

public class OnBudgetManagementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnBudgetManagementHandler.class);

	public static BaseCollection<BaseOnBudgetManagement> executeQueryOnBudgetManagement(ConditionOnBudgetManagement c, KeyValuePair[] replacements ) throws Exception {
		QueryOnBudgetManagement dao = new QueryOnBudgetManagement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnBudgetManagement> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnBudgetManagement c = new ConditionOnBudgetManagement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnBudgetManagement> result = executeQueryOnBudgetManagement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnBudgetManagement> result;
		ConditionOnBudgetManagement c = new ConditionOnBudgetManagement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnBudgetManagement dao = new QueryOnBudgetManagement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnBudgetManagement.ALL_CAPTIONS);
			for(BaseOnBudgetManagement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



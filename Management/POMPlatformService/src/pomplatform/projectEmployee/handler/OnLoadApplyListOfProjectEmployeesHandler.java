package pomplatform.projectEmployee.handler;

import org.apache.log4j.Logger;
import pomplatform.projectEmployee.bean.BaseOnLoadApplyListOfProjectEmployees;
import pomplatform.projectEmployee.bean.ConditionOnLoadApplyListOfProjectEmployees;
import pomplatform.projectEmployee.query.QueryOnLoadApplyListOfProjectEmployees;
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

public class OnLoadApplyListOfProjectEmployeesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfProjectEmployeesHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfProjectEmployees> executeQueryOnLoadApplyListOfProjectEmployees(ConditionOnLoadApplyListOfProjectEmployees c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfProjectEmployees dao = new QueryOnLoadApplyListOfProjectEmployees();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfProjectEmployees> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfProjectEmployees c = new ConditionOnLoadApplyListOfProjectEmployees();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfProjectEmployees> result = executeQueryOnLoadApplyListOfProjectEmployees(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfProjectEmployees> result;
		ConditionOnLoadApplyListOfProjectEmployees c = new ConditionOnLoadApplyListOfProjectEmployees();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfProjectEmployees dao = new QueryOnLoadApplyListOfProjectEmployees();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfProjectEmployees.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfProjectEmployees b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



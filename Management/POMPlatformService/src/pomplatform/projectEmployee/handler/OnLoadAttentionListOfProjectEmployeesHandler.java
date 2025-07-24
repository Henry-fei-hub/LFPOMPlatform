package pomplatform.projectEmployee.handler;

import org.apache.log4j.Logger;
import pomplatform.projectEmployee.bean.BaseOnLoadAttentionListOfProjectEmployees;
import pomplatform.projectEmployee.bean.ConditionOnLoadAttentionListOfProjectEmployees;
import pomplatform.projectEmployee.query.QueryOnLoadAttentionListOfProjectEmployees;
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

public class OnLoadAttentionListOfProjectEmployeesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfProjectEmployeesHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfProjectEmployees> executeQueryOnLoadAttentionListOfProjectEmployees(ConditionOnLoadAttentionListOfProjectEmployees c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfProjectEmployees dao = new QueryOnLoadAttentionListOfProjectEmployees();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfProjectEmployees> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfProjectEmployees c = new ConditionOnLoadAttentionListOfProjectEmployees();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfProjectEmployees> result = executeQueryOnLoadAttentionListOfProjectEmployees(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfProjectEmployees> result;
		ConditionOnLoadAttentionListOfProjectEmployees c = new ConditionOnLoadAttentionListOfProjectEmployees();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfProjectEmployees dao = new QueryOnLoadAttentionListOfProjectEmployees();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfProjectEmployees.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfProjectEmployees b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



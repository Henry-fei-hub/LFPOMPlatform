package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectEmployeePerformance;
import pomplatform.project.bean.ConditionOnLoadProjectEmployeePerformance;
import pomplatform.project.query.QueryOnLoadProjectEmployeePerformance;
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

public class OnLoadProjectEmployeePerformanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectEmployeePerformanceHandler.class);

	public static BaseCollection<BaseOnLoadProjectEmployeePerformance> executeQueryOnLoadProjectEmployeePerformance(ConditionOnLoadProjectEmployeePerformance c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectEmployeePerformance dao = new QueryOnLoadProjectEmployeePerformance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectEmployeePerformance> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectEmployeePerformance c = new ConditionOnLoadProjectEmployeePerformance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectEmployeePerformance> result = executeQueryOnLoadProjectEmployeePerformance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectEmployeePerformance> result;
		ConditionOnLoadProjectEmployeePerformance c = new ConditionOnLoadProjectEmployeePerformance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectEmployeePerformance dao = new QueryOnLoadProjectEmployeePerformance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectEmployeePerformance.ALL_CAPTIONS);
			for(BaseOnLoadProjectEmployeePerformance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



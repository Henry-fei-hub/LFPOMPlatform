package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectChangeEmployee;
import pomplatform.project.bean.ConditionOnLoadProjectChangeEmployee;
import pomplatform.project.query.QueryOnLoadProjectChangeEmployee;
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

public class OnLoadProjectChangeEmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectChangeEmployeeHandler.class);

	public static BaseCollection<BaseOnLoadProjectChangeEmployee> executeQueryOnLoadProjectChangeEmployee(ConditionOnLoadProjectChangeEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectChangeEmployee dao = new QueryOnLoadProjectChangeEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectChangeEmployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectChangeEmployee c = new ConditionOnLoadProjectChangeEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectChangeEmployee> result = executeQueryOnLoadProjectChangeEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectChangeEmployee> result;
		ConditionOnLoadProjectChangeEmployee c = new ConditionOnLoadProjectChangeEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectChangeEmployee dao = new QueryOnLoadProjectChangeEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectChangeEmployee.ALL_CAPTIONS);
			for(BaseOnLoadProjectChangeEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



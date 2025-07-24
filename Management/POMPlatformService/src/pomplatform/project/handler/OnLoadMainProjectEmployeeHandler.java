package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployee;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployee;
import pomplatform.project.query.QueryOnLoadMainProjectEmployee;
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

public class OnLoadMainProjectEmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMainProjectEmployeeHandler.class);

	public static BaseCollection<BaseOnLoadMainProjectEmployee> executeQueryOnLoadMainProjectEmployee(ConditionOnLoadMainProjectEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMainProjectEmployee dao = new QueryOnLoadMainProjectEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMainProjectEmployee> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMainProjectEmployee c = new ConditionOnLoadMainProjectEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMainProjectEmployee> result = executeQueryOnLoadMainProjectEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMainProjectEmployee> result;
		ConditionOnLoadMainProjectEmployee c = new ConditionOnLoadMainProjectEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMainProjectEmployee dao = new QueryOnLoadMainProjectEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMainProjectEmployee.ALL_CAPTIONS);
			for(BaseOnLoadMainProjectEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



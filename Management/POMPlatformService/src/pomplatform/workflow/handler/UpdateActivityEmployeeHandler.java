package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseUpdateActivityEmployee;
import pomplatform.workflow.bean.ConditionUpdateActivityEmployee;
import pomplatform.workflow.query.QueryUpdateActivityEmployee;
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

public class UpdateActivityEmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(UpdateActivityEmployeeHandler.class);

	public static BaseCollection<BaseUpdateActivityEmployee> executeQueryUpdateActivityEmployee(ConditionUpdateActivityEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryUpdateActivityEmployee dao = new QueryUpdateActivityEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseUpdateActivityEmployee> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionUpdateActivityEmployee c = new ConditionUpdateActivityEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseUpdateActivityEmployee> result = executeQueryUpdateActivityEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseUpdateActivityEmployee> result;
		ConditionUpdateActivityEmployee c = new ConditionUpdateActivityEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryUpdateActivityEmployee dao = new QueryUpdateActivityEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseUpdateActivityEmployee.ALL_CAPTIONS);
			for(BaseUpdateActivityEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



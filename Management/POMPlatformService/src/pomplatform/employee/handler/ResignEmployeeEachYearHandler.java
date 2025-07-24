package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseResignEmployeeEachYear;
import pomplatform.employee.bean.ConditionResignEmployeeEachYear;
import pomplatform.employee.query.QueryResignEmployeeEachYear;
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

public class ResignEmployeeEachYearHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ResignEmployeeEachYearHandler.class);

	public static BaseCollection<BaseResignEmployeeEachYear> executeQueryResignEmployeeEachYear(ConditionResignEmployeeEachYear c, KeyValuePair[] replacements ) throws Exception {
		QueryResignEmployeeEachYear dao = new QueryResignEmployeeEachYear();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseResignEmployeeEachYear> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionResignEmployeeEachYear c = new ConditionResignEmployeeEachYear();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseResignEmployeeEachYear> result = executeQueryResignEmployeeEachYear(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseResignEmployeeEachYear> result;
		ConditionResignEmployeeEachYear c = new ConditionResignEmployeeEachYear();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryResignEmployeeEachYear dao = new QueryResignEmployeeEachYear();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseResignEmployeeEachYear.ALL_CAPTIONS);
			for(BaseResignEmployeeEachYear b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



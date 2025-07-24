package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseResignEmployeeEachMonth;
import pomplatform.employee.bean.ConditionResignEmployeeEachMonth;
import pomplatform.employee.query.QueryResignEmployeeEachMonth;
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

public class ResignEmployeeEachMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ResignEmployeeEachMonthHandler.class);

	public static BaseCollection<BaseResignEmployeeEachMonth> executeQueryResignEmployeeEachMonth(ConditionResignEmployeeEachMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryResignEmployeeEachMonth dao = new QueryResignEmployeeEachMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseResignEmployeeEachMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionResignEmployeeEachMonth c = new ConditionResignEmployeeEachMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseResignEmployeeEachMonth> result = executeQueryResignEmployeeEachMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseResignEmployeeEachMonth> result;
		ConditionResignEmployeeEachMonth c = new ConditionResignEmployeeEachMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryResignEmployeeEachMonth dao = new QueryResignEmployeeEachMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseResignEmployeeEachMonth.ALL_CAPTIONS);
			for(BaseResignEmployeeEachMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



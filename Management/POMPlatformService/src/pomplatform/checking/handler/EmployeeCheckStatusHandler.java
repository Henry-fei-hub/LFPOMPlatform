package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseEmployeeCheckStatus;
import pomplatform.checking.bean.ConditionEmployeeCheckStatus;
import pomplatform.checking.query.QueryEmployeeCheckStatus;
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

public class EmployeeCheckStatusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeCheckStatusHandler.class);

	public static BaseCollection<BaseEmployeeCheckStatus> executeQueryEmployeeCheckStatus(ConditionEmployeeCheckStatus c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeCheckStatus dao = new QueryEmployeeCheckStatus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeCheckStatus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeCheckStatus c = new ConditionEmployeeCheckStatus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeCheckStatus> result = executeQueryEmployeeCheckStatus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeCheckStatus> result;
		ConditionEmployeeCheckStatus c = new ConditionEmployeeCheckStatus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeCheckStatus dao = new QueryEmployeeCheckStatus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeCheckStatus.ALL_CAPTIONS);
			for(BaseEmployeeCheckStatus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



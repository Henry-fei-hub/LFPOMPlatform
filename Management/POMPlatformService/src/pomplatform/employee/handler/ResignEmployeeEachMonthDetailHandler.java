package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseResignEmployeeEachMonthDetail;
import pomplatform.employee.bean.ConditionResignEmployeeEachMonthDetail;
import pomplatform.employee.query.QueryResignEmployeeEachMonthDetail;
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

public class ResignEmployeeEachMonthDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ResignEmployeeEachMonthDetailHandler.class);

	public static BaseCollection<BaseResignEmployeeEachMonthDetail> executeQueryResignEmployeeEachMonthDetail(ConditionResignEmployeeEachMonthDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryResignEmployeeEachMonthDetail dao = new QueryResignEmployeeEachMonthDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseResignEmployeeEachMonthDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionResignEmployeeEachMonthDetail c = new ConditionResignEmployeeEachMonthDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseResignEmployeeEachMonthDetail> result = executeQueryResignEmployeeEachMonthDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseResignEmployeeEachMonthDetail> result;
		ConditionResignEmployeeEachMonthDetail c = new ConditionResignEmployeeEachMonthDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryResignEmployeeEachMonthDetail dao = new QueryResignEmployeeEachMonthDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseResignEmployeeEachMonthDetail.ALL_CAPTIONS);
			for(BaseResignEmployeeEachMonthDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeesOrders;
import pomplatform.report.bean.ConditionEmployeesOrders;
import pomplatform.report.query.QueryEmployeesOrders;
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

public class EmployeesOrdersHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeesOrdersHandler.class);

	public static BaseCollection<BaseEmployeesOrders> executeQueryEmployeesOrders(ConditionEmployeesOrders c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeesOrders dao = new QueryEmployeesOrders();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeesOrders> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeesOrders c = new ConditionEmployeesOrders();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeesOrders> result = executeQueryEmployeesOrders(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeesOrders> result;
		ConditionEmployeesOrders c = new ConditionEmployeesOrders();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeesOrders dao = new QueryEmployeesOrders();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeesOrders.ALL_CAPTIONS);
			for(BaseEmployeesOrders b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeesOrders;
import pomplatform.report.bean.BaseEmployeesOrdersCustom;
import pomplatform.report.bean.ConditionEmployeesOrders;
import pomplatform.report.query.QueryEmployeesOrders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class EmployeesOrdersHandlerCustom extends EmployeesOrdersHandler {

	private static final Logger __logger = Logger.getLogger(EmployeesOrdersHandlerCustom.class);

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeesOrders> result;
		ConditionEmployeesOrders c = new ConditionEmployeesOrders();
		c.setDataFromJSON(creteria);
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
			ps.println(BaseEmployeesOrdersCustom.ALL_CAPTIONS);
			for(BaseEmployeesOrders b : result.getCollections()){
				BaseEmployeesOrdersCustom bb = new BaseEmployeesOrdersCustom();
				b.cloneCopy(bb);
				ps.println(bb.toCSVString());
			}
		}
	}
}



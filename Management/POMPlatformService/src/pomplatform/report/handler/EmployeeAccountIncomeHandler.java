package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeAccountIncome;
import pomplatform.report.bean.ConditionEmployeeAccountIncome;
import pomplatform.report.query.QueryEmployeeAccountIncome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class EmployeeAccountIncomeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeAccountIncomeHandler.class);

	public static BaseCollection<BaseEmployeeAccountIncome> executeQueryEmployeeAccountIncome(ConditionEmployeeAccountIncome c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeAccountIncome dao = new QueryEmployeeAccountIncome();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeAccountIncome> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeAccountIncome c = new ConditionEmployeeAccountIncome();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeAccountIncome> result = executeQueryEmployeeAccountIncome(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeAccountIncome> result;
		ConditionEmployeeAccountIncome c = new ConditionEmployeeAccountIncome();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeAccountIncome dao = new QueryEmployeeAccountIncome();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeAccountIncome.ALL_CAPTIONS);
			for(BaseEmployeeAccountIncome b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



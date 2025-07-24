package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseDepartmentAccountIncome;
import pomplatform.report.bean.ConditionDepartmentAccountIncome;
import pomplatform.report.query.QueryDepartmentAccountIncome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class DepartmentAccountIncomeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DepartmentAccountIncomeHandler.class);

	public static BaseCollection<BaseDepartmentAccountIncome> executeQueryDepartmentAccountIncome(ConditionDepartmentAccountIncome c, KeyValuePair[] replacements ) throws Exception {
		QueryDepartmentAccountIncome dao = new QueryDepartmentAccountIncome();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDepartmentAccountIncome> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDepartmentAccountIncome c = new ConditionDepartmentAccountIncome();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDepartmentAccountIncome> result = executeQueryDepartmentAccountIncome(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDepartmentAccountIncome> result;
		ConditionDepartmentAccountIncome c = new ConditionDepartmentAccountIncome();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDepartmentAccountIncome dao = new QueryDepartmentAccountIncome();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDepartmentAccountIncome.ALL_CAPTIONS);
			for(BaseDepartmentAccountIncome b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseProjectAccountIncome;
import pomplatform.report.bean.ConditionProjectAccountIncome;
import pomplatform.report.query.QueryProjectAccountIncome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class ProjectAccountIncomeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectAccountIncomeHandler.class);

	public static BaseCollection<BaseProjectAccountIncome> executeQueryProjectAccountIncome(ConditionProjectAccountIncome c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectAccountIncome dao = new QueryProjectAccountIncome();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectAccountIncome> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectAccountIncome c = new ConditionProjectAccountIncome();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectAccountIncome> result = executeQueryProjectAccountIncome(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectAccountIncome> result;
		ConditionProjectAccountIncome c = new ConditionProjectAccountIncome();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectAccountIncome dao = new QueryProjectAccountIncome();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectAccountIncome.ALL_CAPTIONS);
			for(BaseProjectAccountIncome b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



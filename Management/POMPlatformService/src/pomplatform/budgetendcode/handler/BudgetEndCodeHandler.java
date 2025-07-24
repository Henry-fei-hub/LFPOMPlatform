package pomplatform.budgetendcode.handler;

import org.apache.log4j.Logger;
import pomplatform.budgetendcode.bean.BaseBudgetEndCode;
import pomplatform.budgetendcode.bean.ConditionBudgetEndCode;
import pomplatform.budgetendcode.query.QueryBudgetEndCode;
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

public class BudgetEndCodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BudgetEndCodeHandler.class);

	public static BaseCollection<BaseBudgetEndCode> executeQueryBudgetEndCode(ConditionBudgetEndCode c, KeyValuePair[] replacements ) throws Exception {
		QueryBudgetEndCode dao = new QueryBudgetEndCode();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBudgetEndCode> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBudgetEndCode c = new ConditionBudgetEndCode();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBudgetEndCode> result = executeQueryBudgetEndCode(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBudgetEndCode> result;
		ConditionBudgetEndCode c = new ConditionBudgetEndCode();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBudgetEndCode dao = new QueryBudgetEndCode();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBudgetEndCode.ALL_CAPTIONS);
			for(BaseBudgetEndCode b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



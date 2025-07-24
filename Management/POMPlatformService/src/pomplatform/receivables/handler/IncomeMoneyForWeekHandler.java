package pomplatform.receivables.handler;

import org.apache.log4j.Logger;
import pomplatform.receivables.bean.BaseIncomeMoneyForWeek;
import pomplatform.receivables.bean.ConditionIncomeMoneyForWeek;
import pomplatform.receivables.query.QueryIncomeMoneyForWeek;
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

public class IncomeMoneyForWeekHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(IncomeMoneyForWeekHandler.class);

	public static BaseCollection<BaseIncomeMoneyForWeek> executeQueryIncomeMoneyForWeek(ConditionIncomeMoneyForWeek c, KeyValuePair[] replacements ) throws Exception {
		QueryIncomeMoneyForWeek dao = new QueryIncomeMoneyForWeek();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseIncomeMoneyForWeek> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionIncomeMoneyForWeek c = new ConditionIncomeMoneyForWeek();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseIncomeMoneyForWeek> result = executeQueryIncomeMoneyForWeek(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseIncomeMoneyForWeek> result;
		ConditionIncomeMoneyForWeek c = new ConditionIncomeMoneyForWeek();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryIncomeMoneyForWeek dao = new QueryIncomeMoneyForWeek();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseIncomeMoneyForWeek.ALL_CAPTIONS);
			for(BaseIncomeMoneyForWeek b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



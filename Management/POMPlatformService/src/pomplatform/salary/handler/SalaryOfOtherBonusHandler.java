package pomplatform.salary.handler;

import org.apache.log4j.Logger;
import pomplatform.salary.bean.BaseSalaryOfOtherBonus;
import pomplatform.salary.bean.ConditionSalaryOfOtherBonus;
import pomplatform.salary.query.QuerySalaryOfOtherBonus;
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

public class SalaryOfOtherBonusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryOfOtherBonusHandler.class);

	public static BaseCollection<BaseSalaryOfOtherBonus> executeQuerySalaryOfOtherBonus(ConditionSalaryOfOtherBonus c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryOfOtherBonus dao = new QuerySalaryOfOtherBonus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryOfOtherBonus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryOfOtherBonus c = new ConditionSalaryOfOtherBonus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryOfOtherBonus> result = executeQuerySalaryOfOtherBonus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryOfOtherBonus> result;
		ConditionSalaryOfOtherBonus c = new ConditionSalaryOfOtherBonus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryOfOtherBonus dao = new QuerySalaryOfOtherBonus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalaryOfOtherBonus.ALL_CAPTIONS);
			for(BaseSalaryOfOtherBonus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.salary.handler;

import org.apache.log4j.Logger;
import pomplatform.salary.bean.BaseSalaryOfShouldBonus;
import pomplatform.salary.bean.ConditionSalaryOfShouldBonus;
import pomplatform.salary.query.QuerySalaryOfShouldBonus;
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

public class SalaryOfShouldBonusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryOfShouldBonusHandler.class);

	public static BaseCollection<BaseSalaryOfShouldBonus> executeQuerySalaryOfShouldBonus(ConditionSalaryOfShouldBonus c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryOfShouldBonus dao = new QuerySalaryOfShouldBonus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryOfShouldBonus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryOfShouldBonus c = new ConditionSalaryOfShouldBonus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryOfShouldBonus> result = executeQuerySalaryOfShouldBonus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryOfShouldBonus> result;
		ConditionSalaryOfShouldBonus c = new ConditionSalaryOfShouldBonus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryOfShouldBonus dao = new QuerySalaryOfShouldBonus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalaryOfShouldBonus.ALL_CAPTIONS);
			for(BaseSalaryOfShouldBonus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



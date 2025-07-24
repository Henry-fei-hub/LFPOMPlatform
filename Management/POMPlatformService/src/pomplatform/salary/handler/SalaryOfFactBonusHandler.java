package pomplatform.salary.handler;

import org.apache.log4j.Logger;
import pomplatform.salary.bean.BaseSalaryOfFactBonus;
import pomplatform.salary.bean.ConditionSalaryOfFactBonus;
import pomplatform.salary.query.QuerySalaryOfFactBonus;
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

public class SalaryOfFactBonusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryOfFactBonusHandler.class);

	public static BaseCollection<BaseSalaryOfFactBonus> executeQuerySalaryOfFactBonus(ConditionSalaryOfFactBonus c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryOfFactBonus dao = new QuerySalaryOfFactBonus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryOfFactBonus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryOfFactBonus c = new ConditionSalaryOfFactBonus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryOfFactBonus> result = executeQuerySalaryOfFactBonus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryOfFactBonus> result;
		ConditionSalaryOfFactBonus c = new ConditionSalaryOfFactBonus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryOfFactBonus dao = new QuerySalaryOfFactBonus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalaryOfFactBonus.ALL_CAPTIONS);
			for(BaseSalaryOfFactBonus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



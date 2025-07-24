package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryAnnualBonusByCompany;
import pomplatform.payment.bean.ConditionOnSalaryAnnualBonusByCompany;
import pomplatform.payment.query.QueryOnSalaryAnnualBonusByCompany;
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

public class OnSalaryAnnualBonusByCompanyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryAnnualBonusByCompanyHandler.class);

	public static BaseCollection<BaseOnSalaryAnnualBonusByCompany> executeQueryOnSalaryAnnualBonusByCompany(ConditionOnSalaryAnnualBonusByCompany c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryAnnualBonusByCompany dao = new QueryOnSalaryAnnualBonusByCompany();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryAnnualBonusByCompany> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryAnnualBonusByCompany c = new ConditionOnSalaryAnnualBonusByCompany();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryAnnualBonusByCompany> result = executeQueryOnSalaryAnnualBonusByCompany(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryAnnualBonusByCompany> result;
		ConditionOnSalaryAnnualBonusByCompany c = new ConditionOnSalaryAnnualBonusByCompany();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryAnnualBonusByCompany dao = new QueryOnSalaryAnnualBonusByCompany();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryAnnualBonusByCompany.ALL_CAPTIONS);
			for(BaseOnSalaryAnnualBonusByCompany b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



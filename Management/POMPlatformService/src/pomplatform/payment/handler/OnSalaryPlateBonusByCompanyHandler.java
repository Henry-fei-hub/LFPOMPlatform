package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryPlateBonusByCompany;
import pomplatform.payment.bean.ConditionOnSalaryPlateBonusByCompany;
import pomplatform.payment.query.QueryOnSalaryPlateBonusByCompany;
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

public class OnSalaryPlateBonusByCompanyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryPlateBonusByCompanyHandler.class);

	public static BaseCollection<BaseOnSalaryPlateBonusByCompany> executeQueryOnSalaryPlateBonusByCompany(ConditionOnSalaryPlateBonusByCompany c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryPlateBonusByCompany dao = new QueryOnSalaryPlateBonusByCompany();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryPlateBonusByCompany> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryPlateBonusByCompany c = new ConditionOnSalaryPlateBonusByCompany();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryPlateBonusByCompany> result = executeQueryOnSalaryPlateBonusByCompany(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryPlateBonusByCompany> result;
		ConditionOnSalaryPlateBonusByCompany c = new ConditionOnSalaryPlateBonusByCompany();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryPlateBonusByCompany dao = new QueryOnSalaryPlateBonusByCompany();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryPlateBonusByCompany.ALL_CAPTIONS);
			for(BaseOnSalaryPlateBonusByCompany b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



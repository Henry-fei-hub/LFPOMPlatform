package pomplatform.CompanyRepayment.handler;

import org.apache.log4j.Logger;
import pomplatform.CompanyRepayment.bean.BaseCompanyRepayment;
import pomplatform.CompanyRepayment.bean.ConditionCompanyRepayment;
import pomplatform.CompanyRepayment.query.QueryCompanyRepayment;
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

public class CompanyRepaymentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CompanyRepaymentHandler.class);

	public static BaseCollection<BaseCompanyRepayment> executeQueryCompanyRepayment(ConditionCompanyRepayment c, KeyValuePair[] replacements ) throws Exception {
		QueryCompanyRepayment dao = new QueryCompanyRepayment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCompanyRepayment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCompanyRepayment c = new ConditionCompanyRepayment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCompanyRepayment> result = executeQueryCompanyRepayment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCompanyRepayment> result;
		ConditionCompanyRepayment c = new ConditionCompanyRepayment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCompanyRepayment dao = new QueryCompanyRepayment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCompanyRepayment.ALL_CAPTIONS);
			for(BaseCompanyRepayment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



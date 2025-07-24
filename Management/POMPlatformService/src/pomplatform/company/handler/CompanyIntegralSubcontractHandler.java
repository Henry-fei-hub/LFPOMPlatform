package pomplatform.company.handler;

import org.apache.log4j.Logger;
import pomplatform.company.bean.BaseCompanyIntegralSubcontract;
import pomplatform.company.bean.ConditionCompanyIntegralSubcontract;
import pomplatform.company.query.QueryCompanyIntegralSubcontract;
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

public class CompanyIntegralSubcontractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CompanyIntegralSubcontractHandler.class);

	public static BaseCollection<BaseCompanyIntegralSubcontract> executeQueryCompanyIntegralSubcontract(ConditionCompanyIntegralSubcontract c, KeyValuePair[] replacements ) throws Exception {
		QueryCompanyIntegralSubcontract dao = new QueryCompanyIntegralSubcontract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCompanyIntegralSubcontract> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCompanyIntegralSubcontract c = new ConditionCompanyIntegralSubcontract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCompanyIntegralSubcontract> result = executeQueryCompanyIntegralSubcontract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCompanyIntegralSubcontract> result;
		ConditionCompanyIntegralSubcontract c = new ConditionCompanyIntegralSubcontract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCompanyIntegralSubcontract dao = new QueryCompanyIntegralSubcontract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCompanyIntegralSubcontract.ALL_CAPTIONS);
			for(BaseCompanyIntegralSubcontract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



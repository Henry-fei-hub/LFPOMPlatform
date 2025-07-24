package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseContractSaveAndRevenue;
import pomplatform.report.bean.ConditionContractSaveAndRevenue;
import pomplatform.report.query.QueryContractSaveAndRevenue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class ContractSaveAndRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractSaveAndRevenueHandler.class);

	public static BaseCollection<BaseContractSaveAndRevenue> executeQueryContractSaveAndRevenue(ConditionContractSaveAndRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryContractSaveAndRevenue dao = new QueryContractSaveAndRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractSaveAndRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractSaveAndRevenue c = new ConditionContractSaveAndRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractSaveAndRevenue> result = executeQueryContractSaveAndRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractSaveAndRevenue> result;
		ConditionContractSaveAndRevenue c = new ConditionContractSaveAndRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractSaveAndRevenue dao = new QueryContractSaveAndRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractSaveAndRevenue.ALL_CAPTIONS);
			for(BaseContractSaveAndRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



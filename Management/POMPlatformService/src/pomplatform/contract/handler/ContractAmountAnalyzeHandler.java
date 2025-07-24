package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseContractAmountAnalyze;
import pomplatform.contract.bean.ConditionContractAmountAnalyze;
import pomplatform.contract.query.QueryContractAmountAnalyze;
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

public class ContractAmountAnalyzeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractAmountAnalyzeHandler.class);

	public static BaseCollection<BaseContractAmountAnalyze> executeQueryContractAmountAnalyze(ConditionContractAmountAnalyze c, KeyValuePair[] replacements ) throws Exception {
		QueryContractAmountAnalyze dao = new QueryContractAmountAnalyze();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractAmountAnalyze> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractAmountAnalyze c = new ConditionContractAmountAnalyze();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractAmountAnalyze> result = executeQueryContractAmountAnalyze(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractAmountAnalyze> result;
		ConditionContractAmountAnalyze c = new ConditionContractAmountAnalyze();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractAmountAnalyze dao = new QueryContractAmountAnalyze();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractAmountAnalyze.ALL_CAPTIONS);
			for(BaseContractAmountAnalyze b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



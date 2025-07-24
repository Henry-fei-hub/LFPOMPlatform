package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseContractAmountAnalyzeDetail;
import pomplatform.contract.bean.ConditionContractAmountAnalyzeDetail;
import pomplatform.contract.query.QueryContractAmountAnalyzeDetail;
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

public class ContractAmountAnalyzeDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractAmountAnalyzeDetailHandler.class);

	public static BaseCollection<BaseContractAmountAnalyzeDetail> executeQueryContractAmountAnalyzeDetail(ConditionContractAmountAnalyzeDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryContractAmountAnalyzeDetail dao = new QueryContractAmountAnalyzeDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractAmountAnalyzeDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractAmountAnalyzeDetail c = new ConditionContractAmountAnalyzeDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractAmountAnalyzeDetail> result = executeQueryContractAmountAnalyzeDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractAmountAnalyzeDetail> result;
		ConditionContractAmountAnalyzeDetail c = new ConditionContractAmountAnalyzeDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractAmountAnalyzeDetail dao = new QueryContractAmountAnalyzeDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractAmountAnalyzeDetail.CAPTIONS);
			for(BaseContractAmountAnalyzeDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



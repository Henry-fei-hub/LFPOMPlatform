package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseContractDistributionMonthlyDetail;
import pomplatform.contract.bean.ConditionContractDistributionMonthlyDetail;
import pomplatform.contract.query.QueryContractDistributionMonthlyDetail;
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

public class ContractDistributionMonthlyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractDistributionMonthlyDetailHandler.class);

	public static BaseCollection<BaseContractDistributionMonthlyDetail> executeQueryContractDistributionMonthlyDetail(ConditionContractDistributionMonthlyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryContractDistributionMonthlyDetail dao = new QueryContractDistributionMonthlyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractDistributionMonthlyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractDistributionMonthlyDetail c = new ConditionContractDistributionMonthlyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractDistributionMonthlyDetail> result = executeQueryContractDistributionMonthlyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractDistributionMonthlyDetail> result;
		ConditionContractDistributionMonthlyDetail c = new ConditionContractDistributionMonthlyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractDistributionMonthlyDetail dao = new QueryContractDistributionMonthlyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractDistributionMonthlyDetail.ALL_CAPTIONS);
			for(BaseContractDistributionMonthlyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseSumPlateContractDistribution;
import pomplatform.contract.bean.ConditionSumPlateContractDistribution;
import pomplatform.contract.query.QuerySumPlateContractDistribution;
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

public class SumPlateContractDistributionHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SumPlateContractDistributionHandler.class);

	public static BaseCollection<BaseSumPlateContractDistribution> executeQuerySumPlateContractDistribution(ConditionSumPlateContractDistribution c, KeyValuePair[] replacements ) throws Exception {
		QuerySumPlateContractDistribution dao = new QuerySumPlateContractDistribution();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSumPlateContractDistribution> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSumPlateContractDistribution c = new ConditionSumPlateContractDistribution();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSumPlateContractDistribution> result = executeQuerySumPlateContractDistribution(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSumPlateContractDistribution> result;
		ConditionSumPlateContractDistribution c = new ConditionSumPlateContractDistribution();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySumPlateContractDistribution dao = new QuerySumPlateContractDistribution();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSumPlateContractDistribution.ALL_CAPTIONS);
			for(BaseSumPlateContractDistribution b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



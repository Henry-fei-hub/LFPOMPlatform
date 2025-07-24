package pomplatform.contract.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseNewContractDistribution;
import pomplatform.contract.bean.ConditionNewContractDistribution;
import pomplatform.contract.query.QueryNewContractDistribution;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class ContractDistributionHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NewContractDistributionHandler.class);

	public static BaseCollection<BaseNewContractDistribution> executeQueryContractDistribution(ConditionNewContractDistribution c, KeyValuePair[] replacements ) throws Exception {
//		QueryContractDistribution dao = new QueryContractDistribution();
		QueryNewContractDistribution dao = new QueryNewContractDistribution();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNewContractDistribution> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNewContractDistribution c = new ConditionNewContractDistribution();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNewContractDistribution> result = executeQueryContractDistribution(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNewContractDistribution> result;
		ConditionNewContractDistribution c = new ConditionNewContractDistribution();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNewContractDistribution dao = new QueryNewContractDistribution();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNewContractDistribution.ALL_CAPTIONS_EXPORT);
			for(BaseNewContractDistribution b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



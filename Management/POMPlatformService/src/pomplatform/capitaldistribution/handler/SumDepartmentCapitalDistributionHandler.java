package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BaseSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumDepartmentCapitalDistribution;
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

public class SumDepartmentCapitalDistributionHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SumDepartmentCapitalDistributionHandler.class);

	public static BaseCollection<BaseSumDepartmentCapitalDistribution> executeQuerySumDepartmentCapitalDistribution(ConditionSumDepartmentCapitalDistribution c, KeyValuePair[] replacements ) throws Exception {
		QuerySumDepartmentCapitalDistribution dao = new QuerySumDepartmentCapitalDistribution();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSumDepartmentCapitalDistribution> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSumDepartmentCapitalDistribution c = new ConditionSumDepartmentCapitalDistribution();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSumDepartmentCapitalDistribution> result = executeQuerySumDepartmentCapitalDistribution(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSumDepartmentCapitalDistribution> result;
		ConditionSumDepartmentCapitalDistribution c = new ConditionSumDepartmentCapitalDistribution();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySumDepartmentCapitalDistribution dao = new QuerySumDepartmentCapitalDistribution();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSumDepartmentCapitalDistribution.ALL_CAPTIONS);
			for(BaseSumDepartmentCapitalDistribution b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



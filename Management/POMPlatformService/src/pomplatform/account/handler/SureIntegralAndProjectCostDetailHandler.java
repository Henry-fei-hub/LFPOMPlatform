package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseSureIntegralAndProjectCostDetail;
import pomplatform.account.bean.ConditionSureIntegralAndProjectCostDetail;
import pomplatform.account.query.QuerySureIntegralAndProjectCostDetail;
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

public class SureIntegralAndProjectCostDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SureIntegralAndProjectCostDetailHandler.class);

	public static BaseCollection<BaseSureIntegralAndProjectCostDetail> executeQuerySureIntegralAndProjectCostDetail(ConditionSureIntegralAndProjectCostDetail c, KeyValuePair[] replacements ) throws Exception {
		QuerySureIntegralAndProjectCostDetail dao = new QuerySureIntegralAndProjectCostDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSureIntegralAndProjectCostDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSureIntegralAndProjectCostDetail c = new ConditionSureIntegralAndProjectCostDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSureIntegralAndProjectCostDetail> result = executeQuerySureIntegralAndProjectCostDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSureIntegralAndProjectCostDetail> result;
		ConditionSureIntegralAndProjectCostDetail c = new ConditionSureIntegralAndProjectCostDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySureIntegralAndProjectCostDetail dao = new QuerySureIntegralAndProjectCostDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSureIntegralAndProjectCostDetail.EXPORT_CAPTIONS);
			for(BaseSureIntegralAndProjectCostDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



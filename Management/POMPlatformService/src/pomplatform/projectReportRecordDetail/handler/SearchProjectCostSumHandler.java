package pomplatform.projectReportRecordDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.projectReportRecordDetail.bean.BaseSearchProjectCostSum;
import pomplatform.projectReportRecordDetail.bean.ConditionSearchProjectCostSum;
import pomplatform.projectReportRecordDetail.query.QuerySearchProjectCostSum;
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

public class SearchProjectCostSumHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SearchProjectCostSumHandler.class);

	public static BaseCollection<BaseSearchProjectCostSum> executeQuerySearchProjectCostSum(ConditionSearchProjectCostSum c, KeyValuePair[] replacements ) throws Exception {
		QuerySearchProjectCostSum dao = new QuerySearchProjectCostSum();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSearchProjectCostSum> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSearchProjectCostSum c = new ConditionSearchProjectCostSum();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSearchProjectCostSum> result = executeQuerySearchProjectCostSum(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSearchProjectCostSum> result;
		ConditionSearchProjectCostSum c = new ConditionSearchProjectCostSum();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySearchProjectCostSum dao = new QuerySearchProjectCostSum();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSearchProjectCostSum.ALL_CAPTIONS);
			for(BaseSearchProjectCostSum b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



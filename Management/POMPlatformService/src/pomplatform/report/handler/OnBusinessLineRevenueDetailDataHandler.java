package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseOnBusinessLineRevenueDetailData;
import pomplatform.report.bean.ConditionOnBusinessLineRevenueDetailData;
import pomplatform.report.query.QueryOnBusinessLineRevenueDetailData;
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

public class OnBusinessLineRevenueDetailDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnBusinessLineRevenueDetailDataHandler.class);

	public static BaseCollection<BaseOnBusinessLineRevenueDetailData> executeQueryOnBusinessLineRevenueDetailData(ConditionOnBusinessLineRevenueDetailData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnBusinessLineRevenueDetailData dao = new QueryOnBusinessLineRevenueDetailData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnBusinessLineRevenueDetailData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnBusinessLineRevenueDetailData c = new ConditionOnBusinessLineRevenueDetailData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnBusinessLineRevenueDetailData> result = executeQueryOnBusinessLineRevenueDetailData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnBusinessLineRevenueDetailData> result;
		ConditionOnBusinessLineRevenueDetailData c = new ConditionOnBusinessLineRevenueDetailData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnBusinessLineRevenueDetailData dao = new QueryOnBusinessLineRevenueDetailData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnBusinessLineRevenueDetailData.ALL_CAPTIONS);
			for(BaseOnBusinessLineRevenueDetailData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.plateCostRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.plateCostRecord.bean.BasePlateCostMonthlyDetail;
import pomplatform.plateCostRecord.bean.ConditionPlateCostMonthlyDetail;
import pomplatform.plateCostRecord.query.QueryPlateCostMonthlyDetail;
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

public class PlateCostMonthlyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateCostMonthlyDetailHandler.class);

	public static BaseCollection<BasePlateCostMonthlyDetail> executeQueryPlateCostMonthlyDetail(ConditionPlateCostMonthlyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateCostMonthlyDetail dao = new QueryPlateCostMonthlyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateCostMonthlyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateCostMonthlyDetail c = new ConditionPlateCostMonthlyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateCostMonthlyDetail> result = executeQueryPlateCostMonthlyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateCostMonthlyDetail> result;
		ConditionPlateCostMonthlyDetail c = new ConditionPlateCostMonthlyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateCostMonthlyDetail dao = new QueryPlateCostMonthlyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateCostMonthlyDetail.ALL_CAPTIONS);
			for(BasePlateCostMonthlyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



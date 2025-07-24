package pomplatform.revenueinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.revenueinfo.bean.BaseRevenueInfo;
import pomplatform.revenueinfo.bean.ConditionRevenueInfo;
import pomplatform.revenueinfo.query.QueryRevenueInfo;
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

public class RevenueInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RevenueInfoHandler.class);

	public static BaseCollection<BaseRevenueInfo> executeQueryRevenueInfo(ConditionRevenueInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryRevenueInfo dao = new QueryRevenueInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRevenueInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRevenueInfo c = new ConditionRevenueInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueInfo> result = executeQueryRevenueInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRevenueInfo> result;
		ConditionRevenueInfo c = new ConditionRevenueInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRevenueInfo dao = new QueryRevenueInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRevenueInfo.ALL_CAPTIONS);
			for(BaseRevenueInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



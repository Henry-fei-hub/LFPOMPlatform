package pomplatform.revenuecapitalsinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.revenuecapitalsinfo.bean.BaseRevenueCapitalsInfo;
import pomplatform.revenuecapitalsinfo.bean.ConditionRevenueCapitalsInfo;
import pomplatform.revenuecapitalsinfo.query.QueryRevenueCapitalsInfo;
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

public class RevenueCapitalsInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RevenueCapitalsInfoHandler.class);

	public static BaseCollection<BaseRevenueCapitalsInfo> executeQueryRevenueCapitalsInfo(ConditionRevenueCapitalsInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryRevenueCapitalsInfo dao = new QueryRevenueCapitalsInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRevenueCapitalsInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRevenueCapitalsInfo c = new ConditionRevenueCapitalsInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueCapitalsInfo> result = executeQueryRevenueCapitalsInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRevenueCapitalsInfo> result;
		ConditionRevenueCapitalsInfo c = new ConditionRevenueCapitalsInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRevenueCapitalsInfo dao = new QueryRevenueCapitalsInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRevenueCapitalsInfo.EXPORT_CAPTIONS);
			for(BaseRevenueCapitalsInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



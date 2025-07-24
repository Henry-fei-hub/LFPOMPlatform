package pomplatform.OnRevenue.handler;

import org.apache.log4j.Logger;
import pomplatform.OnRevenue.bean.BaseOnSheetAttachmentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnSheetAttachmentOfRevenue;
import pomplatform.OnRevenue.query.QueryOnSheetAttachmentOfRevenue;
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

public class OnSheetAttachmentOfRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSheetAttachmentOfRevenueHandler.class);

	public static BaseCollection<BaseOnSheetAttachmentOfRevenue> executeQueryOnSheetAttachmentOfRevenue(ConditionOnSheetAttachmentOfRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSheetAttachmentOfRevenue dao = new QueryOnSheetAttachmentOfRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSheetAttachmentOfRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSheetAttachmentOfRevenue c = new ConditionOnSheetAttachmentOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSheetAttachmentOfRevenue> result = executeQueryOnSheetAttachmentOfRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSheetAttachmentOfRevenue> result;
		ConditionOnSheetAttachmentOfRevenue c = new ConditionOnSheetAttachmentOfRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSheetAttachmentOfRevenue dao = new QueryOnSheetAttachmentOfRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSheetAttachmentOfRevenue.ALL_CAPTIONS);
			for(BaseOnSheetAttachmentOfRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



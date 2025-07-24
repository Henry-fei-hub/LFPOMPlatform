package pomplatform.leavetype.handler;

import org.apache.log4j.Logger;
import pomplatform.leavetype.bean.BaseLinkOfLeaveTypeAndArea;
import pomplatform.leavetype.bean.ConditionLinkOfLeaveTypeAndArea;
import pomplatform.leavetype.query.QueryLinkOfLeaveTypeAndArea;
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

public class LinkOfLeaveTypeAndAreaHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LinkOfLeaveTypeAndAreaHandler.class);

	public static BaseCollection<BaseLinkOfLeaveTypeAndArea> executeQueryLinkOfLeaveTypeAndProvince(ConditionLinkOfLeaveTypeAndArea c, KeyValuePair[] replacements ) throws Exception {
		QueryLinkOfLeaveTypeAndArea dao = new QueryLinkOfLeaveTypeAndArea();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLinkOfLeaveTypeAndArea> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLinkOfLeaveTypeAndArea c = new ConditionLinkOfLeaveTypeAndArea();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLinkOfLeaveTypeAndArea> result = executeQueryLinkOfLeaveTypeAndProvince(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLinkOfLeaveTypeAndArea> result;
		ConditionLinkOfLeaveTypeAndArea c = new ConditionLinkOfLeaveTypeAndArea();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLinkOfLeaveTypeAndArea dao = new QueryLinkOfLeaveTypeAndArea();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLinkOfLeaveTypeAndArea.ALL_CAPTIONS);
			for(BaseLinkOfLeaveTypeAndArea b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



package pomplatform.leavetype.handler;

import org.apache.log4j.Logger;
import pomplatform.leavetype.bean.BaseLinkOfLeaveTypeAndProvince;
import pomplatform.leavetype.bean.ConditionLinkOfLeaveTypeAndProvince;
import pomplatform.leavetype.query.QueryLinkOfLeaveTypeAndProvince;
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

public class LinkOfLeaveTypeAndProvinceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LinkOfLeaveTypeAndProvinceHandler.class);

	public static BaseCollection<BaseLinkOfLeaveTypeAndProvince> executeQueryLinkOfLeaveTypeAndProvince(ConditionLinkOfLeaveTypeAndProvince c, KeyValuePair[] replacements ) throws Exception {
		QueryLinkOfLeaveTypeAndProvince dao = new QueryLinkOfLeaveTypeAndProvince();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLinkOfLeaveTypeAndProvince> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLinkOfLeaveTypeAndProvince c = new ConditionLinkOfLeaveTypeAndProvince();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLinkOfLeaveTypeAndProvince> result = executeQueryLinkOfLeaveTypeAndProvince(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLinkOfLeaveTypeAndProvince> result;
		ConditionLinkOfLeaveTypeAndProvince c = new ConditionLinkOfLeaveTypeAndProvince();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLinkOfLeaveTypeAndProvince dao = new QueryLinkOfLeaveTypeAndProvince();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLinkOfLeaveTypeAndProvince.ALL_CAPTIONS);
			for(BaseLinkOfLeaveTypeAndProvince b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



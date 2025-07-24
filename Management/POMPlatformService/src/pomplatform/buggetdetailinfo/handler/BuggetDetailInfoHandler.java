package pomplatform.buggetdetailinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.buggetdetailinfo.bean.BaseBuggetDetailInfo;
import pomplatform.buggetdetailinfo.bean.ConditionBuggetDetailInfo;
import pomplatform.buggetdetailinfo.query.QueryBuggetDetailInfo;
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

public class BuggetDetailInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BuggetDetailInfoHandler.class);

	public static BaseCollection<BaseBuggetDetailInfo> executeQueryBuggetDetailInfo(ConditionBuggetDetailInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryBuggetDetailInfo dao = new QueryBuggetDetailInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBuggetDetailInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBuggetDetailInfo c = new ConditionBuggetDetailInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBuggetDetailInfo> result = executeQueryBuggetDetailInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBuggetDetailInfo> result;
		ConditionBuggetDetailInfo c = new ConditionBuggetDetailInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBuggetDetailInfo dao = new QueryBuggetDetailInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBuggetDetailInfo.ALL_CAPTIONS);
			for(BaseBuggetDetailInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



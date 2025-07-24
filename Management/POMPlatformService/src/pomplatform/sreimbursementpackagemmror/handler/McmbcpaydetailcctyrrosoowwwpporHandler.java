package pomplatform.sreimbursementpackagemmror.handler;

import org.apache.log4j.Logger;
import pomplatform.sreimbursementpackagemmror.bean.BaseMcmbcpaydetailcctyrrosoowwwppor;
import pomplatform.sreimbursementpackagemmror.bean.ConditionMcmbcpaydetailcctyrrosoowwwppor;
import pomplatform.sreimbursementpackagemmror.query.QueryMcmbcpaydetailcctyrrosoowwwppor;
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

public class McmbcpaydetailcctyrrosoowwwpporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McmbcpaydetailcctyrrosoowwwpporHandler.class);

	public static BaseCollection<BaseMcmbcpaydetailcctyrrosoowwwppor> executeQueryMcmbcpaydetailcctyrrosoowwwppor(ConditionMcmbcpaydetailcctyrrosoowwwppor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcmbcpaydetailcctyrrosoowwwppor dao = new QueryMcmbcpaydetailcctyrrosoowwwppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcmbcpaydetailcctyrrosoowwwppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcmbcpaydetailcctyrrosoowwwppor c = new ConditionMcmbcpaydetailcctyrrosoowwwppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcmbcpaydetailcctyrrosoowwwppor> result = executeQueryMcmbcpaydetailcctyrrosoowwwppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcmbcpaydetailcctyrrosoowwwppor> result;
		ConditionMcmbcpaydetailcctyrrosoowwwppor c = new ConditionMcmbcpaydetailcctyrrosoowwwppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcmbcpaydetailcctyrrosoowwwppor dao = new QueryMcmbcpaydetailcctyrrosoowwwppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcmbcpaydetailcctyrrosoowwwppor.ALL_CAPTIONS);
			for(BaseMcmbcpaydetailcctyrrosoowwwppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



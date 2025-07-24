package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BaseMcmbcpaydetailctswoowycoor;
import pomplatform.reimbursementpackage.bean.ConditionMcmbcpaydetailctswoowycoor;
import pomplatform.reimbursementpackage.query.QueryMcmbcpaydetailctswoowycoor;
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

public class McmbcpaydetailctswoowycoorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McmbcpaydetailctswoowycoorHandler.class);

	public static BaseCollection<BaseMcmbcpaydetailctswoowycoor> executeQueryMcmbcpaydetailctswoowycoor(ConditionMcmbcpaydetailctswoowycoor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcmbcpaydetailctswoowycoor dao = new QueryMcmbcpaydetailctswoowycoor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcmbcpaydetailctswoowycoor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcmbcpaydetailctswoowycoor c = new ConditionMcmbcpaydetailctswoowycoor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcmbcpaydetailctswoowycoor> result = executeQueryMcmbcpaydetailctswoowycoor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcmbcpaydetailctswoowycoor> result;
		ConditionMcmbcpaydetailctswoowycoor c = new ConditionMcmbcpaydetailctswoowycoor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcmbcpaydetailctswoowycoor dao = new QueryMcmbcpaydetailctswoowycoor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcmbcpaydetailctswoowycoor.ALL_CAPTIONS);
			for(BaseMcmbcpaydetailctswoowycoor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



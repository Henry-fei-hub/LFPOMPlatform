package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BaseScmbcpaydetailctyor;
import pomplatform.reimbursementpackage.bean.ConditionScmbcpaydetailctyor;
import pomplatform.reimbursementpackage.query.QueryScmbcpaydetailctyor;
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

public class ScmbcpaydetailctyorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScmbcpaydetailctyorHandler.class);

	public static BaseCollection<BaseScmbcpaydetailctyor> executeQueryScmbcpaydetailctyor(ConditionScmbcpaydetailctyor c, KeyValuePair[] replacements ) throws Exception {
		QueryScmbcpaydetailctyor dao = new QueryScmbcpaydetailctyor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScmbcpaydetailctyor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScmbcpaydetailctyor c = new ConditionScmbcpaydetailctyor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScmbcpaydetailctyor> result = executeQueryScmbcpaydetailctyor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScmbcpaydetailctyor> result;
		ConditionScmbcpaydetailctyor c = new ConditionScmbcpaydetailctyor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScmbcpaydetailctyor dao = new QueryScmbcpaydetailctyor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScmbcpaydetailctyor.ALL_CAPTIONS);
			for(BaseScmbcpaydetailctyor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



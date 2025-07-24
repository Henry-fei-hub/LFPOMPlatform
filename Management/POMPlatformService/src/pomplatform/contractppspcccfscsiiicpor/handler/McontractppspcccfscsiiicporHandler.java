package pomplatform.contractppspcccfscsiiicpor.handler;

import org.apache.log4j.Logger;
import pomplatform.contractppspcccfscsiiicpor.bean.BaseMcontractppspcccfscsiiicpor;
import pomplatform.contractppspcccfscsiiicpor.bean.ConditionMcontractppspcccfscsiiicpor;
import pomplatform.contractppspcccfscsiiicpor.query.QueryMcontractppspcccfscsiiicpor;
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

public class McontractppspcccfscsiiicporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontractppspcccfscsiiicporHandler.class);

	public static BaseCollection<BaseMcontractppspcccfscsiiicpor> executeQueryMcontractppspcccfscsiiicpor(ConditionMcontractppspcccfscsiiicpor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontractppspcccfscsiiicpor dao = new QueryMcontractppspcccfscsiiicpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontractppspcccfscsiiicpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontractppspcccfscsiiicpor c = new ConditionMcontractppspcccfscsiiicpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcontractppspcccfscsiiicpor> result = executeQueryMcontractppspcccfscsiiicpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontractppspcccfscsiiicpor> result;
		ConditionMcontractppspcccfscsiiicpor c = new ConditionMcontractppspcccfscsiiicpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcontractppspcccfscsiiicpor dao = new QueryMcontractppspcccfscsiiicpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontractppspcccfscsiiicpor.ALL_CAPTIONS);
			for(BaseMcontractppspcccfscsiiicpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



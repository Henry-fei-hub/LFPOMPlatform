package pomplatform.revenuevoucher.handler;

import org.apache.log4j.Logger;
import pomplatform.revenuevoucher.bean.BaseMprojectcrymor;
import pomplatform.revenuevoucher.bean.ConditionMprojectcrymor;
import pomplatform.revenuevoucher.query.QueryMprojectcrymor;
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

public class MprojectcrymorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectcrymorHandler.class);

	public static BaseCollection<BaseMprojectcrymor> executeQueryMprojectcrymor(ConditionMprojectcrymor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectcrymor dao = new QueryMprojectcrymor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectcrymor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectcrymor c = new ConditionMprojectcrymor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectcrymor> result = executeQueryMprojectcrymor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectcrymor> result;
		ConditionMprojectcrymor c = new ConditionMprojectcrymor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectcrymor dao = new QueryMprojectcrymor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojectcrymor.ALL_CAPTIONS);
			for(BaseMprojectcrymor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



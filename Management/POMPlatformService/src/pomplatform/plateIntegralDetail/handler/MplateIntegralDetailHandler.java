package pomplatform.plateIntegralDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralDetail.bean.BaseMplateIntegralDetail;
import pomplatform.plateIntegralDetail.bean.ConditionMplateIntegralDetail;
import pomplatform.plateIntegralDetail.query.QueryMplateIntegralDetail;
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

public class MplateIntegralDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MplateIntegralDetailHandler.class);

	public static BaseCollection<BaseMplateIntegralDetail> executeQueryMplateIntegralDetail(ConditionMplateIntegralDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryMplateIntegralDetail dao = new QueryMplateIntegralDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMplateIntegralDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMplateIntegralDetail c = new ConditionMplateIntegralDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMplateIntegralDetail> result = executeQueryMplateIntegralDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMplateIntegralDetail> result;
		ConditionMplateIntegralDetail c = new ConditionMplateIntegralDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMplateIntegralDetail dao = new QueryMplateIntegralDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMplateIntegralDetail.ALL_CAPTIONS);
			for(BaseMplateIntegralDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



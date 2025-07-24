package pomplatform.plateProjectIntegralDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.plateProjectIntegralDetail.bean.BaseMplateProjectIntegralDetail;
import pomplatform.plateProjectIntegralDetail.bean.ConditionMplateProjectIntegralDetail;
import pomplatform.plateProjectIntegralDetail.query.QueryMplateProjectIntegralDetail;
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

public class MplateProjectIntegralDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MplateProjectIntegralDetailHandler.class);

	public static BaseCollection<BaseMplateProjectIntegralDetail> executeQueryMplateProjectIntegralDetail(ConditionMplateProjectIntegralDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryMplateProjectIntegralDetail dao = new QueryMplateProjectIntegralDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMplateProjectIntegralDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMplateProjectIntegralDetail c = new ConditionMplateProjectIntegralDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMplateProjectIntegralDetail> result = executeQueryMplateProjectIntegralDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMplateProjectIntegralDetail> result;
		ConditionMplateProjectIntegralDetail c = new ConditionMplateProjectIntegralDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMplateProjectIntegralDetail dao = new QueryMplateProjectIntegralDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMplateProjectIntegralDetail.ALL_CAPTIONS);
			for(BaseMplateProjectIntegralDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



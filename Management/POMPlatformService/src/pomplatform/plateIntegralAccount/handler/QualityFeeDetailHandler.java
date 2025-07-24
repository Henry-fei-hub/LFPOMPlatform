package pomplatform.plateIntegralAccount.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralAccount.bean.BaseQualityFeeDetail;
import pomplatform.plateIntegralAccount.bean.ConditionQualityFeeDetail;
import pomplatform.plateIntegralAccount.query.QueryQualityFeeDetail;
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

public class QualityFeeDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(QualityFeeDetailHandler.class);

	public static BaseCollection<BaseQualityFeeDetail> executeQueryQualityFeeDetail(ConditionQualityFeeDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryQualityFeeDetail dao = new QueryQualityFeeDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseQualityFeeDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionQualityFeeDetail c = new ConditionQualityFeeDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseQualityFeeDetail> result = executeQueryQualityFeeDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseQualityFeeDetail> result;
		ConditionQualityFeeDetail c = new ConditionQualityFeeDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryQualityFeeDetail dao = new QueryQualityFeeDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseQualityFeeDetail.ALL_CAPTIONS);
			for(BaseQualityFeeDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



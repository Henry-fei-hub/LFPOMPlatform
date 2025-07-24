package pomplatform.plateIntegralAccount.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralAccount.bean.BaseQualityFeeMonthlyDetail;
import pomplatform.plateIntegralAccount.bean.ConditionQualityFeeMonthlyDetail;
import pomplatform.plateIntegralAccount.query.QueryQualityFeeMonthlyDetail;
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

public class QualityFeeMonthlyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(QualityFeeMonthlyDetailHandler.class);

	public static BaseCollection<BaseQualityFeeMonthlyDetail> executeQueryQualityFeeMonthlyDetail(ConditionQualityFeeMonthlyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryQualityFeeMonthlyDetail dao = new QueryQualityFeeMonthlyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseQualityFeeMonthlyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionQualityFeeMonthlyDetail c = new ConditionQualityFeeMonthlyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseQualityFeeMonthlyDetail> result = executeQueryQualityFeeMonthlyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseQualityFeeMonthlyDetail> result;
		ConditionQualityFeeMonthlyDetail c = new ConditionQualityFeeMonthlyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryQualityFeeMonthlyDetail dao = new QueryQualityFeeMonthlyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseQualityFeeMonthlyDetail.ALL_CAPTIONS);
			for(BaseQualityFeeMonthlyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



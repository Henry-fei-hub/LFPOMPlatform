package pomplatform.operating.handler;

import org.apache.log4j.Logger;
import pomplatform.operating.bean.BaseOperatingOnPayCommonPlateIntegral;
import pomplatform.operating.bean.ConditionOperatingOnPayCommonPlateIntegral;
import pomplatform.operating.query.QueryOperatingOnPayCommonPlateIntegral;
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

public class OperatingOnPayCommonPlateIntegralHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OperatingOnPayCommonPlateIntegralHandler.class);

	public static BaseCollection<BaseOperatingOnPayCommonPlateIntegral> executeQueryOperatingOnPayCommonPlateIntegral(ConditionOperatingOnPayCommonPlateIntegral c, KeyValuePair[] replacements ) throws Exception {
		QueryOperatingOnPayCommonPlateIntegral dao = new QueryOperatingOnPayCommonPlateIntegral();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOperatingOnPayCommonPlateIntegral> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOperatingOnPayCommonPlateIntegral c = new ConditionOperatingOnPayCommonPlateIntegral();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOperatingOnPayCommonPlateIntegral> result = executeQueryOperatingOnPayCommonPlateIntegral(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOperatingOnPayCommonPlateIntegral> result;
		ConditionOperatingOnPayCommonPlateIntegral c = new ConditionOperatingOnPayCommonPlateIntegral();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOperatingOnPayCommonPlateIntegral dao = new QueryOperatingOnPayCommonPlateIntegral();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOperatingOnPayCommonPlateIntegral.ALL_CAPTIONS);
			for(BaseOperatingOnPayCommonPlateIntegral b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



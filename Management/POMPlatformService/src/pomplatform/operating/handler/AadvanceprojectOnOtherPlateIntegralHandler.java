package pomplatform.operating.handler;

import org.apache.log4j.Logger;
import pomplatform.operating.bean.BaseAadvanceprojectOnOtherPlateIntegral;
import pomplatform.operating.bean.ConditionAadvanceprojectOnOtherPlateIntegral;
import pomplatform.operating.query.QueryAadvanceprojectOnOtherPlateIntegral;
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

public class AadvanceprojectOnOtherPlateIntegralHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AadvanceprojectOnOtherPlateIntegralHandler.class);

	public static BaseCollection<BaseAadvanceprojectOnOtherPlateIntegral> executeQueryAadvanceprojectOnOtherPlateIntegral(ConditionAadvanceprojectOnOtherPlateIntegral c, KeyValuePair[] replacements ) throws Exception {
		QueryAadvanceprojectOnOtherPlateIntegral dao = new QueryAadvanceprojectOnOtherPlateIntegral();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAadvanceprojectOnOtherPlateIntegral> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAadvanceprojectOnOtherPlateIntegral c = new ConditionAadvanceprojectOnOtherPlateIntegral();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAadvanceprojectOnOtherPlateIntegral> result = executeQueryAadvanceprojectOnOtherPlateIntegral(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAadvanceprojectOnOtherPlateIntegral> result;
		ConditionAadvanceprojectOnOtherPlateIntegral c = new ConditionAadvanceprojectOnOtherPlateIntegral();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAadvanceprojectOnOtherPlateIntegral dao = new QueryAadvanceprojectOnOtherPlateIntegral();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAadvanceprojectOnOtherPlateIntegral.ALL_CAPTIONS);
			for(BaseAadvanceprojectOnOtherPlateIntegral b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



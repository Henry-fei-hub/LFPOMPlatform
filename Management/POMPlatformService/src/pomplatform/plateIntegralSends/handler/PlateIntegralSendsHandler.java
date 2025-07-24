package pomplatform.plateIntegralSends.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralSends.bean.BasePlateIntegralSends;
import pomplatform.plateIntegralSends.bean.ConditionPlateIntegralSends;
import pomplatform.plateIntegralSends.query.QueryPlateIntegralSends;
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

public class PlateIntegralSendsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateIntegralSendsHandler.class);

	public static BaseCollection<BasePlateIntegralSends> executeQueryPlateIntegralSends(ConditionPlateIntegralSends c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateIntegralSends dao = new QueryPlateIntegralSends();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateIntegralSends> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateIntegralSends c = new ConditionPlateIntegralSends();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateIntegralSends> result = executeQueryPlateIntegralSends(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateIntegralSends> result;
		ConditionPlateIntegralSends c = new ConditionPlateIntegralSends();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateIntegralSends dao = new QueryPlateIntegralSends();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateIntegralSends.ALL_CAPTIONS);
			for(BasePlateIntegralSends b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



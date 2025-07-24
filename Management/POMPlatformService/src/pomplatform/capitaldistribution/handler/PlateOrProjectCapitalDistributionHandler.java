package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BasePlateOrProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionPlateOrProjectCapitalDistribution;
import pomplatform.capitaldistribution.query.QueryPlateOrProjectCapitalDistribution;
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

public class PlateOrProjectCapitalDistributionHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateOrProjectCapitalDistributionHandler.class);

	public static BaseCollection<BasePlateOrProjectCapitalDistribution> executeQueryPlateOrProjectCapitalDistribution(ConditionPlateOrProjectCapitalDistribution c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateOrProjectCapitalDistribution dao = new QueryPlateOrProjectCapitalDistribution();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateOrProjectCapitalDistribution> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateOrProjectCapitalDistribution c = new ConditionPlateOrProjectCapitalDistribution();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateOrProjectCapitalDistribution> result = executeQueryPlateOrProjectCapitalDistribution(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateOrProjectCapitalDistribution> result;
		ConditionPlateOrProjectCapitalDistribution c = new ConditionPlateOrProjectCapitalDistribution();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateOrProjectCapitalDistribution dao = new QueryPlateOrProjectCapitalDistribution();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateOrProjectCapitalDistribution.ALL_CAPTIONS);
			for(BasePlateOrProjectCapitalDistribution b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



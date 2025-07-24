package pomplatform.sealKeepers.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.sealKeepers.bean.BaseRankMaintenance;
import pomplatform.sealKeepers.bean.ConditionRankMaintenance;
import pomplatform.sealKeepers.query.QueryRankMaintenance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class RankMaintenanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RankMaintenanceHandler.class);

	public static BaseCollection<BaseRankMaintenance> executeQueryRankMaintenance(ConditionRankMaintenance c, KeyValuePair[] replacements ) throws Exception {
		QueryRankMaintenance dao = new QueryRankMaintenance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRankMaintenance> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRankMaintenance c = new ConditionRankMaintenance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRankMaintenance> result = executeQueryRankMaintenance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRankMaintenance> result;
		ConditionRankMaintenance c = new ConditionRankMaintenance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRankMaintenance dao = new QueryRankMaintenance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRankMaintenance.ALL_CAPTIONS);
			for(BaseRankMaintenance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



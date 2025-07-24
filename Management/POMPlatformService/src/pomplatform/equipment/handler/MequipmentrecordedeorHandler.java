package pomplatform.equipment.handler;

import org.apache.log4j.Logger;
import pomplatform.equipment.bean.BaseMequipmentrecordedeor;
import pomplatform.equipment.bean.ConditionMequipmentrecordedeor;
import pomplatform.equipment.query.QueryMequipmentrecordedeor;
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

public class MequipmentrecordedeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MequipmentrecordedeorHandler.class);

	public static BaseCollection<BaseMequipmentrecordedeor> executeQueryMequipmentrecordedeor(ConditionMequipmentrecordedeor c, KeyValuePair[] replacements ) throws Exception {
		QueryMequipmentrecordedeor dao = new QueryMequipmentrecordedeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMequipmentrecordedeor> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMequipmentrecordedeor c = new ConditionMequipmentrecordedeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMequipmentrecordedeor> result = executeQueryMequipmentrecordedeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMequipmentrecordedeor> result;
		ConditionMequipmentrecordedeor c = new ConditionMequipmentrecordedeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMequipmentrecordedeor dao = new QueryMequipmentrecordedeor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMequipmentrecordedeor.ALL_CAPTIONS);
			for(BaseMequipmentrecordedeor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



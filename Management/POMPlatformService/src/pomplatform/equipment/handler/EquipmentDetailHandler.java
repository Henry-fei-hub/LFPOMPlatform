package pomplatform.equipment.handler;

import org.apache.log4j.Logger;
import pomplatform.equipment.bean.BaseEquipmentDetail;
import pomplatform.equipment.bean.ConditionEquipmentDetail;
import pomplatform.equipment.query.QueryEquipmentDetail;
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

public class EquipmentDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EquipmentDetailHandler.class);

	public static BaseCollection<BaseEquipmentDetail> executeQueryEquipmentDetail(ConditionEquipmentDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryEquipmentDetail dao = new QueryEquipmentDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEquipmentDetail> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEquipmentDetail c = new ConditionEquipmentDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEquipmentDetail> result = executeQueryEquipmentDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEquipmentDetail> result;
		ConditionEquipmentDetail c = new ConditionEquipmentDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEquipmentDetail dao = new QueryEquipmentDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEquipmentDetail.ALL_CAPTIONS);
			for(BaseEquipmentDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



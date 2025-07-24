package pomplatform.workflow.personnelbusiness.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.personnelbusiness.bean.BaseGoodsApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionGoodsApply;
import pomplatform.workflow.personnelbusiness.query.QueryGoodsApply;

public class GoodsApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GoodsApplyHandler.class);

	public static BaseCollection<BaseGoodsApply> executeQueryGoodsApply(ConditionGoodsApply c, KeyValuePair[] replacements ) throws Exception {
		QueryGoodsApply dao = new QueryGoodsApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGoodsApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			PersonnelBusinessLinkEquipment daoPersonnelBusinessLinkEquipment = new PersonnelBusinessLinkEquipment();
			for(BaseGoodsApply bean : result.getCollections()){
				daoPersonnelBusinessLinkEquipment.setConditionParentId("=", bean.getPersonnelBusinessId());
				daoPersonnelBusinessLinkEquipment.setConditionProcessType("=", bean.getProcessType());
				bean.setDetailPersonnelBusinessLinkEquipment(daoPersonnelBusinessLinkEquipment.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGoodsApply c = new ConditionGoodsApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGoodsApply> result = executeQueryGoodsApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGoodsApply> result;
		ConditionGoodsApply c = new ConditionGoodsApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGoodsApply dao = new QueryGoodsApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGoodsApply.ALL_CAPTIONS);
			for(BaseGoodsApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



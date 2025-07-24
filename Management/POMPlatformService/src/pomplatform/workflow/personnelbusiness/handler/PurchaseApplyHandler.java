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
import pomplatform.workflow.personnelbusiness.bean.BasePurchaseApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionPurchaseApply;
import pomplatform.workflow.personnelbusiness.query.QueryPurchaseApply;

public class PurchaseApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PurchaseApplyHandler.class);

	public static BaseCollection<BasePurchaseApply> executeQueryPurchaseApply(ConditionPurchaseApply c, KeyValuePair[] replacements ) throws Exception {
		QueryPurchaseApply dao = new QueryPurchaseApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePurchaseApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			PersonnelBusinessLinkEquipment daoPersonnelBusinessLinkEquipment = new PersonnelBusinessLinkEquipment();
			for(BasePurchaseApply bean : result.getCollections()){
				daoPersonnelBusinessLinkEquipment.setConditionParentId("=", bean.getPersonnelBusinessId());
				daoPersonnelBusinessLinkEquipment.setConditionProcessType("=", bean.getProcessType());
				bean.setDetailPersonnelBusinessLinkEquipment(daoPersonnelBusinessLinkEquipment.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPurchaseApply c = new ConditionPurchaseApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePurchaseApply> result = executeQueryPurchaseApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePurchaseApply> result;
		ConditionPurchaseApply c = new ConditionPurchaseApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPurchaseApply dao = new QueryPurchaseApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePurchaseApply.ALL_CAPTIONS);
			for(BasePurchaseApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}



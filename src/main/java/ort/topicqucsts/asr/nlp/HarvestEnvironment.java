/**
 * 
 */
package ort.topicqucsts.asr.nlp;

import org.topicquests.asr.nlp.Environment;
import org.topicquests.pg.PostgresConnectionFactory;

import ort.topicqucsts.asr.nlp.api.IDocumentModel;
import ort.topicqucsts.asr.nlp.api.IParagraphModel;
import ort.topicqucsts.asr.nlp.api.IProcessModel;
import ort.topicqucsts.asr.nlp.models.DocumentModel;
import ort.topicqucsts.asr.nlp.models.ParagraphModel;
import ort.topicqucsts.asr.nlp.models.ProcessModel;

/**
 * 
 */
public class HarvestEnvironment extends Environment {
	private IDocumentModel docModel;
	private IParagraphModel paraModel;
	private IProcessModel model;
	private PostgresConnectionFactory dbDriver = null;

	/**
	 * @author jackpark
	 */
	public HarvestEnvironment() {
		docModel = new DocumentModel(this);
		paraModel = new ParagraphModel(this);
		model = new ProcessModel(this);
		String schemaName = getStringProperty("DatabaseSchema");
		String dbName = getStringProperty("DatabaseName");
		dbDriver = new PostgresConnectionFactory(dbName, schemaName);

	}

	public IDocumentModel getDocumentModel() {
		return docModel;
	}
	
	public IParagraphModel getParagraphModel() {
		return paraModel;
	}
	
	public IProcessModel getModel() {
		return model;
	}
	
	public PostgresConnectionFactory getDatabaseDriver() {
		return dbDriver;
	}


}

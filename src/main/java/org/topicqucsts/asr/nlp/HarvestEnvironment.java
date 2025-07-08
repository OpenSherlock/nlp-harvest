/**
 * 
 */
package org.topicqucsts.asr.nlp;

import org.topicqucsts.asr.nlp.api.IDocumentModel;
import org.topicqucsts.asr.nlp.api.IParagraphModel;
import org.topicqucsts.asr.nlp.api.IProcessModel;
import org.topicqucsts.asr.nlp.models.DocumentModel;
import org.topicqucsts.asr.nlp.models.ParagraphModel;
import org.topicqucsts.asr.nlp.models.ProcessModel;
import org.topicquests.asr.nlp.Environment;
import org.topicquests.pg.PostgresConnectionFactory;

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
		dbDriver = new PostgresConnectionFactory(this, dbName, schemaName);

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

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		
	}


}

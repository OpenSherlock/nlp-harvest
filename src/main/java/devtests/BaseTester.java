/**
 * 
 */
package devtests;

import org.topicqucsts.asr.nlp.HarvestEnvironment;
import org.topicqucsts.asr.nlp.api.IProcessModel;
import org.topicquests.asr.nlp.parsers.PMCPullParser;
import org.topicquests.asr.nlp.parsers.PubMedPullParser;

/**
 * @author jackpark
 */
public class BaseTester {
	protected HarvestEnvironment environment;
	protected PMCPullParser pmcP;
	protected PubMedPullParser pubmedP;
	protected IProcessModel model;
	
	/**
	 * 
	 */
	public BaseTester() {
		environment = new HarvestEnvironment();
		pmcP = environment.getPMCParser();
		pubmedP = environment.getPubMedParser();
		model = environment.getModel();
	}

}

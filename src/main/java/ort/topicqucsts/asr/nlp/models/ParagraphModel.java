/**
 * 
 */
package ort.topicqucsts.asr.nlp.models;

import org.topicquests.asr.nlp.api.IParagraph;
import org.topicquests.support.api.IResult;

import ort.topicqucsts.asr.nlp.HarvestEnvironment;
import ort.topicqucsts.asr.nlp.api.IParagraphModel;

/**
 * 
 */
public class ParagraphModel implements IParagraphModel {
	private HarvestEnvironment environment;
	/**
	 * 
	 */
	public ParagraphModel(HarvestEnvironment env) {
		environment = env;
	}

	@Override
	public IResult putParagraph(IParagraph p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getParagraph(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult updateParagraph(IParagraph p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult addSentenceId(long sentenceId, long paragraphId) {
		// TODO Auto-generated method stub
		return null;
	}

}

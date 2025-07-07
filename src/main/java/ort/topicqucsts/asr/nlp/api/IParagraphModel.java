/*
 * Copyright 2023 TopicQuests Foundation
 *  This source code is available under the terms of the Affero General Public License v3.
 *  Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
 */
package ort.topicqucsts.asr.nlp.api;

import org.topicquests.asr.nlp.api.IParagraph;
import org.topicquests.asr.nlp.api.IResult;

/**
 * @author jackpark
 *
 */
public interface IParagraphModel {
	
	/**
	 * @param p
	 * @return
	 */
	IResult putParagraph(IParagraph p);
	
	IResult getParagraph(long id);
	
	IResult updateParagraph(IParagraph p);
	
	/**
	 * Uses updateFinished callback
	 * @param sentenceId
	 * @param paragraphId
	 */
	IResult addSentenceId(long sentenceId, long paragraphId);
}

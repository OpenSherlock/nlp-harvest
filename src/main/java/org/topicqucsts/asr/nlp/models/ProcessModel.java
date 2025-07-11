/**
 * 
 */
package org.topicqucsts.asr.nlp.models;

import java.io.File;

import org.topicqucsts.asr.nlp.HarvestEnvironment;
import org.topicqucsts.asr.nlp.api.IProcessModel;
import org.topicquests.asr.nlp.parsers.PMCPullParser;
import org.topicquests.asr.nlp.parsers.PubMedReportPullParser;
import org.topicquests.support.api.IResult;

/**
 * 
 */
public class ProcessModel implements IProcessModel {
	private HarvestEnvironment environment;
	private PubMedReportPullParser pubmedPP;
	private PMCPullParser pmcPP;
	/**
	 * 
	 */
	public ProcessModel(HarvestEnvironment env) {
		environment = env;
		pubmedPP = environment.getPubMedParser();
		pmcPP = environment.getPMCParser();
	}

	@Override
	public IResult processPubMedXML(File xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult processPubMedDirectory(String directory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult processPMCdXML(File xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult processPMCDirectory(String directory) {
		// TODO Auto-generated method stub
		return null;
	}

}

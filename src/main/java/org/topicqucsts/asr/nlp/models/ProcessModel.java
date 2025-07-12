/**
 * 
 */
package org.topicqucsts.asr.nlp.models;

import java.io.File;

import org.topicqucsts.asr.nlp.HarvestEnvironment;
import org.topicqucsts.asr.nlp.api.IProcessModel;
import org.topicquests.asr.nlp.parsers.PMCPullParser;
import org.topicquests.asr.nlp.parsers.PubMedPullParser;
import org.topicquests.support.api.IResult;
import org.topicquests.asr.nlp.util.TextFileHandler;

/**
 * 
 */
public class ProcessModel implements IProcessModel {
	private HarvestEnvironment environment;
	private PubMedPullParser pubmedPP;
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
		TextFileHandler h = new TextFileHandler();
		String xmls = h.readFile(xml);
		return pubmedPP.parseXML(xmls);
	}

	@Override
	public IResult processPubMedDirectory(String directory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult processPMC_XML(File xml) {
		TextFileHandler h = new TextFileHandler();
		String xmls = h.readFile(xml);
		return pmcPP.parseXML(xmls);
	}

	@Override
	public IResult processPMCDirectory(String directory) {
		// TODO Auto-generated method stub
		return null;
	}

}

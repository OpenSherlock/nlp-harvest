/**
 * 
 */
package devtests;

import java.io.File;

import org.topicquests.support.api.IResult;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 */
public class PMCTest_1 extends BaseTester {
	private final String PATH = "data/pmc/pmcid_2697648.xml";

	/**
	 * 
	 */
	public PMCTest_1() {
		IResult rx = null;
		File f = new File(PATH);
		if (f != null) {
			rx = model.processPMC_XML(f);
			JsonObject jo = (JsonObject)rx.getResultObject();
			System.out.println("DID\n"+jo);
			System.out.println("errors: "+rx.getErrorString());
		} else
			System.out.println("Bad Jazz");	}

}

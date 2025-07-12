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
public class PubMedTest_1 extends BaseTester {
	private final String PATH = "data/pubmed/33305456.xml";
	/**
	 * 
	 */
	public PubMedTest_1() {
		IResult rx = null;
		File f = new File(PATH);
		if (f != null) {
			rx = model.processPubMedXML(f);
			JsonObject jo = (JsonObject)rx.getResultObject();
			System.out.println("DID\n"+jo);
			System.out.println("errors: "+rx.getErrorString());
		} else
			System.out.println("Bad Jazz");
	}

}

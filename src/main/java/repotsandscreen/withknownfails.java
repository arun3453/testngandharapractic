package repotsandscreen;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class withknownfails implements IRetryAnalyzer{

	int mincount=0;
	int maxcount=5;
	
	
	public boolean retry(ITestResult result) {
		if(mincount<maxcount) {
			mincount++;
			return true;	
			}
		
		return false;
	}

}

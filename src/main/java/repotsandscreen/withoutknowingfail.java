package repotsandscreen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class withoutknowingfail implements IAnnotationTransformer {

	public void transform(ITestAnnotation a, Class testClass, Constructor testConstructor, Method testMethod) {

		//IRetryAnalyzer retryAnalyzer = a.getRetryAnalyzer();
		a.setRetryAnalyzer(withknownfails.class);
	}

}

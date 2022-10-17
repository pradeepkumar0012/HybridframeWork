package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
@Test
public void Createcust() {
	System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
	Assert.assertEquals(true, false);
	System.out.println("step4");
}
	
@Test
public void modifycust() {
	System.out.println("modified");
	System.out.println("modifying");
}
}

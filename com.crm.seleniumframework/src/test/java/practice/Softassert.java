package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {
	@Test
	public void Createcust() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert s=new SoftAssert();
		s.assertEquals(false, true);
		System.out.println("step4");
		s.assertAll();
	}
		
	@Test
	public void modifycust() {
		System.out.println("modified");
		System.out.println("modifying");
	}

}

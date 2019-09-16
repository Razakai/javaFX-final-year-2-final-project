//Author Sean Adam Holland R00162740
package junit;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import model.Teacher;

public class teacherTest {
	
	@Test
	void Test() {
		Teacher test = new Teacher("Adam", "Holland", "adamholland12398@gmail.com", 858402914, "cit");
		String res = test.getDegree();
		assertEquals("cit", res);
	}

	private void assertEquals(String string, String res) {
		// TODO Auto-generated method stub
		
	}

	

}

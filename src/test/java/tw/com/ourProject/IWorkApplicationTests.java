package tw.com.ourProject;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
class IWorkApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MessageSource messageSource ;
	
	@Test
	public void testI18n() {
		String test1 = messageSource.getMessage("login.failed",null, Locale.TAIWAN);
		System.out.println(test1);
		String test2 = messageSource.getMessage("login.failed",null, Locale.US);
		System.out.println(test2);

	}
}

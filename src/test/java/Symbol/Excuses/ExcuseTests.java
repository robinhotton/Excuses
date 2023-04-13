package Symbol.Excuses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Symbol.Excuses.entity.Excuse;

@SpringBootTest
class ExcuseTests {
	
	private Excuse excuse;

	@BeforeEach
	void setUp() throws Exception {
		excuse = new Excuse(701, "Inexcusable", "Meh");
	}

	@Test
	void test() {
		assertEquals(701, excuse.getHttpCode());
	    assertEquals("Inexcusable", excuse.getTag());
	    assertEquals("Meh", excuse.getMessage());
	}

}

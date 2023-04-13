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
	void ExcuseCreate() {
		assertEquals(701, excuse.getHttpCode());
		assertEquals("Inexcusable", excuse.getTag());
		assertEquals("Meh", excuse.getMessage());
	}

	@Test
	void ExcuseModify() {
		excuse.setHttpCode(800);
		assertEquals(800, excuse.getHttpCode());

		excuse.setTag("Clair");
		assertEquals("Clair", excuse.getTag());

		excuse.setMessage("AutreMessage");
		assertEquals("AutreMessage", excuse.getMessage());
	}

	@Test
	void ExcuseToString() {
		assertEquals("{\"http_code\" : 701,\"tag \": \"Inexcusable\",\"message \":\" Meh\"}", excuse.toString());
	}

	@Test
	void ExcuseSelfEquals() {
		assertEquals(excuse, excuse);
	}

	@Test
	void ExcuseEquals() {
		Excuse excuse2 = new Excuse(701, "Inexcusable", "Meh");
		assertEquals(excuse2, excuse);
	}

	@Test
	void ExcuseNotEquals() {
		Excuse excuse2 = new Excuse(800, "Clair", "AutreMessage");
		assertNotEquals(excuse2, excuse);
	}
}

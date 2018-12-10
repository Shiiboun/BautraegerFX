package business.kunde;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class hatDGTest {

	@Test
	void test() {
		KundeModel kundeModel = KundeModel.getInstance();
		boolean hatDG = kundeModel.hatDachgeschoss(6);
		assertEquals(false, hatDG);	
		hatDG = kundeModel.hatDachgeschoss(5);
		assertEquals(true, hatDG);
	}

}

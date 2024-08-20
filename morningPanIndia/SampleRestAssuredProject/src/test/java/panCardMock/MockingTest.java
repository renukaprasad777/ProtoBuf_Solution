package panCardMock;

import org.mockito.Mockito;

class PanCard{
	public String isValid(String PanCard) {
		if(PanCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) {
			return "It is a valid Pan";
		}else {
			return "It is an invalid Pan";
		}
	}
	public static PanCard getMockObject() {
		PanCard mockObj = Mockito.mock(PanCard.class);
		Mockito.when(mockObj.isValid("ABCDE1234A")).thenReturn("Valid pan card");
		Mockito.when(mockObj.isValid("ABCDE1234B")).thenReturn("Valid pan card");
		Mockito.when(mockObj.isValid("ABCDE1234C")).thenReturn("Invalid pan card");
		return mockObj;
	}
}
public class MockingTest {

	public static void main(String[] args) {
		PanCard obj = PanCard.getMockObject();
		System.out.println(obj.isValid("ABCDE1234C"));
	}
}

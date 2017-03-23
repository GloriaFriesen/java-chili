import org.junit.*;
import static org.junit.Assert.*;

public class ChiliTest {
  @Test
  public void Chili_instantiatesCorrectly_true() {
    Chili myChili = new Chili("3 bean");
    assertEquals(true, myChili instanceof Chili);
  }
  @Test
  public void Chili_instantiatesWithType_String() {
    Chili myChili = new Chili("3 bean");
    assertEquals("3 bean", myChili.getType());
  }


}

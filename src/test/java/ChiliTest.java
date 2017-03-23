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

  @Test
  public void all_returnsAllInstancesOfChili_true() {
    Chili firstChili = new Chili("3 bean");
    Chili secondChili = new Chili("con carne");
    assertEquals(true, Chili.all().contains(firstChili));
    assertEquals(true, Chili.all().contains(secondChili));
  }

  @Test
  public void clear_emptiesAllChiliFromList_0() {
    Chili testChili = new Chili("3 bean");
    Chili.clear();
    assertEquals(Chili.all().size(), 0);
  }

}

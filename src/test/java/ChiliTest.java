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

  @Test
  public void getId_chiliInstantiatesWithAnId_1() {
    Chili.clear();
    Chili myChili = new Chili("3 bean");
    assertEquals(1, myChili.getId());
  }

  @Test
  public void find_returnsChiliWithSameId_secondChili() {
    Chili.clear();
    Chili firstChili = new Chili("3 bean");
    Chili secondChili = new Chili("con carne");
    assertEquals(secondChili, Chili.find(secondChili.getId()));
  }
  @Test
  public void getBeans_initiallyReturnsEmptyList_ArrayList() {
    Chili.clear();
    Chili testChili = new Chili("3 bean");
    assertEquals(0, testChili.getBeans().size());
  }

  @Test
  public void addBean_addsBeantoList_true() {
    Chili myChili = new Chili("3 bean");
    Bean myBean = new Bean("pinto");
    myChili.addBean(myBean);
    assertTrue(myChili.getBeans().contains(myBean));
  }

}

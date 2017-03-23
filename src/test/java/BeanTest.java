import org.junit.*;
import static org.junit.Assert.*;


public class BeanTest {

  @Test
  public void Bean_instantiatesCorrectly_true() {
    Bean myBean = new Bean("pinto");
    assertEquals(true, myBean instanceof Bean);
  }

  @Test
  public void Bean_instantiatesWithType_String() {
    Bean myBean = new Bean("pinto");
    assertEquals("pinto", myBean.getType());
  }

  @Test
  public void Bean_SetState_String() {
    Bean myBean = new Bean("pinto");
    myBean.setStateOfBean("canned");
    assertEquals("canned", myBean.getStateOfBean());
  }

  @Test
  public void Bean_returnsAllInstancesOfBean_true() {
    Bean firstBean = new Bean("pinto");
    Bean secondBean = new Bean("black");
    assertEquals(true, Bean.all().contains(firstBean));
    assertEquals(true, Bean.all().contains(secondBean));
  }

  @Test
  public void clear_emptiesAllBeansFromList_0() {
    Bean beanTest = new Bean("pinto");
    Bean.clear();
    assertEquals(Bean.all().size(), 0);
  }
}

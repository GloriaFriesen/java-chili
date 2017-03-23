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
}

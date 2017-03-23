import java.util.ArrayList;
import java.util.List;

public class Chili {
  private String mType;
  private static List<Chili> instances = new ArrayList<Chili>();

  public Chili(String type) {
    mType = type;
    instances.add(this);
  }

  public String getType() {
    return mType;
  }

  public static List<Chili> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }
}

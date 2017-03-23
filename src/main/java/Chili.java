import java.util.ArrayList;
import java.util.List;

public class Chili {
  private String mType;
  private static List<Chili> instances = new ArrayList<Chili>();
  private int mId;
  private List<Bean> mBeans;

  public Chili(String type) {
    mType = type;
    instances.add(this);
    mId = instances.size();
    mBeans = new ArrayList<Bean>();
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

  public int getId() {
    return mId;
  }

  public static Chili find(int id) {
    return instances.get(id - 1);
  }

  public List<Bean> getBeans() {
    return mBeans;
  }

  public void addBean(Bean bean) {
    mBeans.add(bean);
  }
}

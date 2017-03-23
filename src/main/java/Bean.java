import java.util.List;
import java.util.ArrayList;

public class Bean {
  private String mType;
  private String mState;
  private static List<Bean> instances = new ArrayList<Bean>();
  private int mId;

  public Bean(String type) {
    mType = type;
    mState = "";
    instances.add(this);
    mId = instances.size();
  }

  public String getType() {
    return mType;
  }

  public void setStateOfBean(String state) {
    mState = state;
  }

  public String getStateOfBean() {
    return mState;
  }

  public static List<Bean> all(){
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static void clear() {
    instances.clear();
  }
}

package dynamicProxy.dao;

public class UserDao implements BaseDao{
  public void save() {
    System.out.println("用户保存成功！");
  }

  @Override
  public int delete() {
    System.out.println("删除成功！");
    return 1;
  }

  @Override
  public int update() {
    System.out.println("更新成功！");
    return 0;
  }
}

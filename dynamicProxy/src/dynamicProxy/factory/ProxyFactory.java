package dynamicProxy.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dynamicProxy.afterAdvice.AfterAdvice;
import dynamicProxy.beforeAdvice.BeforeAdvice;
//动态代理工厂
public class ProxyFactory {
  private Object obj;//target
  private BeforeAdvice before;
  private AfterAdvice after;
  /**
   * 
   * @param obj 被代理对象，即目标对象
   * @param before 前置通知
   * @param after 后置通知
   */
  public ProxyFactory(Object obj, BeforeAdvice before, AfterAdvice after) {
    super();
    this.obj = obj;
    this.before = before;
    this.after = after;
  }
  public ProxyFactory() {
    super();
  }
  /**
   *  生成代理对象
   * @return 返回代理对象
   */
  public Object newProxyInstance() {
    Object object = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args)
          throws Throwable {
        if(before != null) {
          before.beforeAdvice();
        }
        //result即为接口真实实现类的返回值
        Object result = method.invoke(obj, args);
        if(after != null) {
          after.afterAdvice();
        }
        return result;
      }
    });
     //object即为代理对象
    return object;
  }
  public Object getObj() {
    return obj;
  }
  public void setObj(Object obj) {
    this.obj = obj;
  }
  public BeforeAdvice getBefore() {
    return before;
  }
  public void setBefore(BeforeAdvice before) {
    this.before = before;
  }
  public AfterAdvice getAfter() {
    return after;
  }
  public void setAfter(AfterAdvice after) {
    this.after = after;
  }
  
}

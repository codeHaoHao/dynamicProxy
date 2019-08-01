package dynamicProxy;

import dynamicProxy.afterAdvice.AfterAdvice;
import dynamicProxy.afterAdvice.TransactionAfterAdvice;
import dynamicProxy.beforeAdvice.BeforeAdvice;
import dynamicProxy.beforeAdvice.TransactionBeforeAdvice;
import dynamicProxy.dao.BaseDao;
import dynamicProxy.dao.UserDao;
import dynamicProxy.factory.ProxyFactory;

public class Client {
  public static void main(String[] args) {
    BeforeAdvice beforeAdvice = new TransactionBeforeAdvice();
    AfterAdvice afterAdvice = new TransactionAfterAdvice();
    BaseDao userdao = new UserDao();
    //要使用动态代理，用来生成代理的委托对象必须是一个接口
    ProxyFactory factory = new ProxyFactory(userdao, beforeAdvice, afterAdvice);
    BaseDao userdaoProxy = (BaseDao)factory.newProxyInstance();
    userdaoProxy.save();
    System.out.println("----------");
    userdaoProxy.delete();
  }
}

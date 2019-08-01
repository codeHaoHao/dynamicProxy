package dynamicProxy.beforeAdvice;
//自定义事务前置通知
public class TransactionBeforeAdvice implements BeforeAdvice{

  @Override
  public void beforeAdvice() {
    System.out.println("事物开始");
    
  }

}

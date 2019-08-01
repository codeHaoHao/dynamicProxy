package dynamicProxy.afterAdvice;
//自定义事务后置通知
public class TransactionAfterAdvice implements AfterAdvice{

  @Override
  public void afterAdvice() {
    System.out.println("事物结束");
    
  }
  
}

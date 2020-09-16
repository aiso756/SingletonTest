public class Client15 {
    public static void main(String[] args){
        Target target = new Adapter();
        target.targetMethod1();
        target.targetMethod2();
    }
}

public abstract class Target {
    public abstract void targetMethod1();
    public abstract void targetMethod2();
}

public class Adaptee {
    public void method1(){
        System.out.println("method1");
    }
    public void method2(){
        System.out.println("method2");
    }
}

public class Adapter extends Target {
    private Adaptee adaptee;

    public Adapter(){
      this.adaptee = new Adaptee();
      }
    public void targetMethod1(){
    adaptee.method1();
    }
    public void targetMethod2(){
    adaptee.method2();
    }
    }
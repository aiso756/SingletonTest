package kadai;

public class TheDogTest1 {
    public static void main(final String[] args) {
        final Dog pochi = new Dog();
        pochi.print();
        pochi.roudou();
        pochi.print();
        pochi.roudou();
        pochi.print();
        pochi.shokuji();
        pochi.print();
        pochi.shokuji();
        pochi.print();
    }
}

class Dog {
    private DogState myState;

    public Dog() {
        myState = TanoshiiState.getInstance();
    }

    public void roudou() {
        myState.tukareta(this);
    }

    public void shokuji() {
        myState.tabeta(this);
    }

    public void changeState(final DogState d) {
        myState = d;
    }

    public void print() {
        System.out.print("現在、わたしは「");
        System.out.print(myState.toString());
        System.out.println("」です。");
    }
}

abstract class DogState {
    public abstract void tukareta(Dog yobidashimoto); // 疲れた!

    public abstract void tabeta(Dog yobidashimoto); // 食べた!
}

class TanoshiiState extends DogState {
    private static TanoshiiState s = new TanoshiiState();

    private TanoshiiState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(final Dog moto) {
        moto.changeState(FutsuuState.getInstance());
    }

    public void tabeta(final Dog moto) {
        moto.changeState(neteruState.getInstance());
    }

    public String toString() {
        return "楽しい状態";
    }
}

class FutsuuState extends DogState {
    private static FutsuuState s = new FutsuuState();

    private FutsuuState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(final Dog moto) {
        moto.changeState(IrairaState.getInstance());
    }

    public void tabeta(final Dog moto) {
        moto.changeState(TanoshiiState.getInstance());
    }

    public String toString() {
        return "普通状態";
    }
}

class IrairaState extends DogState {
    private static IrairaState s = new IrairaState();

    private IrairaState() {
    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(final Dog moto) {
        // なにもしない
    }

    public void tabeta(final Dog moto) {
        moto.changeState(neteruState.getInstance());
    }

    public String toString() {
        return "いらいら状態";
    }
}

class neteruState extends DogState {
    private static neteruState s = new neteruState();

    private neteruState() {

    }

    public static DogState getInstance() {
        return s;
    }

    public void tukareta(final Dog moto) {
        moto.changeState(IrairaState.getInstance());
    }

    public void tabeta(final Dog moto) {
        // なにもしない
    }

    public String toString() {
        return "寝てる状態";
    }

}
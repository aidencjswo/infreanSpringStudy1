package hello.core.singleton;

public class SingletonService {
    //자기 자신을 내부적으로 static으로 가지고 있는다.
    //static은 class레벨에 올라가기 때문에 딱 하나만 가지게 된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

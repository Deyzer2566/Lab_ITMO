public interface Lookable {
    default void beLooked(){
        System.out.println("На "+toString()+" смотрят");
    }
}

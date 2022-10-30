public interface Lookable {
    public default void beLooked(){
        System.out.println("На "+toString()+" смотрят");
    }
}

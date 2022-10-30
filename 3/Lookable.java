public interface Lookable {
    public default void beLooked(){
        System.out.println("на "+toString()+" смотрят");
    }
}

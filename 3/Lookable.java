public interface Lookable {
    default void lookAtIt(){
        System.out.println("На "+toString()+" смотрят");
    }
}

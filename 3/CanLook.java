public interface CanLook {
    default void lookAt(Lookable obj){
        obj.beLooked();
    }
}

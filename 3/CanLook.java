public interface CanLook {
    public default void lookAt(Lookable obj){
        obj.beLooked();
    }
}

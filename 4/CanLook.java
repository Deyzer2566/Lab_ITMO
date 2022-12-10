public interface CanLook{
    default void lookAt(Lookable obj){
        System.out.println(this.toString() + " смотрит на "+obj.toString());
        obj.lookAtIt();
    }
}

public interface CanThink {
    default void thinkAbout(Thinkable obj){
        obj.thinkAboutIt();
    }
}

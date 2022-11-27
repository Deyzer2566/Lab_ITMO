public interface CanThink {
    default void thinkAbout(Thinkable obj){
        System.out.println(this.toString()+" думает о "+obj.toString());
        obj.thinkAboutIt();
    }
}

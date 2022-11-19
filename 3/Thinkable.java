public interface Thinkable{
    default void thinkAboutIt(){
        System.out.println("О "+this.toString()+" думают");
    }
}

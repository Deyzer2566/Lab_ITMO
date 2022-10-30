public interface Thinkable{
    public default void thinkAboutIt(){
        System.out.println("О "+this.toString()+" думают");
    }
}

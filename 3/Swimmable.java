public interface Swimmable{
    public default void swim(){
        System.out.println(toString()+" плавает");
    };
}

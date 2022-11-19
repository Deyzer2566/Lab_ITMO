public interface Swimmable{
    default void swim(){
        System.out.println(toString()+" плавает");
    };
}

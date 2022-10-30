public class Boat extends Watercraft implements Swimmable, Lookable{

    @Override
    public void beLooked(){
        System.out.println(this.toString()+" все еще плавает");
    }

    @Override
    public String toString(){
        return "лодка";
    }

}

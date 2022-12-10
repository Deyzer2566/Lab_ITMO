public class WinniPukh extends Entity implements Thinkable{

    @Override
    public String toString(){
        return "Винни-Пух";
    }

    @Override
    public void thinkAboutIt() {
        System.out.println(this.toString()+" стыдится");
    }
}

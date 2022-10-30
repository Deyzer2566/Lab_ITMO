public class Main {
    public static void main(String[] args){
        WinniPukh winni = new WinniPukh();
        Christopher christopher = new Christopher();
        Swimmable clay = new Clay();
        Swimmable boat = new Boat();//то, что ожидает увидеть
        Earth earth = new Earth();
        christopher.lookAt((Lookable) clay);
        if(!boat.equals(clay)) {
            System.out.println("Кристофер Робин ожидал увидеть не это");
        }
        christopher.thinkAbout(winni);
        winni.lookAt(earth);
    }
}

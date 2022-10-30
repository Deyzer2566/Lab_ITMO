public class Main {
    public static void main(String[] args){
        WinniPukh winni = new WinniPukh();
        Christopher christopher = new Christopher();
        Watercraft pot = Watercraft.POT;
        Earth earth = new Earth();
        christopher.lookAt((Lookable) pot);
        if(pot != Watercraft.BOAT) {
            System.out.println("Кристофер Робин ожидал увидеть не это");
        }
        christopher.thinkAbout(winni);
        winni.lookAt(earth);
    }
}
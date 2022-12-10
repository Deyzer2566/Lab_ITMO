public class Main {
    public static void main(String[] args){
        WinniPukh winni = new WinniPukh();
        Christopher christopher = new Christopher();
        Watercraft pot = Watercraft.POT;
        Earth earth = new Earth();
		//Umbrella umbrella = new Umbrella();
        christopher.lookAt((Lookable) pot);
        if(pot != Watercraft.POT) {
            System.out.println("Кристофер Робин ожидал увидеть не это");
        }
        christopher.thinkAbout(winni);
        winni.lookAt(earth);
		
		Watercraft umbrella = Watercraft.UMBRELLA;
		
		Entity [] passengers = {winni};
		System.out.println(passengers.getClass());
		
		try{
			umbrella.getOn(passengers);
		}catch(BoatIsOutweighed bio){
			System.out.println(bio.getMessage());
			System.out.println("Винни-Пух упал в воду");
		}catch(WatercraftIsSmall wis){
			System.out.println(wis.getMessage());
		}
		
		passengers = new Entity[]{winni,christopher};
		
		try{
			umbrella.getOn(passengers);
		}catch(BoatIsOutweighed bio){
			System.out.println(bio.getMessage());
		}catch(WatercraftIsSmall wis){
			System.out.println(wis.getMessage());
		}
    }
}
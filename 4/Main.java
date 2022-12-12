public class Main {
    public static void main(String[] args){
		Talkable owl = new Talkable(){
			@Override
			public String toString(){
				return "Сова";
			}
			
			@Override
			public void say(String message){
				System.out.println(toString()+" говорит "+message);
			}
		};
        WinniPukh winni = new WinniPukh();
        Christopher christopher = new Christopher();
        Watercraft pot = Watercraft.POT;
        Earth earth = new Earth();
		
		owl.say("что-то про себя");
		
        christopher.lookAt((Lookable) pot);
        if(pot != Watercraft.POT) {
            System.out.println("Кристофер Робин ожидал увидеть не это");
        }
        christopher.thinkAbout(winni);
        winni.lookAt(earth);
		
		winni.saySomethingSmart();
		
		Watercraft umbrella = Watercraft.UMBRELLA;
		
		try{
			umbrella.theThinkThatSwims.getOn(new Entity[]{winni});//passengers);
		}catch(BoatIsOutweighed bio){
			System.out.println(bio.getMessage());
		}catch(WatercraftIsSmall wis){
			System.out.println(wis.getMessage());
		}
		
		try{
			umbrella.theThinkThatSwims.getOn(new Entity[]{winni,christopher});
		}catch(BoatIsOutweighed bio){
			System.out.println(bio.getMessage());
		}catch(WatercraftIsSmall wis){
			System.out.println(wis.getMessage());
		}
		umbrella.swim();
    }
}

public enum Watercraft implements Swimmable,Lookable{
    BOAT{
        @Override
        public String toString(){
            return "лодка";
        }
    },
    POT{
        @Override
        public String toString(){
            return "Плавучий Медведь";
        }
    },
	UMBRELLA{
		@Override
		public String toString(){
			return "зонтик";
		}
	};
	
    @Override
    public void lookAtIt(){
        this.swim();
    }
	
	class Boat implements Swimmable{
		private Entity[] passengers;
		
		@Override
		public void swim(){
			System.out.println(toString() + "плавает");
		}
		
		public void drop(Entity entity) throws ThereIsNotThePassenger{
			int index = 0;
			for(;index<passengers.length;index++)
				if (passengers[index]==entity){
					break;
				}
			if (index == passengers.length){
				throw new ThereIsNotThePassenger("Тут его нет!");
			}
			System.out.println(entity.toString() + " упал в воду");
		}
		
		public void getOn(Entity[] passengers) throws WatercraftIsSmall, BoatIsOutweighed{
			this.passengers=passengers;
			System.out.println("В "+Watercraft.this.toString()+" забрались:");
			for(Entity en:passengers){
				System.out.print(en.toString()+", ");
			}
			System.out.println();
			if(Watercraft.this == POT){
				throw new WatercraftIsSmall(this.toString()+" не подходит для плавания!");
			}
			if(this.passengers.length % 2 != 0){
				for(Entity en:this.passengers){
					this.drop(en);
				}
				throw new BoatIsOutweighed(Watercraft.this.toString()+" перевешен!");
			}
			System.out.println("Все успешно забрались в "+Watercraft.this.toString());
		}
	}
	Boat theThinkThatSwims = new Boat();
}

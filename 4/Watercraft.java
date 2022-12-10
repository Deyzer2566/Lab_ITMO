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
	
	private Entity[] passengers;
	
    @Override
    public void lookAtIt(){
        this.swim();
    }
	
	public void getOn(Entity[] passengers) throws WatercraftIsSmall, BoatIsOutweighed{
		if(this == POT){
			throw new WatercraftIsSmall(this.toString()+" не подходит для плавания!");
		}
		if(passengers.length % 2 != 0){
			throw new BoatIsOutweighed(this.toString()+" перевешен!");
		}
		this.passengers=passengers;
		System.out.println("Все успешно забрались в "+this.toString()+" "+this.passengers.length);
	}
}

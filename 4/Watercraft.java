public enum Watercraft implements Swimmable,Lookable{
    BOAT{
        @Override
        public String toString(){
            return "�����";
        }
    },
    POT{
        @Override
        public String toString(){
            return "�������� �������";
        }
    },
	UMBRELLA{
		@Override
		public String toString(){
			return "������";
		}
	};
	
	private Entity[] passengers;
	
    @Override
    public void lookAtIt(){
        this.swim();
    }
	
	public void getOn(Entity[] passengers) throws WatercraftIsSmall, BoatIsOutweighed{
		if(this == POT){
			throw new WatercraftIsSmall(this.toString()+" �� �������� ��� ��������!");
		}
		if(passengers.length % 2 != 0){
			throw new BoatIsOutweighed(this.toString()+" ���������!");
		}
		this.passengers=passengers;
		System.out.println("��� ������� ��������� � "+this.toString()+" "+this.passengers.length);
	}
}

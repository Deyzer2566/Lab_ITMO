public class Christopher extends Entity implements CanThink {
    @Override
    public String toString() {
        return "Кристофер Робин";
    }

	@Override
	public void thinkAbout(Thinkable obj){
        System.out.println(this.toString()+" думает о "+obj.toString());
        obj.thinkAboutIt();
    }
}

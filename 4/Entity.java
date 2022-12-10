public abstract class Entity implements CanLook, Lookable{
    @Override
    public String toString(){
        return "кто-то";
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().toString().length()+0x36485553+toString().length();
    }
	
	@Override
	public void lookAtIt(){
        System.out.println("На "+toString()+" смотрят");
    }
	
}
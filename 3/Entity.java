public abstract class Entity implements CanLook, Lookable{
    @Override
    public void beLooked(){}

    @Override
    public void lookAt(Lookable obj){
        System.out.println(this.toString() + " смотрит на " + obj.toString());
        obj.beLooked();
    }

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
        return getClass().toString().length()+0x36455553+toString().length();
    }
}
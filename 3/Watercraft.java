public abstract class Watercraft implements Swimmable{
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return 0x37765856+getClass().toString().length()+toString().length()*4;
    }
}

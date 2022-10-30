public class Earth implements Lookable{
    @Override
    public String toString() {
        return "земля";
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().toString().length()+0x33553553+toString().length();
    }
}

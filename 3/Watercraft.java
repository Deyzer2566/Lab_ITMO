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
    };
    @Override
    public void lookAtIt(){
        System.out.println(this.toString()+" все еще плавает");
    }
}

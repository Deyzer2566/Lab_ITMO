import java.util.Random;
public class WinniPukh extends Entity implements Thinkable{

	private static String [] names = {"Винни-Пух","Друг Пятачка","Приятель Кролика","Открыватель Полюса","Утешитель Иа-Иа и Находитель Хвоста"};
	
    @Override
    public String toString(){
		int i = new Random().nextInt();
		if (i < 0)
			i = -i;
        return names[i%names.length];
    }

    @Override
    public void thinkAboutIt() {
        System.out.println(this.toString()+" стыдится");
    }
	
	public void saySomethingSmart(){
		class SmartThing{
			private String text = "мудрая вещь";
			
			@Override
			public String toString(){
				return WinniPukh.this.toString() + " сказал "+text;
			}
		}
		System.out.println(new SmartThing());
	}
}

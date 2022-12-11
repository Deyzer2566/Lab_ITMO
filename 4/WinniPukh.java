import java.util.Random;
public class WinniPukh extends Entity implements Thinkable{

	private static String [] names = {"�����-���","���� �������","�������� �������","����������� ������","��������� ��-�� � ���������� ������"};
	
    @Override
    public String toString(){
		int i = new Random().nextInt();
		if (i < 0)
			i = -i;
        return names[i%names.length];
    }

    @Override
    public void thinkAboutIt() {
        System.out.println(this.toString()+" ��������");
    }
	
	public void saySomethingSmart(){
		class SmartThing{
			private String text = "������ ����";
			
			@Override
			public String toString(){
				return WinniPukh.this.toString() + " ������ "+text;
			}
		}
		System.out.println(new SmartThing());
	}
}

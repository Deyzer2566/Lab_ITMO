package moves;
import ru.ifmo.se.pokemon.*;
public class Pound extends PhysicalMove{
	public Pound(){
		super(Type.NORMAL,40,100);
	}
	protected String describe(){
		return "использовал pound";//?!?!
	}
}
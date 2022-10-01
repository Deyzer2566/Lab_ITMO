spackage moves;
import ru.ifmo.se.pokemon.*;
public class XScissor extends PhysicalMove{
	public XScissor(){
		super(Type.BUG,80,100);
	}
	protected String describe(){
		return "прошелся ножницами";
	}
}
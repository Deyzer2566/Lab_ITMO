package moves;
import ru.ifmo.se.pokemon.*;
public class DoubleEdge extends PhysicalMove{
	public DoubleEdge(){
		super(Type.NORMAL,120,100);
	}
	protected void applySelfDamage(Pokemon att, double damage){
		att.setMod(Stat.HP,(int)(damage/3.0));
	}
	protected String describe(){
		return "использовал двойное лезвие";
	}
}
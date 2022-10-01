package moves;
import ru.ifmo.se.pokemon.*;
public class IceBeam extends SpecialMove{
	public IceBeam(){
		super(Type.ICE,90,100);
	}
	protected void applyOppEffects(Pokemon p){
		p.addEffect(new Effect().chance(0.1).condition(Status.FREEZE));
	}
		
	protected String describe(){
		return "выпустил ледяной луч";
	}
}
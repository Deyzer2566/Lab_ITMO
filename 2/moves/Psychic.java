package moves;
import ru.ifmo.se.pokemon.*;
public class Psychic extends SpecialMove{
	public Psychic(){
		super(Type.PSYCHIC,90,100);
	}
	protected void applyOppEffects(Pokemon p){
		p.addEffect(new Effect().chance(0.1).turns(1).stat(Stat.SPECIAL_DEFENSE,-1));
	}
	protected String describe(){
		return "устроил мозговой штурм";
	}
}
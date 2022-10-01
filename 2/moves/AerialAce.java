package moves;
import ru.ifmo.se.pokemon.*;
public class AerialAce extends PhysicalMove{
	public AerialAce(){
		super(Type.FLYING,60,Double.POSITIVE_INFINITY);
	}
	protected String describe(){
		return "использовал Aerial Ace";
	}
}
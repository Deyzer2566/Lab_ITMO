package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.*;
public class Shedinja extends Nincada{
	public Shedinja(String name,int lvl){
		super(name,lvl);
		setType(Type.BUG,Type.GHOST);
		setStats(1.0,90.0,45.0,30.0,30.0,40.0);
		addMove(new WillOWisp());
	}
}
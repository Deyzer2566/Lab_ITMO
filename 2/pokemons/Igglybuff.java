package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.*;
public class Igglybuff extends Pokemon{
	public Igglybuff(String name,int lvl){
		super(name,lvl);
		setType(Type.NORMAL,Type.FAIRY);
		setStats(90.0,30.0,15.0,40.0,20.0,15.0);
		setMove(new Psychic(), new FireBlast());
	}
}
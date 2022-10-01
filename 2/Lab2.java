import ru.ifmo.se.pokemon.*;
import moves.*;
import pokemons.*;

public class Lab2{
	public static void main(String [] args){
		Battle b = new Battle();
		Pokemon p1 = new Wishiwashi("Рыбка", 1);
		Pokemon p2 = new Nincada("Жук", 1);
		Pokemon p3 = new Shedinja("Призрак-жук",1);
		Pokemon p4 = new Igglybuff("Розовое пятнышко",1);
		Pokemon p5 = new Jigglypuff("Розовый комочек",1);
		Pokemon p6 = new Wigglytuff("Розовый крол",1);
		b.addAlly(p1);
		b.addAlly(p2);
		b.addAlly(p3);
		b.addFoe(p4);
		b.addFoe(p5);
		b.addFoe(p6);
		b.go();
	}
}

import ru.ifmo.se.pokemon.*;
import moves.*;
import pokemons.*;

public class Lab2{
	public static void main(String [] args){
		Battle b = new Battle();
		Pokemon p1 = new Wishiwashi("�����", 1);
		Pokemon p2 = new Nincada("���", 1);
		Pokemon p3 = new Shedinja("�������-���",1);
		Pokemon p4 = new Igglybuff("������� ��������",1);
		Pokemon p5 = new Jigglypuff("������� �������",1);
		Pokemon p6 = new Wigglytuff("������� ����",1);
		b.addAlly(p1);
		b.addAlly(p2);
		b.addAlly(p3);
		b.addFoe(p4);
		b.addFoe(p5);
		b.addFoe(p6);
		b.go();
	}
}

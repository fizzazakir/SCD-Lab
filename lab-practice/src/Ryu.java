
public class Ryu extends Fighter {
	
	Ryu(KickBehavior k){
		super();
		k=new TornadoKick();
	}
	void Kick() {
		// TODO Auto-generated method stub
		System.out.print("\nRYU KICK !");
	}
	void Display() {
		System.out.print("\nRYU DISPLAY !");
	}
	
}

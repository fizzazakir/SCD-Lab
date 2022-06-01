
public class testStrategy {
	public static void main(String[] args) {
		KickBehavior k=new TornadoKick();
		JumpBehavior j;
		Fighter f=new Ryu(k);
		f.Display();
		f.SetJumpBehavior(j=new ShortJump());
		f.Kick();
	}

}


public class Main {

	public static void main(String[] args) {
		View view = new View();
		Model model = new Model(view);
		new Controller(model, view);	
	}

}

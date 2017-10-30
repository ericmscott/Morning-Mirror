public class Model{
	View view;
	
	public Model (View view){
		this.view = view;
	}
	
	public void update(int counter) {
		view.update(counter);
		return;
	}
	
	
}

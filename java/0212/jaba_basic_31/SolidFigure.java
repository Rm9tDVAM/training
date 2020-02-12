public interface SolidFigure {
	void displayAreaInfo();
}
class Cube implements SolidFigure{
	double width;
	public Cube(double width){
		this.width=width;
	}
	@Override
	public void displayAreaInfo() {
		System.out.printf("立方体 １辺の長さ= %.2f  体積 = %.2f  表面積= %.2f%n",
				this.width,
				Math.pow(this.width, 3),
				Math.pow(this.width, 2)*6
				);
	}
}
class Sphere implements SolidFigure{
	private double r;
	public Sphere(double r){
		this.r=r;
	}

	@Override
	public void displayAreaInfo() {
		System.out.printf("球 半径= %.2f  体積 = %.2f  表面積= %.2f%n",
				this.r,
				4*Math.PI*Math.pow(this.r, 3)/3,
				4*Math.PI*Math.pow(this.r, 2)
				);		
	}
}

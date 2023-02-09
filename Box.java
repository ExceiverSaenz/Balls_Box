class Box{
	private double width, height, length;


	Box(double w, double h, double l){
		width=w;
		height=h;
		length=l;
	}

	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}

	public double getLength(){
		return length;
	}

	public void setWidth(double w){
		width = w;
	}
	public void setHeight(double h){
		height = h;
	}

	public void setLength(double l){
		length = l;
	}

	public double getVolume(){
		return width*height*length;
	}

	public String toString(){
		return "width: "+width+
				"\theight: "+height+
				"\tlength: "+length+
				"\tVolume: "+getVolume();
	}          
}
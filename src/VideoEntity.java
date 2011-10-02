
public class VideoEntity {
	private boolean inRental;
	private VideoTitle title;
	private String identifier;
	public VideoEntity(VideoTitle title) {
		this.title = title;
	}
	public void setIdentifier(String identifier){this.identifier = identifier;}
	public String getIdentifier() {return this.identifier;}
	public void setInRental(boolean flag) {this.inRental = flag;}
	public boolean isInRental() {return this.inRental;}
	public VideoTitle getTitle() {	return title;	}
	public String toString(){return "VideoEntity:"+this.identifier+","+title.getName()+"["+inRental+"]";}
}

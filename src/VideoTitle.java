import java.util.HashSet;
import java.util.Set;


public class VideoTitle {
	private String name;
	private String identifier;
	private MediaType media;
	private Set<Object> entityList;
	
	public VideoTitle(String name){
		this.name = name;
		entityList = new HashSet<Object>();
	}
	public void setIdentifier(String identifier){this.identifier = identifier;}
	public String getIdentifier() {return this.identifier;}
	public String getName() {return this.name;}
	public void setName(String name){this.name = name;}
	public void setMediaType(MediaType media) {this.media = media;}
	public MediaType mediaType() {return this.media;}
	public String toString(){return "VideoTitle:"+this.identifier+","+this.name+"("+entityList.size()+")";}
	public Set<Object> getEntityList(){
		return entityList;
	}
}

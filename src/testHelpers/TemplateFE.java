package testHelpers;

// Represents a template as presented by the front end

public class TemplateFE {
	
	private String title;
	private String category;
	private String position;
	private String practice;

	public TemplateFE(String title, String category, String position, String practice)
	{
		this.title = title;
		this.category = category;
		this.position = position;
		this.practice = practice;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public String getPractice()
	{
		return practice;
	}	
}

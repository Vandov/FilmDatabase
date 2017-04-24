import java.io.Serializable;
import java.util.Date;

public class Film
  implements Serializable
{
  private static final long serialVersionUID = 5442385391719024884L;
  private String title;
  private String genre;
  private Date added_in;
  private boolean seen;
  
  public Film(String theTitle, String theGenre)
  {
    title = theTitle;
    genre = theGenre;
    seen = false;
    added_in = new Date();
  }
  

  public String getTitle()
  {
    return title;
  }
  
  public String getGenre() {
    return genre;
  }
  
  public boolean isSeen() {
    return seen;
  }
  
  public Date getAdded_in() {
    return added_in;
  }
  

  public void setSeen(boolean bool)
  {
    seen = bool;
  }
}
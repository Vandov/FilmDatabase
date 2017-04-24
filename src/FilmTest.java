import org.junit.Test;

public class FilmTest
{
  public FilmTest() {}
  
  @Test
  public void getTitleTest() {
    Film a = new Film("AAAA", "AaAa");
    org.junit.Assert.assertEquals("AAAA", a.getTitle());
  }
  
  @Test
  public void getGenreTest() {
    Film a = new Film("AAAA", "AaAa");
    org.junit.Assert.assertEquals("AaAa", a.getGenre());
  }
  
  @Test
  public void getAdded_inTest() {
    Film a = new Film("AAAA", "AaAa");
    org.junit.Assert.assertEquals(new java.util.Date(), a.getAdded_in());
  }
  
  @Test
  public void isSeenTest() {
    Film a = new Film("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(a.isSeen()));
  }
  
  @Test
  public void setSeenTest() {
    Film a = new Film("AAAA", "AaAa");
    a.setSeen(true);
    org.junit.Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(a.isSeen()));
  }
}

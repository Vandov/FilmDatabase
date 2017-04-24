import org.junit.Test;

public class FilmDataTest
{
  public FilmDataTest() {}
  
  @Test
  public void getValueAtTest_Title() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals("AAAA", data.getValueAt(0, 0));
  }
  
  @Test
  public void getValueAtTest_Genre() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals("AaAa", data.getValueAt(0, 1));
  }
  
  @Test
  public void getValueAtTest_Added_in() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(new java.util.Date(), data.getValueAt(0, 2));
  }
  
  @Test
  public void getValueAtTest_isSeen() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(false), data.getValueAt(0, 3));
  }
  

  @Test
  public void setValueAtTest_Title()
  {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.setValueAt("BBBB", 0, 0);
    org.junit.Assert.assertEquals("AAAA", data.getValueAt(0, 0));
  }
  
  @Test
  public void setValueAtTest_Genre() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.setValueAt("BbBb", 0, 1);
    org.junit.Assert.assertEquals("AaAa", data.getValueAt(0, 1));
  }
  
  @Test
  public void setValueAtTest_Added_in() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.setValueAt(new java.util.Date(0L), 0, 2);
    org.junit.Assert.assertEquals(new java.util.Date(), data.getValueAt(0, 2));
  }
  
  @Test
  public void setValueAtTest_isSeen() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.setValueAt(Boolean.valueOf(true), 0, 3);
    org.junit.Assert.assertEquals(Boolean.valueOf(true), data.getValueAt(0, 3));
  }
  

  @Test
  public void addFilmTest_Title()
  {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals("AAAA", ((Film)data.films.get(0)).getTitle());
  }
  
  @Test
  public void addFilmTest_Genre() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals("AaAa", ((Film)data.films.get(0)).getGenre());
  }
  
  @Test
  public void addFilmTest_Date() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(new java.util.Date(), ((Film)data.films.get(0)).getAdded_in());
  }
  
  @Test
  public void addFilmTest_isSeen() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(((Film)data.films.get(0)).isSeen()));
  }
  

  @Test
  public void getRowCountTest()
  {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(1L, data.getRowCount());
  }
  
  @Test
  public void getColumnCountTest() {
    FilmData data = new FilmData();
    org.junit.Assert.assertEquals(4L, data.getColumnCount());
  }
  
  @Test
  public void getColumnNameTest_Title() {
    FilmData data = new FilmData();
    String[] s = { "Title", "Genre", "Date added to list", "Watched" };
    org.junit.Assert.assertEquals(s[0], data.getColumnName(0));
  }
  
  @Test
  public void getColumnNameTest_Genre() {
    FilmData data = new FilmData();
    String[] s = { "Title", "Genre", "Date added to list", "Watched" };
    org.junit.Assert.assertEquals(s[1], data.getColumnName(1));
  }
  
  @Test
  public void getColumnNameTest_Added_in() {
    FilmData data = new FilmData();
    String[] s = { "Title", "Genre", "Date added to list", "Watched" };
    org.junit.Assert.assertEquals(s[2], data.getColumnName(2));
  }
  
  @Test
  public void getColumnNameTest_isSeen() {
    FilmData data = new FilmData();
    String[] s = { "Title", "Genre", "Date added to list", "Watched" };
    org.junit.Assert.assertEquals(s[3], data.getColumnName(3));
  }
  

  @Test
  public void isEditable_Title()
  {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(data.isCellEditable(0, 0)));
  }
  
  @Test
  public void isEditable_Genre() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(data.isCellEditable(0, 1)));
  }
  
  @Test
  public void isEditable_Added_in() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(data.isCellEditable(0, 2)));
  }
  
  @Test
  public void isEditable_isSeen() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    org.junit.Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(data.isCellEditable(0, 3)));
  }
  

  @Test
  public void removeFilmTest_AAAA()
  {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.addFilm("BBBB", "BbBb");
    data.addFilm("CCCC", "CcCc");
    data.removeFilm(1);
    org.junit.Assert.assertEquals("AAAA", data.getValueAt(0, 0));
  }
  
  @Test
  public void removeFilmTest_BBBB() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.addFilm("BBBB", "BbBb");
    data.addFilm("CCCC", "CcCc");
    data.removeFilm(1);
    org.junit.Assert.assertNotEquals("BBBB", data.getValueAt(1, 0));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void removeFilmTest_CCCC_1() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.addFilm("BBBB", "BbBb");
    data.addFilm("CCCC", "CcCc");
    data.removeFilm(1);
    org.junit.Assert.assertEquals("CCCC", data.getValueAt(2, 0));
  }
  
  @Test
  public void removeFilmTest_CCCC_2() {
    FilmData data = new FilmData();
    data.addFilm("AAAA", "AaAa");
    data.addFilm("BBBB", "BbBb");
    data.addFilm("CCCC", "CcCc");
    data.removeFilm(1);
    org.junit.Assert.assertEquals("CCCC", data.getValueAt(1, 0));
  }
}

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FilmData extends AbstractTableModel
{
  private static final long serialVersionUID = 602184361290932949L;
  ArrayList<Film> films = new ArrayList();
  
  public FilmData() {}
  
  public int getColumnCount()
  {
    return 4;
  }
  
  public int getRowCount()
  {
    return films.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Film film = (Film)films.get(rowIndex);
    if (columnIndex == 0) return film.getTitle();
    if (columnIndex == 1) return film.getGenre();
    if (columnIndex == 2) return film.getAdded_in();
    return Boolean.valueOf(film.isSeen());
  }
  
  public String getColumnName(int columnIndex)
  {
    String[] s = { "Title", "Genre", "Date added to list", "Watched" };
    return s[columnIndex];
  }
  
  public Class<?> getColumnClass(int columnIndex)
  {
    if (columnIndex == 3) return Boolean.class;
    if (columnIndex == 2) return java.util.Date.class;
    return String.class;
  }
  


  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
    if (columnIndex == 3) return true;
    return false;
  }
  
  public void setValueAt(Object aValue, int rowIndex, int columnIndex)
  {
    Film film = (Film)films.get(rowIndex);
    if (columnIndex == 3) film.setSeen(((Boolean)aValue).booleanValue());
    fireTableDataChanged();
  }
  

  public void addFilm(String theTitle, String theGenre)
  {
    films.add(new Film(theTitle, theGenre));
    fireTableDataChanged();
  }
  
  public void removeFilm(int i) { films.remove(i);
    fireTableDataChanged();
  }
}

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;

public class FilmFrame extends javax.swing.JFrame
{
  private static final long serialVersionUID = 2072565255405371121L;
  private FilmData data;
  JTextField titleField;
  String[] genres = { "N/A", "Action", "Adventure", "Art", "Biographical", "Comedy", "Documentary", "Drama", "Erotic", "Educational", "Epic", "Experimental", "Exploitation", "Fantasy", "Film noir", "Horror", "Musical", "Mystery", "Pornographic", "Propaganda", "Reality", "Romance", "Science fiction", "Thriller", "Trick" };
  JComboBox<String> genreBox = new JComboBox(genres);
  JButton buttonADD = new JButton("ADD");
  JButton buttonDELETE = new JButton("DELETE SELECTED");
  JPanel panelNORTH;
  javax.swing.JLabel searchLabel = new javax.swing.JLabel("Search: ");
  JTable table = new JTable(data);
  
  javax.swing.table.TableRowSorter<AbstractTableModel> model;
  
  RowFilter<AbstractTableModel, Object> firstFiler;
  RowFilter<AbstractTableModel, Object> secondFilter;
  ArrayList<RowFilter<AbstractTableModel, Object>> filters;
  RowFilter<AbstractTableModel, Object> compoundRowFilter;
  
  public FilmFrame()
  {
    setTitle("My film database");
    setDefaultCloseOperation(3);
    try {
      data = new FilmData();
      ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream("my_data.dat"));
      data.films = ((ArrayList)ois.readObject());
      ois.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    addWindowListener(new java.awt.event.WindowAdapter()
    {
      public void windowClosing(java.awt.event.WindowEvent e) {
        try {
          ObjectOutputStream oos = new ObjectOutputStream(new java.io.FileOutputStream("my_data.dat"));
          oos.writeObject(data.films);
          oos.close();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    setMinimumSize(new java.awt.Dimension(1000, 600));
    setResizable(true);
    Components();
  }
  

  public static void main(String[] args)
  {
    FilmFrame frame = new FilmFrame();
    frame.setVisible(true);
  }
  
  private class ADDActionButtonListener implements java.awt.event.ActionListener
  {
    private ADDActionButtonListener() {}
    
    public void actionPerformed(ActionEvent arg0) {
      if (titleField.getText().length() != 0) {
        data.addFilm(titleField.getText(), (String)genreBox.getSelectedItem());
        FilmFrame.this.search(titleField.getText(), (String)genreBox.getSelectedItem());
      }
    }
  }
  
  private class DELETEActionButtonListener implements java.awt.event.ActionListener {
    private DELETEActionButtonListener() {}
    
    public void actionPerformed(ActionEvent arg0) { int[] these = table.getSelectedRows();
      for (int i = these.length - 1; i >= 0; i--) {
        int modelRow = table.getRowSorter().convertRowIndexToModel(these[i]);
        data.removeFilm(modelRow);
        FilmFrame.this.search(titleField.getText(), (String)genreBox.getSelectedItem());
      }
    }
  }
  
  private class TEXTListener implements java.awt.event.KeyListener
  {
    private TEXTListener() {}
    
    public void keyPressed(KeyEvent arg0) {}
    
    public void keyReleased(KeyEvent arg0)
    {
      FilmFrame.this.search(titleField.getText(), (String)genreBox.getSelectedItem());
    }
    
    public void keyTyped(KeyEvent arg0) {}
  }
  
  private class BOXActionListener
    implements java.awt.event.ActionListener
  {
    private BOXActionListener() {}
    
    public void actionPerformed(ActionEvent arg0)
    {
      FilmFrame.this.search(titleField.getText(), (String)genreBox.getSelectedItem());
    }
  }
  

  private void search(String typed, String box)
  {
    firstFiler = null;
    secondFilter = null;
    compoundRowFilter = null;
    try {
      filters = new ArrayList();
      firstFiler = RowFilter.regexFilter("(?i)" + typed, new int[] { 0 });
      secondFilter = RowFilter.regexFilter("(?i)" + box, new int[] { 1 });
      filters.add(firstFiler);
      if (box != "N/A") {
        filters.add(secondFilter);
      }
      compoundRowFilter = RowFilter.andFilter(filters);
    } catch (java.util.regex.PatternSyntaxException e) {
      return;
    }
    model.setRowFilter(compoundRowFilter);
  }
  

  public void Components()
  {
    setLayout(new java.awt.BorderLayout());
    JPanel panelNORTH = new JPanel();
    panelNORTH.add(searchLabel);
    titleField = new JTextField(50);
    FilmFrame.TEXTListener textListener = new FilmFrame.TEXTListener();
    titleField.addKeyListener(textListener);
    panelNORTH.add(titleField);
    FilmFrame.BOXActionListener boxListener = new FilmFrame.BOXActionListener();
    genreBox.addActionListener(boxListener);
    panelNORTH.add(genreBox);
    add(panelNORTH, "North");
    table = new JTable(data);
    table.setFillsViewportHeight(true);
    model = new javax.swing.table.TableRowSorter(data);
    table.setRowSorter(model);
    javax.swing.JScrollPane pane = new javax.swing.JScrollPane(table);
    add(pane, "Center");
    FilmFrame.ADDActionButtonListener listenerADD = new FilmFrame.ADDActionButtonListener();
    buttonADD.addActionListener(listenerADD);
    panelNORTH.add(buttonADD);
    FilmFrame.DELETEActionButtonListener listenerDELETE = new FilmFrame.DELETEActionButtonListener();
    buttonDELETE.addActionListener(listenerDELETE);
    panelNORTH.add(buttonDELETE);
  }
}
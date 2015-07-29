import java.awt.BorderLayout;
import java.awt.Color;
//github.com/SoftechUniKL/Solvent
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//github.com/SoftechUniKL/Solvent
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
//github.com/SoftechUniKL/Solvent
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.opencsv.CSVReader;

public class MonatsuebersichtGUI extends JFrame {
	
	private JMenuBar menuBar;
	private JPanel contentPane;
	private Sparziel sparziel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonatsuebersichtGUI frame = new MonatsuebersichtGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public MonatsuebersichtGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 700);


		/**
		 * Fuegt der Menuebar Buttons hinzu
		 */
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);

		JButton btnStart = new JButton("Start");
		btnStart.setBackground(Color.GRAY);
		menuBar.add(btnStart);
		
		JButton btnAusgaben = new JButton("Ausgaben");
		btnAusgaben.setBackground(Color.GRAY);
		menuBar.add(btnAusgaben);

		JButton btnEinnahmen = new JButton("Einnahmen");
		btnEinnahmen.setBackground(Color.GRAY);
		menuBar.add(btnEinnahmen);

		JButton btnTbersicht = new JButton("Monatsuebersicht");
		btnTbersicht.setBackground(Color.GRAY);
		menuBar.add(btnTbersicht);

		JButton btnMonatsbersicht = new JButton("Jahresuebersicht");
		btnMonatsbersicht.setBackground(Color.GRAY);
		menuBar.add(btnMonatsbersicht);

		JButton btnPlanung = new JButton("Planung");
		btnPlanung.setBackground(Color.GRAY);
		menuBar.add(btnPlanung);

		JButton btnSparen = new JButton("Sparen");
		btnSparen.setBackground(Color.GRAY);
		menuBar.add(btnSparen);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		/** 
		 * Gibt demBenutzer die Moeglichkeit hoch bzw runter zu scrollen
		 */
		JScrollBar scrollBar = new JScrollBar();
		contentPane.add(scrollBar, BorderLayout.EAST);

		/**
		 * Fuegt dem Button Start eine Aktion beim Klicken hinzu
		 */
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JLabel lblMonatsbersicht = new JLabel("Monatsuebersicht");
				lblMonatsbersicht.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(lblMonatsbersicht, BorderLayout.NORTH);

				JLabel lblNewLabel = new JLabel("Ihre Uebersicht fuer diesen Monat");
				JLabel lblNewLabel_1 = new JLabel("Einnahmen:");
				JLabel lblNewLabel_2 = new JLabel("Ausgaben:");

				JButton btnSparziel = new JButton("Neues Sparziel/Schulden hinzufuegen");
				JButton btnHinzufuegen = new JButton("Neue Buchung hinzufuegen");
				
    			
				JLabel lblHierEinnahmenEinfgen = new JLabel(funktion ("einnahmen"));
				
				JLabel lblHierAusgabenEinfgen = new JLabel("Hier Ausgaben einfuegen");
				JLabel lblRestbudget = new JLabel("Verbleibendes Budget:");
				JLabel lblRestbudgetEinfgen = new JLabel("Restbudget einfuegen");

	    		GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    		gl_contentPane.setHorizontalGroup(
	    			gl_contentPane.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addContainerGap()
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_contentPane.createSequentialGroup()
	    							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    								.addComponent(lblRestbudget)
	    								.addComponent(lblNewLabel_1)
	    								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
	    							.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
	    							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    									.addComponent(lblRestbudgetEinfgen)
	    									.addGroup(gl_contentPane.createSequentialGroup()
	    										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    											.addComponent(lblHierEinnahmenEinfgen)
	    											.addComponent(lblHierAusgabenEinfgen))
	    										.addGap(184)))
	    								.addContainerGap(191, Short.MAX_VALUE))
	    							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
	    							.addGroup(gl_contentPane.createSequentialGroup()
	    								.addComponent(btnHinzufuegen)
	    								.addGap(45)
	    								.addComponent(btnSparziel)
	    								.addContainerGap())))
	    		);
	    		gl_contentPane.setVerticalGroup(
	    			gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
	    					.addGap(14)
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(lblNewLabel_1)
	    						.addComponent(lblHierEinnahmenEinfgen))
	    					.addGap(24)
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(lblNewLabel_2)
	    						.addComponent(lblHierAusgabenEinfgen))
	    					.addGap(33)
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(lblRestbudget)
	    						.addComponent(lblRestbudgetEinfgen))
	    					.addGap(22)
	    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(btnHinzufuegen)
	    						.addComponent(btnSparziel))
	    					.addContainerGap(20, Short.MAX_VALUE))
	    			);
	    		contentPane.setLayout(gl_contentPane);
	    		contentPane.removeAll();
	    	
				btnHinzufuegen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Eingabe obj = new Eingabe();
						obj.setVisible(true);
					}
				});

				btnSparziel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sparziel = new Sparziel();
						sparziel.setVisible(true);
					}
				});	
			}
		});

		/**
		 * Fuegt dem Button Monatsuebersicht eine Aktion beim Klicken hinzu
		 */
		btnTbersicht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		/*		JFrame f = new JFrame( "Achtung!!!!!!!!!!! Julia ist Krank, bitte nichtmehr klicken!!!!");
				ImageIcon icon = new ImageIcon("data//53.jpg");
				JLabel l1 = new JLabel (icon);
				JPanel feld = new JPanel();
				feld.add(l1);
				feld.setBounds(50, 50, 510, 510);
    		    f.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
    		    f.setSize( 800, 800 );
    		   
    		   
    		    f.add(feld);
    		   f.setVisible( true );   
					
				// Tabelle mit einer Monatsuebersicht
			/*	JTable table;
				table = new JTable();
				table.setVisible(true);
				table.setBackground(Color.BLUE);
				table.setModel(new DefaultTableModel(new Object[][] {
						{ "Monat", "Saldo" }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() },
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() },
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() },
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() },
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, 
						{ Monatsuebersicht.Saldo(), Monatsuebersicht.Saldo() }, }, 
						new String[] {	"New column", "New column" }));
				contentPane.add(table, BorderLayout.WEST);
*/
				// Graphische Darstellung
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				JFreeChart chart = ChartFactory.createLineChart("uebersicht","Monat", "Ausgaben", dataset);
				ChartPanel chartPanel = new ChartPanel(chart);
				getContentPane().add(chartPanel, BorderLayout.CENTER);
				chartPanel.setBackground(Color.BLUE);
				
			}
		});
		btnAusgaben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Test");
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				JLabel lblUebersicht = new JLabel("Uebersicht ihrer Ausgaben");
			
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(null);
				scrollPane.setBorder(null);
				
				//Modifiziert das Fenster "neue Buchung" und gibt Positionen der Buttons an 
				ArrayList<Posten> ausgaben = CSVReader("data/ausgaben.csv");
				
				Object[][] data = new Object[ausgaben.size()][3];
				int i = 0;
				for (Posten p : ausgaben) {
					data[i][0] = new SimpleDateFormat("dd/MM/yyyy")
							.format(p.getDatum());
					data[i][1] = p.getBezeichnung();
					data[i][2] = String.format("%.2f", p.getBetrag());
					i++;
				}
				
			JTable table = new JTable(data, new Object[] { "Datum", "Bezeichnung",
				"Betrag" });
			JScrollPane scrollpane = new JScrollPane(table);
			scrollpane.setBorder(BorderFactory.createEmptyBorder());
			table.setPreferredSize(new Dimension(300,500));;
			// Kreisdiagramm
			DefaultPieDataset pd = new DefaultPieDataset();
			for (Posten p : ausgaben) {
				pd.setValue(p.getBezeichnung(), p.getBetrag());
			}
			JFreeChart pie = ChartFactory.createPieChart("Ausgaben", pd);
			ChartPanel piepanel = new ChartPanel(pie);
			piepanel.setPreferredSize(new Dimension(500,500));
	
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblUebersicht, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(696, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(table)
								.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
								.addComponent(piepanel)
								.addGap(20))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(20)
						.addComponent(lblUebersicht)
						.addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(table)
							.addComponent(piepanel))
						.addGap(20))
			);
			contentPane.setLayout(gl_contentPane);
			contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblUebersicht}));
		}
			
			
		

			});
		
		btnEinnahmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Test");
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				JLabel lblUebersicht = new JLabel("Uebersicht ihrer Einnahmen");
				
		        //Modifiziert das Fenster "neue Buchung" und gibt Positionen der Buttons an 
				
				
				ArrayList<Posten> einnahmen = CSVReader("data/einnahmen.csv");
				
				Object[][] data = new Object[einnahmen.size()][3];
				int i = 0;
				for (Posten p : einnahmen) {
					data[i][0] = new SimpleDateFormat("dd/MM/yyyy")
							.format(p.getDatum());
					data[i][1] = p.getBezeichnung();
					data[i][2] = String.format("%.2f", p.getBetrag());
					i++;
				
				}
				
			JTable table = new JTable(data, new Object[] { "Datum", "Bezeichnung","Betrag" });
			JScrollPane scrollpane = new JScrollPane(table);
			scrollpane.setBorder(BorderFactory.createEmptyBorder());
			table.setPreferredSize(new Dimension(300,500));;
			

			// Kreisdiagramm
			DefaultPieDataset pd = new DefaultPieDataset();
			for (Posten p : einnahmen) {
				pd.setValue(p.getBezeichnung(), p.getBetrag());
			}
			JFreeChart pie = ChartFactory.createPieChart("Einnahmen", pd);
			ChartPanel piepanel = new ChartPanel(pie);
			piepanel.setPreferredSize(new Dimension(500,500));

	
			// Elemente dem Fenster hinzufuegen:
			
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblUebersicht, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(696, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(table)
								.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
								.addComponent(piepanel)
								.addGap(20))))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(20)
						.addComponent(lblUebersicht)
						.addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(table)
							.addComponent(piepanel))
						.addGap(20))
			);
			contentPane.setLayout(gl_contentPane);
			contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblUebersicht}));
		}
	
			
		

			});
		
		
		/**
		 * Fuegt dem Button Sparen eine Aktion beim Klicken hinzu
		 */
		btnSparen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sparziel = new Sparziel();
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);

				JLabel lblRestbudget = new JLabel("Uebersicht ihrer Schulden und Sparziele");
				lblRestbudget.setVerticalAlignment(SwingConstants.TOP);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setEnabled(true);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				
				JTable Tabelle = new JTable();
				scrollPane.setViewportView(Tabelle);
				Tabelle.setEditingColumn(0);
				
				String[][] test = Sparziel.readCSV();
				for(int i = 0; i<test.length;i++){
					test[i][5] = Sparziel.erreicht(i).toString();
				}
				

				
				//Tabelle.setEnabled(false);
				Tabelle.setRowSelectionAllowed(true);
				Tabelle.setModel(new DefaultTableModel(
						test,
					new String[] {"Bezeichnung", "Kategorie", "Startdatum", "Zieldatum", "Betrag", "Bereits erreicht"}
				));
				
				for (int c = 0; c < Tabelle.getColumnCount(); c++)
				{
				    Class<?> col_class = Tabelle.getColumnClass(c);
				    Tabelle.setDefaultEditor(col_class, null);        // remove editor
				}
			
				DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
				rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
				Tabelle.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
				Tabelle.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				Tabelle.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
				Tabelle.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
				Tabelle.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
				
				Tabelle.getColumnModel().getColumn(0).setPreferredWidth(80);
				Tabelle.getColumnModel().getColumn(1).setPreferredWidth(60);
				Tabelle.getColumnModel().getColumn(2).setPreferredWidth(60);
				Tabelle.getColumnModel().getColumn(3).setPreferredWidth(60);
				Tabelle.getColumnModel().getColumn(4).setPreferredWidth(50);
				Tabelle.getColumnModel().getColumn(5).setPreferredWidth(50);
				Tabelle.setToolTipText("");
				contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblRestbudget, scrollPane, Tabelle}));
				
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRestbudget, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
							.addContainerGap())
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRestbudget, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(141, Short.MAX_VALUE))
				);
				contentPane.setLayout(gl_contentPane);
			}	
			
		});
		btnStart.doClick();
	}
	
	public static ArrayList<Posten> CSVReader(String filename) {
		ArrayList<Posten> file_as_array = new ArrayList<Posten>(); //Initialisieren der Ausgaben als Array mit Posten
		try {
			// Zeilenweises Einlesen der Daten
			CSVReader reader = new CSVReader(new FileReader(filename));
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				//DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMAN); //Erzeugen eines Parse Objekts
				Date datum = df.parse(nextLine[0]); //Einlesen Datum und Parsing als Datum
				String bezeichnung = nextLine[1]; //Einlesen der Bezeichnung
				double betrag = Double.parseDouble(nextLine[2]); //Einlesen des Betrags
				file_as_array.add(new Posten(datum, bezeichnung, betrag)); //Posten dem Ausgabenarray Hinzufuegen
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Die Datei wurde nicht gefunden!");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Probleme beim Oeffnen der Datei!");
			System.exit(1);
		} catch (ParseException e) {
			System.err.println("Die Datei konnte nicht eingelesen werden!");
			System.exit(1);
		}
	return file_as_array;
	}
	
	public static String funktion (String filename){
		int number_of_rows = 0;
		Date date = java.util.Calendar.getInstance().getTime();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM");
		String dateToday = dateFormatter.format(date);
		try {
	        java.io.BufferedReader FileReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("data/"+filename+".csv")));
	        String zeile="";
	        while(null!=(zeile=FileReader.readLine())){         
	        	number_of_rows++; 
	        }
	        FileReader.close();    
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Groesse des Arrays kann nicht festgelegt werden ");
	    }
		
		String[][] file_as_array = new String[number_of_rows][4];
	    try {
	        java.io.BufferedReader FileReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("data/"+filename+".csv")));
	        String zeile="";
	        while(null!=(zeile=FileReader.readLine())){         
	            String[] split=zeile.split(",");
	            int i = 0;
	            for(int j = 0; j<split.length;j++){
	            	file_as_array[i][j] = split[j];
	            }
	            	i++;  
	        }
	        FileReader.close();
	        double gesamt = 0.0;
	        for (int i = 0; i<file_as_array.length; i++ ){
	        	if (Double.parseDouble(file_as_array[i][0].substring(3,5)) == Double.parseDouble(dateToday)){
	        		gesamt = gesamt + Double.parseDouble(file_as_array[i][2]);
	        	}
	        	System.out.println(gesamt);
	        }
	        return String.valueOf(gesamt);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Daten koennen nicht aufgerufen werden");
	    }
	    return null;
	}
	
	}

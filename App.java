
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class App implements ActionListener{
	
	public static String currInt = "";
	private static boolean checked = false;
	private static boolean inited = false;
	public static String currSta = "";
	public static String currDesti = "";
	public static JFrame mainFrame;
	public static JComboBox lines;
	public static JComboBox empty;
	public static JComboBox empty1;
	public static JComboBox box;
	public static JComboBox box1;
	public static JComboBox box2;
	public static JComboBox box3;
	public static JTextField currLine = new JTextField("");
	public static JTextField field = new JTextField("");
	public static JTextField destination = new JTextField("");
	public static JTextField clock = new JTextField("999");
	public static JTextField stationName = new JTextField("");
	public boolean first = false;
	
	
	public static void mainframe()
	{
		mainFrame = new JFrame("Subway");
		JPanel panel = (JPanel)mainFrame.getContentPane();
		JPanel lower = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton butt = new JButton("Set Station");
		JButton setLine = new JButton("Set Line");
		JButton setDesti = new JButton("Set Destination");
		JLabel here = new JLabel("Current Station");
		JLabel there = new JLabel ("Wake Station");
		JLabel line = new JLabel ("Current Line");
		JLabel currTime = new JLabel("Current Time");
		JLabel currStation = new JLabel("Currently at : ");
		
	    panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setPreferredSize(new Dimension(400,400));
	    butt.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    String[] nothing = {" "};
	    empty = new JComboBox(nothing);
	    empty1 = new JComboBox(nothing);
	    																																																																																																																																		
	    String[] lineNum = {"1", "2","3","4"};
	    lines = new JComboBox(lineNum);
	    
	    String[] list = {"Finch", "North_York", "Sheppard", "York_Mills", "Lawrence","Eglinton", "Davisville","St_Clair", "Summerhill", "Rosedale", "Bloor-Yonge", "Wellesley", "College", "Dundas", "Queen", "King", "Union", "St_Andrew", "Osgoode", "St_Patrick", "Queen's_Park", "Museum", "St_George", "Spadina", "Dupont", "St_Clair_West", "Eglinton_West", "Glencarin", "Lawrence_West", "Yorkdale", "Wilson", "Sheppard_West"};
	    box = new JComboBox(list);
		
	    String[] list1 = {"Kennedy", "Warden", "Victoria_Park", "Main_Street", "Woodbine", "Coxwell", "Greenwood", "Donlands", "Pape", "Chester", "Broadview", "Castle_Frank", "Sherbourne", "Bloor-Yonge", "Bay", "St_George", "Spadina",	"Bathurst",	"Christie",	"Ossington"	, "Dufferin","Lansdowne", "Dundas_West", "Keele", "High_Park",	"Runnymede", "Jane", "Old_Mill",	"Royal_York", "Islington", "Kipling"};
	    box1 = new JComboBox(list1);
	    
	    String[] list2 = {"McCowan", "Scarborough_Centre", "Midland", "Ellesmere", "Lawrence_East", "Kennedy"};
	    box2 = new JComboBox(list2);
	    
	    String[] list3 = {"Don_Mills", "Leslie", "Bessarion", "Bayview", "Sheppard-Yonge"};
	    box3 = new JComboBox(list3);
	   
	    setLine.addActionListener(new ActionListener()
	    		{
	    			@Override
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				String line = (String)lines.getSelectedItem();
	    				updateLine(line);
	    			}
	    		}
	    		
	    		);
	    
	    setDesti.addActionListener(new ActionListener()
	    		{
	    	
	    			@Override
	    			public void actionPerformed(ActionEvent e)
	    			{
	    				String line = (String)empty1.getSelectedItem();
	    				updateDesti(line);
	    			}
	    		});
	    
	    butt.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed (ActionEvent e)
			{
				String station = (String)empty.getSelectedItem();
				updateLabel(station);
			}
		});
	    
	    lines.setEditable(false);
	    lines.setPreferredSize(new Dimension(150,30));
	    currLine.setPreferredSize(new Dimension(150,30));
		field.setEditable(false);
		destination.setEditable(false);
		field.setPreferredSize(new Dimension(150,30));
		destination.setPreferredSize(new Dimension(140,30));
		currStation.setPreferredSize(new Dimension(150,30));
		stationName.setEditable(false);
		currLine.setEditable(false);
		stationName.setPreferredSize(new Dimension(150,30));
		
		lower.add(line);
		lower.add(currLine);
		lower.add(lines);
		lower.add(setLine);
		
		lower.add(here);
		lower.add(field);
		if (currInt.equals("1")) {
			box.setPreferredSize(new Dimension(150,30));
			empty = new JComboBox(list);
			lower.add(empty);
		}
		else if (currInt.equals("2")) {
			box1.setPreferredSize(new Dimension(150,30));
			empty = new JComboBox(list1);
			lower.add(empty);
		}
		else if (currInt.equals("3")) {
			box2.setPreferredSize(new Dimension(150,30));
			empty = new JComboBox(list2);
			lower.add(empty);
		}
		else if (currInt.equals("4")) {
			box3.setPreferredSize(new Dimension(150,30));
			empty = new JComboBox(list3);
			lower.add(empty);
		}
		else {
			empty.setPreferredSize(new Dimension(150,30));
			lower.add(empty);
		}
			lower.add(butt);
		
		lower.add(there);
	    lower.add(destination);
	    if (currInt.equals("1")) {
			box.setPreferredSize(new Dimension(150,30));
			empty1 = new JComboBox(list);
			lower.add(empty1);
	    }
		else if (currInt.equals("2")) {
			box1.setPreferredSize(new Dimension(150,30));
			empty1 = new JComboBox(list1);
			lower.add(empty1);
		}
		else if (currInt.equals("3")) {
			box2.setPreferredSize(new Dimension(150,30));
			empty1 = new JComboBox(list2);
			lower.add(empty1);
		}
		else if (currInt.equals("4")) {
			box3.setPreferredSize(new Dimension(150,30));
			empty1 = new JComboBox(list3);
			lower.add(empty1);
		}
		else {
			empty1.setPreferredSize(new Dimension(150,30));
				
			lower.add(empty1);
		}
			lower.add(setDesti);
	    
	    
	    lower.add(currStation);
	    lower.add(stationName);

	    lower.setBackground(Color.gray);
	    
	    mainFrame.setContentPane(panel);
	    mainFrame.add(lower);
	    mainFrame.setSize(525, 500);
	    mainFrame.setVisible(true);
	    
	    check(currInt, currSta, currDesti);
	}
	
	public static void time( ) throws IOException
	{
		System.out.println("time");
		//clock.setText();
		stationName.setText(ReceiveReq.receiveReq("get" + currInt));
	}
	
	public static void updateLine(String word)
	{
		currLine.setText(word);
		currInt = word;
		mainframe();
		
	}
	public static void updateLabel(String word)
	{
		field.setText(word);
		currSta = word;
	    check(currInt, currSta, currDesti);

	}
	
	public static void updateDesti(String word)
	{
		destination.setText(word);
		currDesti = word;
	    check(currInt, currSta, currDesti);

	}
	
	public static void alert()
	{
		
        JOptionPane.showMessageDialog(null, "Arrival At: " + currDesti, "WAKE UP!!!", JOptionPane.PLAIN_MESSAGE, null); 

	}

	public static void check(String line, String station, String destination)
			{
		System.out.println("asdfasdfasd");
				if (line != "" && station != "" && destination != "" && !checked) 
				{
					checked = true;
					int lineI = Integer.parseInt(line);
					int stationNum = NameToNumberConverter.StringToInt(lineI, station);
					int destiNum = NameToNumberConverter.StringToInt(lineI, destination);
					Main.initialize(lineI,stationNum,destiNum);
					inited = true;

				}
			}
	
	public static void main (String[] args)
	{
		mainframe();
		Thread thread = new Thread() {
			public void run() {
				while (true) {

					System.out.println(inited);
					if (inited == true) {
						try {
							time();
							if (ReceiveReq.receiveReq("get" + currInt).equals(currDesti))
							{
								alert();
								inited = false;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						
				}
			}
		};
		thread.start();
		System.out.println("start");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


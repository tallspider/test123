package android;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class App implements ActionListener{
	
	public static String currInt = "";
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
		
	    panel.setLayout (new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setPreferredSize(new Dimension(400,400));
	    butt.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    String[] nothing = {" "};
	    empty = new JComboBox(nothing);
	    empty1 = new JComboBox(nothing);
	    
	    String[] lineNum = {"1", "2","3","4"};
	    lines = new JComboBox(lineNum);
	    
	    String[] list = {"Finch", "North York", "Sheppard", "York Mills", "Lawrence","Eglinton", "Davisville","St. Clair", "Summerhill", "Rosedale", "Bloor-Yonge", "Wellesley", "College", "Dundas", "Queen", "King", "Union", "St. Andrew", "Osgoode", "St. Patrick", "Queen's Park", "Museum","St. George", "Spadina", "Dupont", "St. Clair West", "Eglinton West", "Glencarin", "Lawrence West", "Yorkdale", "Wilson", "Sheppard West"};
	    box = new JComboBox(list);
		
	    String[] list1 = {"Kennedy", "Warden", "Victoria Park", "Main Street", "Woodbine", "Coxwell", "Greenwood", "Donlands", "Pape", "Chester", "Broadview", "Castle Frank", "Sherbourne", "Bloor-Yonge", "Bay", "St. George", "Spadina",	"Bathurst",	"Christie",	"Ossington"	, "Dufferin","Lansdowne", "Dundas West", "Keele", "High Park",	"Runnymede", "Jane", "Old Mill",	"Royal York", "Islington", "Kipling"};
	    box1 = new JComboBox(list1);
	    
	    String[] list2 = {"McCowan", "Scarborough Centre", "Midland", "Ellesmere", "Lawrence East", "Kennedy"};
	    box2 = new JComboBox(list2);
	    
	    String[] list3 = {"Don Mills", "Leslie", "Bessarion", "Bayview", "Yonge"};
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
	    
	    lower.add(currTime);
	    clock.setPreferredSize(new Dimension(300,30));
	    clock.setEditable(false);
	    lower.add(clock);

	    lower.setBackground(Color.gray);
	    
	    mainFrame.setContentPane(panel);
	    mainFrame.add(lower);
	    mainFrame.setSize(525, 500);
	    mainFrame.setVisible(true);
	}
	
	public static void time( )
	{
		clock.setText();
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
	}
	
	public static void updateDesti(String word)
	{
		destination.setText(word);
		currDesti = word;
	}
	
	public static void arrival()
	{
		
        JOptionPane.showMessageDialog(null, "Arrival At" + currDesti, "WAKE UP!!!", JOptionPane.PLAIN_MESSAGE, null); 

	}

	
	public static void main (String[] args)
	{
		mainframe();	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


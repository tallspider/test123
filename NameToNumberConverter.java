
public class NameToNumberConverter {
	static String[] g1 = {"Sheppard_West", "Wilson", "Yorkdale", "Lawrence_West", "Glencairn", "Eglinton_West", "St_Clair_West", "Dupont", "Spadina", "St_George", "Museum", "Queen's_Park", "St_Patrick", "Osgoode", "St_Andrew", "Union", "King", "Queen", "Dundas", "College", "Wellesley", "Bloor-Yonge", "Rosedale", "Summerhill", "St_Clair", "Davisville", "Eglinton", "Lawrence", "York_Mills", "Sheppard-Yonge", "North_York_Centre", "Finch"};
	static String[] g2 = {"Bathurst", "Bay", "Bloor-Yonge", "Broadview", "Castle Frank", "Chester", "Christie", "Coxwell", "Donlands", "Dufferin", "Dundas West", "Ellesmere", "Greenwood", "High Park", "Islington", "Jane", "Keele", "Kennedy", "Kipling", "Lansdowne", "Lawrence East", "Main Street", "McCowan", "Midland", "Old Mill", "Ossington", "Pape","Royal York", "Runnymede", "Scarborough Centre", "Sherbourne", "Spadina", "St.George", "Victoria Park", "Warden", "Woodbine"};
		public static int StringToInt(int groupnum, String name){
		String[] group ;
		if(groupnum == 1) group = g1;
		else group = g2;
		for(int i = 0; i < group.length; i++){
			if(name.equals(group[i])) return i;
		}
		return -1;
	}
	
	public static String IntToString(int groupnum, int index){
		String[] group;
		if(groupnum == 1) group = g1;
		else group = g2;
		return group[index];
	}
}

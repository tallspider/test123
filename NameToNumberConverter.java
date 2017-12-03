public class NameToNumberConverter {
	static String[] g1 = {"Sheppard_West", "Wilson", "Yorkdale", "Lawrence_West", "Glencairn", "Eglinton_West", "St_Clair_West", "Dupont", "Spadina", "St_George", "Museum", "Queen's_Park", "St_Patrick", "Osgoode", "St_Andrew", "Union", "King", "Queen", "Dundas", "College", "Wellesley", "Bloor-Yonge", "Rosedale", "Summerhill", "St_Clair", "Davisville", "Eglinton", "Lawrence", "York_Mills", "Sheppard-Yonge", "North_York_Centre", "Finch"};
	static String[] g2 = {"Kipling", "Islington", "Royal_York", "Old_Mill", "Jane", "Runnymede", "High_Park", "Keele", "Dundas_West", "Lansdowne", "Dufferin", "Ossington", "Christie", "Bathurst", "Spadina", "St_George", "Bay", "Bloor_Yonge", "Sherbourne","Castle_Frank", "Broadview", "Chester", "Pape", "Donlands", "Greenwood", "Coxwell","Woodbine", "Main_Street", "Victoria_Park", "Warden", "Kennedy"};
	static String[] g3 = {"Kennedy", "Lawrence_East", "Ellesmere", "Midland", "Scarborough_Centre", "McCowan"};
	static String[] g4 = {"Sheppard-Yonge", "Bayview", "Bessarion", "Leslie", "Don_Mills"};
	public static int StringToInt(int groupnum, String name){
		String[] group = null;
		switch(groupnum) {
		case 1:
			group = g1;
			break;
		case 2:
			group = g2;
			break;
		case 3:
			group = g3;
			break;
		case 4:
			group = g4;
			break;
		default:
			break;
		}
		for(int i = 0; i < group.length; i++){
			if(name.equals(group[i])) return i;
		}
		return -1;
	}
	
	public static String IntToString(int groupnum, int index){
		String[] group = null;
		switch(groupnum) {
		case 1:
			group = g1;
			break;
		case 2:
			group = g2;
			break;
		case 3:
			group = g3;
			break;
		case 4:
			group = g4;
			break;
		default:
			break;
		}
		return group[group.length-index];
	}
}
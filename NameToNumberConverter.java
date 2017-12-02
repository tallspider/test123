
public class NameToNumberConverter {
	int convert(int groupnum, String name){
		String[] g1 = {"Bayview", "Bessarion", "Bloor-Yonge", "College", "Daviscille", "Don Mills", "Downsview", "Dundas", "Dupont", "Eglinton", "Eglinton West", "Finch", "Glencairn", "King", "Lawrence", "Lawrence East", "Leslie", "Museum", "North York Centre", "Osgoode", "Queen", "Queen's Park", "Rosedale", "Sheppard-Yonge", "Spadina", "St.Andrew", "St.Clair", "St.Clair West", "St.George", "St.Patrick", "Summerhill", "Union", "Wellesley", "Wilson", "York Mills", "Yorkdale"};
		String[] g2 = {"Bathurst", "Bay", "Bloor-Yonge", "Broadview", "Castle Frank", "Chester", "Christie", "Coxwell", "Donlands", "Dufferin", "Dundas West", "Ellesmere", "Greenwood", "High Park", "Islington", "Jane", "Keele", "Kennedy", "Kipling", "Lansdowne", "Lawrence East", "Main Street", "McCowan", "Midland", "Old Mill", "Ossington", "Pape","Royal York", "Runnymede", "Scarborough Centre", "Sherbourne", "Spadina", "St.George", "Victoria Park", "Warden", "Woodbine"};
		String[] group ;
		if(groupnum == 1) group = g1;
		else group = g2;
		for(int i = 0; i < group.length; i++){
			if(name.equals(group[i])) return i;
		}
		return -1;
	}
}

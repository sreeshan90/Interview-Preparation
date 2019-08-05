package com.sreesha.test;

public class C4CHelper {
	public static void main(String[] args) {
	
		String str = "CVE-2015-3192,CVE-2018-1272,CVE-2018-1270,CVE-2018-1275,CVE-2016-5007-SEC,CVE-2016-4977,CVE-2018-1260,CVE-2018-1271,CVE-2016-9879,CVE-2018-1199,CVE-2014-3625,CVE-2016-5007,CVE-2016-9878,CVE-2018-15758,CVE-2015-5211,CVE-2019-3778";
		
		String[] arr = str.split(",");
		
		for(String s : arr){
			System.out.println(" vulas.report.exceptionExcludeBugs."+s+" = Not exploitable because the vulnerability is transitive and the description of the vulnerability is not applicable and not used in the current application context");
		}
 	}
}

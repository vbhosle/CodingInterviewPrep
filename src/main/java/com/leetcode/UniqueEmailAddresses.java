package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public int numUniqueEmails(String[] emails) {
		if(emails == null || emails.length == 0) return 0;
		
		String localName, domainName;
		String[] emailNames;
		Set<String> emailSet = new HashSet<>();
		
		for (int i = 0; i < emails.length; i++) {
			if(emails[i] != null ) {
				emailNames = emails[i].split("@");
				localName = emailNames[0].replaceAll("\\.", "");
				int indexOfPlus = localName.indexOf('+');
				if(indexOfPlus != -1)
					localName = localName.substring(0, localName.indexOf('+'));
				domainName = emailNames[1];
				emailSet.add(localName + "@" + domainName);
			}
		}
		
		return emailSet.size();
	}
	
}

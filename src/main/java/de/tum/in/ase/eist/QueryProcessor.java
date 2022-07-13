package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        }  else {
            if(query.matches(".*what is [0-9]{1,5} plus [0-9]{1,5}.*")) {
                Pattern p = Pattern.compile("-?\\d+");
                Matcher m = p.matcher(query);
                if(!m.find()) return "";
                String m1 = m.group();
                if(!m.find()) return "";
                String m2 = m.group();

                try {
                    int i1 = Integer.parseInt(m1);
                    int i2 = Integer.parseInt(m2);
                    return String.valueOf(i1 + i2);
                } catch (Exception e) {
                    return "";
                }

            }
            return "";
        }
    }
}

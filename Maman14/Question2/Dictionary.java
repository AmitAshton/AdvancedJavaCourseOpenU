package Question2;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, String> terms;

    public Dictionary() {
        terms = new TreeMap<>();
    }

    public void addTerm(String term, String definition) {
        terms.put(term.toLowerCase(), definition);
    }

    public void removeTerm(String term) {
        terms.remove(term.toLowerCase());
    }

    public void updateTerm(String term, String newDefinition) {
        if (terms.containsKey(term.toLowerCase())) {
            terms.put(term.toLowerCase(), newDefinition);
        }
    }

    public String searchTerm(String term) {
        return terms.get(term.toLowerCase());
    }

    public Map<String, String> getAllTerms() {
        return terms;
    }
}

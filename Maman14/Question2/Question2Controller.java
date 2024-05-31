package Question2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;

public class Question2Controller {

    @FXML
    private TextField termField;

    @FXML
    private TextField definitionField;

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> termList;

    private Dictionary dictionary;

    private ObservableList<String> termsObservableList;

    @FXML
    public void initialize() {
        dictionary = new Dictionary();
        termsObservableList = FXCollections.observableArrayList();
        termList.setItems(termsObservableList);
        updateTermList();
    }

    @FXML
    private void handleAddUpdate() {
        String term = termField.getText().trim();
        String definition = definitionField.getText().trim();
        if (!term.isEmpty() && !definition.isEmpty()) {
            dictionary.addTerm(term, definition);
            updateTermList();
        }
    }

    @FXML
    private void handleDelete() {
        String term = termField.getText().trim();
        if (!term.isEmpty()) {
            dictionary.removeTerm(term);
            updateTermList();
        }
    }

    @FXML
    private void handleSearch() {
        String searchTerm = searchField.getText().trim();
        if (!searchTerm.isEmpty()) {
            String definition = dictionary.searchTerm(searchTerm);
            if (definition != null) {
                termsObservableList.setAll(searchTerm + ": " + definition);
            } else {
                termsObservableList.setAll("Term not found");
            }
        } else {
            updateTermList();
        }
    }

    private void updateTermList() {
        termsObservableList.clear();
        for (Map.Entry<String, String> entry : dictionary.getAllTerms().entrySet()) {
            termsObservableList.add(entry.getKey() + ": " + entry.getValue());
        }
    }
}

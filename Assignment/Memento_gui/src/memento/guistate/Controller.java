package memento.guistate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;

    private List<IMemento> history;      // undo history
    private List<IMemento> redoHistory;  // redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Undo: memento found in history");

            // save current state to redo list
            redoHistory.add(model.createMemento());

            // restore last saved state
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo: memento found in redo history");

            // save current state to undo list
            history.add(model.createMemento());

            // restore last undone state
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);

        // new change clears redo history
        redoHistory.clear();
    }

    public ObservableList<String> getHistoryTexts() {
        ObservableList<String> items = FXCollections.observableArrayList();

        for (IMemento m : history) {
            Memento mm = (Memento) m;
            items.add(mm.getDisplayText());
        }

        return items;
    }

    public void restoreFromHistoryIndex(int index) {
        if (index >= 0 && index < history.size()) {
            // save current state before restoring selected old state
            history.add(model.createMemento());
            redoHistory.clear();

            IMemento chosen = history.get(index);
            model.restoreState(chosen);
            gui.updateGui();
        }
    }
}
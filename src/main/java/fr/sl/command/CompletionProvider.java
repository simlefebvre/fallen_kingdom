package fr.sl.command;

import java.util.List;

public interface CompletionProvider {
    List<String> getPossibilities();
}

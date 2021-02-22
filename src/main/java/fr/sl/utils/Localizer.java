package fr.sl.utils;

import fr.sl.main.MainClass;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class Localizer {
    private final static String BUNDLE = "localization.dictionary";
    private static final Localizer instance = new Localizer();
    private final Locale locale;

    private Localizer() {
        locale = Locale.getDefault();
    }

    public String getLocalizedText(String key) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE, locale, this.getClass().getClassLoader());

            if (bundle.keySet().contains(key)) {
                return bundle.getString(key);
            } else {
                return key;
            }
        } catch (Exception e) {
            MainClass.LOGGER.log(Level.WARNING, String.format("Error while loading localisation for key %s stacktrace : %s", key, Arrays.toString(e.getStackTrace())));
            return key;
        }
    }

    public static Localizer getInstance() {
        return instance;
    }
}

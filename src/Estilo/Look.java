package Estilo;

import javax.swing.AbstractButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class Look {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 14);
    private static final Color DEFAULT_FOREGROUND_COLOR = Color.BLACK;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;
    private static final Color DEFAULT_BUTTON_TEXT_COLOR = Color.WHITE;

    public static void setUIFontLuismi() {
        setUIFontLuismi(new Font("Arial", Font.PLAIN, 14));
    }

    public static void setUIFontLuismi(Font fontLuismi) {
        UIManager.put("OptionPane.messageFont", fontLuismi);
        UIManager.put("OptionPane.buttonFont", fontLuismi);
    }

    public static void setButtonStylesLuismi(AbstractButton... buttonsLuismi) {
        setButtonStylesLuismi(DEFAULT_FOREGROUND_COLOR, DEFAULT_BACKGROUND_COLOR, buttonsLuismi);
    }

    public static void setButtonStylesLuismi(Color foregroundLuismi, Color backgroundLuismi, AbstractButton... buttonsLuismi) {
        for (AbstractButton button : buttonsLuismi) {
            button.setFont(DEFAULT_FONT);
            button.setForeground(foregroundLuismi);
            button.setBackground(backgroundLuismi);
            button.setOpaque(true);
        }
    }

    public static void setButtonTextToWhite(AbstractButton... buttonsLuismi) {
        for (AbstractButton button : buttonsLuismi) {
            button.setForeground(DEFAULT_BUTTON_TEXT_COLOR);
        }
    }

    private static void setComponentStyles(String[] componentsLuismi, Color foregroundLuismi, Color backgroundLuismi) {
        for (String component : componentsLuismi) {
            UIManager.put(component + ".font", DEFAULT_FONT);
            UIManager.put(component + ".foreground", foregroundLuismi);
            UIManager.put(component + ".background", backgroundLuismi);
        }
    }
}

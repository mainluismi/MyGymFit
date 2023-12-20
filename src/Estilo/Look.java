/**
 * La clase `Look` proporciona métodos para personalizar el aspecto visual de componentes Swing,
 * como fuentes, colores de fondo y texto de botones, entre otros.
 *
 * @author Luismi
 * @version 1.8
 * @since 20/12/23
 */
package Estilo;

import javax.swing.AbstractButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class Look {

    /**
     * La fuente predeterminada para los componentes.
     */
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 14);

    /**
     * El color predeterminado del texto.
     */
    private static final Color DEFAULT_FOREGROUND_COLOR = Color.BLACK;

    /**
     * El color predeterminado de fondo.
     */
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;

    /**
     * El color predeterminado del texto de los botones.
     */
    private static final Color DEFAULT_BUTTON_TEXT_COLOR = Color.WHITE;

    /**
     * Establece la fuente predeterminada para los componentes.
     */
    public static void setUIFontLuismi() {
        setUIFontLuismi(new Font("Arial", Font.PLAIN, 14));
    }

    /**
     * Establece la fuente para los componentes.
     *
     * @param fontLuismi La fuente a establecer.
     */
    public static void setUIFontLuismi(Font fontLuismi) {
        UIManager.put("OptionPane.messageFont", fontLuismi);
        UIManager.put("OptionPane.buttonFont", fontLuismi);
    }

    /**
     * Establece los estilos predeterminados para los botones.
     *
     * @param buttonsLuismi Los botones a los que se les aplicarán los estilos.
     */
    public static void setButtonStylesLuismi(AbstractButton... buttonsLuismi) {
        setButtonStylesLuismi(DEFAULT_FOREGROUND_COLOR, DEFAULT_BACKGROUND_COLOR, buttonsLuismi);
    }

    /**
     * Establece los estilos para los botones.
     *
     * @param foregroundLuismi El color del texto.
     * @param backgroundLuismi El color de fondo.
     * @param buttonsLuismi Los botones a los que se les aplicarán los estilos.
     */
    public static void setButtonStylesLuismi(Color foregroundLuismi, Color backgroundLuismi, AbstractButton... buttonsLuismi) {
        for (AbstractButton button : buttonsLuismi) {
            button.setFont(DEFAULT_FONT);
            button.setForeground(foregroundLuismi);
            button.setBackground(backgroundLuismi);
            button.setOpaque(true);
        }
    }

    /**
     * Establece el color del texto de los botones a blanco.
     *
     * @param buttonsLuismi Los botones a los que se les cambiará el color del texto.
     */
    public static void setButtonTextToWhite(AbstractButton... buttonsLuismi) {
        for (AbstractButton button : buttonsLuismi) {
            button.setForeground(DEFAULT_BUTTON_TEXT_COLOR);
        }
    }

    /**
     * Establece los estilos para componentes específicos.
     *
     * @param componentsLuismi Los nombres de los componentes a los que se les aplicarán los estilos.
     * @param foregroundLuismi El color del texto.
     * @param backgroundLuismi El color de fondo.
     */
    private static void setComponentStyles(String[] componentsLuismi, Color foregroundLuismi, Color backgroundLuismi) {
        for (String component : componentsLuismi) {
            UIManager.put(component + ".font", DEFAULT_FONT);
            UIManager.put(component + ".foreground", foregroundLuismi);
            UIManager.put(component + ".background", backgroundLuismi);
        }
    }
}

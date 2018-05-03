 
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
 
public class insertImage extends JPanel {
    /**
         * 
         */
    private static final long serialVersionUID = 1L;
    JPanel panelCentre = new JPanel();
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel("KABOOM !");
 
    public insertImage() {
        try {
            panelCentre.setLayout(new BorderLayout());
            panelCentre.add(headerLabel, BorderLayout.NORTH);
            ImageIcon ii = new ImageIcon(this.getClass().getResource("sprite_explosion.gif"));
            imageLabel.setIcon(ii);
            imageLabel.setBounds(20,20,ii.getIconWidth(),ii.getIconHeight());
            panelCentre.setBackground(Color.magenta);
            panelCentre.add(imageLabel,BorderLayout.CENTER);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    // Screen Settings
    final int originalTileSize = 16; // 16x16 tile (character size)
    final int scale = 3; // scale for higher screen resolution
    final int tileSize = originalTileSize * scale;
    // 4:3 ratio
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    // 768x576 reso (change both resolution and ratio later when finalizing
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
}

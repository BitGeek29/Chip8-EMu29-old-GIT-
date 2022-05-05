package emu;

import chip.Chip;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


public class ChipPanel extends JPanel {

    private Chip chip;

    private static final long serialVersionUID = 1L;

    ChipPanel(Chip chip) {
        this.chip = chip;
    }

    public void paint(Graphics g) {
       byte[] display = chip.getDisplay();
       for (int i = 0; i < display.length; i++) {
           if(display[i] == 0)
               g.setColor(Color.BLACK);
           else
               g.setColor(Color.WHITE);

           int x = (i % 64);
           int y = (int)Math.floor(i / 64);

           g.fillRect(x * 10, y * 10, 10,10);
       }
    }
}

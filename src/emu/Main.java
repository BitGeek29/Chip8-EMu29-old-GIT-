package emu;

import chip.Chip;

public class Main extends Thread{

    private  Chip chip8;
    private ChipFrame frame;

    public Main() {
        chip8 = new Chip();
        chip8.init();
        chip8.loadProgress("C:\\Users\\HASEEB\\IdeaProjects\\Chip_8_emulator29\\src\\pong2.c8");
        frame = new ChipFrame(chip8);
    }
    public void run() {
        while (true) {
            chip8.setKeyBuffer(frame.getKeyBuffer());
            chip8.run();
            if(chip8.needRedraw()) {
                frame.repaint();
                chip8.removeDrawFlag();
            }
            try {
                Thread.sleep(64);
            } catch (InterruptedException e) {

            }

        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}

package bowlingScorer;
import java.util.ArrayList;

class Player {
    private String name;
    private ArrayList<Frame> frames;

    public Player(String name) {
        this.name = name;
        frames = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }
    
    private int getNextTwoThrows(int frameIndex) {
        if (frameIndex >= 9) return 0;
        Frame nextFrame = frames.get(frameIndex + 1);
        int bonus = nextFrame.getThrow1();
        if (nextFrame.isStrike() && frameIndex < 8) {
            bonus += frames.get(frameIndex + 2).getThrow1();
        } else {
            bonus += nextFrame.getThrow2();
        }
        return bonus;
    }

    private int getNextThrow(int frameIndex) {
        return frames.get(frameIndex).getThrow1();
    }

    public int calculateTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < 10; i++) {
            Frame currentFrame = frames.get(i);
            int frameScore = currentFrame.getFrameScore();
            if (currentFrame.isStrike()) {
                if (i < 9) {
                    frameScore += getNextTwoThrows(i);
                }
            } else if (currentFrame.isSpare()) {
                if (i < 9) {
                    frameScore += getNextThrow(i + 1);
                }
            }
            totalScore += frameScore;
        }
        return totalScore;
    }
}

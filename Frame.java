package bowlingScorer;

class Frame {
    private int throw1;
    private int throw2;
    private int throw3;
    private boolean strike;
    private boolean spare;

    public Frame() {
        throw1 = 0;
        throw2 = 0;
        throw3 = 0;
        strike = false;
        spare = false;
    }

    public void setThrows(int t1, int t2) {
        this.throw1 = t1;
        this.throw2 = t2;
        this.strike = (t1 == 10);
        this.spare = (!strike && t1 + t2 == 10);
    }

    public int getThrow1() {
        return throw1;
    }

    public int getThrow2() {
        return throw2;
    }
    
    public void setThirdThrow(int t3) {
        this.throw3 = t3;
    }

    public int getThrow3() {
        return throw3;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public int getFrameScore() {
        return throw1 + throw2 + throw3;
    }
}


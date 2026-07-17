package me.JOTTA.SourceFUN.quests;

public class MissionProgress {

    private int current;
    private boolean completed;
    private boolean rewardClaimed;

    public MissionProgress() {
        this(0, false, false);
    }

    public MissionProgress(int current, boolean completed, boolean rewardClaimed) {
        this.current = current;
        this.completed = completed;
        this.rewardClaimed = rewardClaimed;
    }

    /** Adiciona progresso e marca como completa se atingir o necessário. Retorna true se acabou de completar agora. */
    public boolean addProgress(int amount, int required) {
        if (completed) return false;
        current = Math.min(current + amount, required);
        if (current >= required) {
            completed = true;
            return true;
        }
        return false;
    }

    public int getCurrent() { return current; }
    public boolean isCompleted() { return completed; }
    public boolean isRewardClaimed() { return rewardClaimed; }
    public void setRewardClaimed(boolean rewardClaimed) { this.rewardClaimed = rewardClaimed; }
}
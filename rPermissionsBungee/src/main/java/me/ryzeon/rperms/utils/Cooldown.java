package me.ryzeon.rperms.utils;

import lombok.Getter;

import java.util.UUID;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 16/01/2021 @ 03:47 p. m.
 */

@Getter
public class Cooldown {

    private UUID uniqueId;

    private long start;

    private long expire;

    private boolean notified;

    public Cooldown(int time) {
        long duration = (1000 * time);
        this.uniqueId = UUID.randomUUID();
        this.start = System.currentTimeMillis();
        this.expire = this.start + duration;
        if (duration == 0L) {
            this.notified = true;
        }
    }

    public long getPassed() {
        return System.currentTimeMillis() - this.start;
    }

    public long getRemaining() {
        return this.expire - System.currentTimeMillis();
    }

    public boolean hasExpired() {
        return (System.currentTimeMillis() - this.expire >= 0L);
    }

    public String getTimeLeft() {
        if (getRemaining() >= 60000L) {
            return rUtils.millisToRoundedTime(getRemaining());
        }

        return rUtils.millisToSeconds(getRemaining());
    }

    public String getTimeMilisLeft() {
        return rUtils.millisToSeconds(getRemaining());
    }

    public String getContextLeft() {
        return "second" + ((getRemaining() / 1000L > 1L) ? "s" : "");
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cooldown)) {
            return false;
        }

        Cooldown other = (Cooldown) o;
        if (!other.canEqual(this)) {
            return false;
        }

        Object this$uniqueId = getUniqueId();
        Object other$uniqueId = other.getUniqueId();
        if (this$uniqueId == null) {
            if (other$uniqueId == null) {
                return (getStart() == other.getStart() && getExpire() == other.getExpire() && isNotified() == other.isNotified());
            }
        } else if (this$uniqueId.equals(other$uniqueId)) {
            return (getStart() == other.getStart() && getExpire() == other.getExpire() && isNotified() == other.isNotified());
        }

        return false;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Cooldown;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $uniqueId = getUniqueId();
        result = result * 59 + (($uniqueId == null) ? 43 : $uniqueId.hashCode());
        long $start = getStart();
        result = result * 59 + (int) ($start >>> 32L ^ $start);
        long $expire = getExpire();
        result = result * 59 + (int) ($expire >>> 32L ^ $expire);
        result = result * 59 + (isNotified() ? 79 : 97);

        return result;
    }

    public String toString() {
        return "Cooldown(uniqueId=" + getUniqueId() + ", start=" + getStart() + ", expire=" + getExpire() + ", notified=" + isNotified() + ")";
    }
}
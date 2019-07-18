package com.neeson.thread.geek;

import java.util.concurrent.*;

/**
 * @author : neeson
 * Date: 2019/7/18
 * Time: 22:32
 * Description: 
 */
public class AutoSaveEditor {

	boolean changed = false;

	ScheduledExecutorService sec = Executors.newSingleThreadScheduledExecutor();

	void startAutoSave() {
		sec.scheduleWithFixedDelay(() -> {
			autoSave();
		}, 5, 5, TimeUnit.SECONDS);
	}

	private void autoSave() {
		synchronized (this) {
			if (!changed) {
				return;
			}
			changed = false;
		}
		this.execSave();
	}

	void edit() {
		change();
	}

	void change() {
		synchronized (this) {
			changed = true;
		}
	}

	private void execSave() {
	}

}

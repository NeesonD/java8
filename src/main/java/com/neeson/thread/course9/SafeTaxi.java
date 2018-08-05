package com.neeson.Thread.course9;

import com.neeson.Thread.course3.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by daile on 2017/9/11.
 * 通过公开调用来避免在相互协作的对象之间产生死锁
 */
public class SafeTaxi {

    private Point location,destination;
    private final SafeDispatcher safeDispatcher;

    public SafeTaxi(SafeDispatcher safeDispatcher) {
        this.safeDispatcher = safeDispatcher;
    }

    public synchronized Point getLocation(){
        return location;
    }

    public void setLocation(Point location){
        boolean reachedDestination;
        synchronized (this){
            this.location = location;
            reachedDestination = location.equals(destination);
        }
        if (reachedDestination){
            safeDispatcher.notifyAvailable(this);
        }
    }

    class SafeDispatcher {
        private final Set<SafeTaxi> taxis;
        private final Set<SafeTaxi> availableTaxis;


        public SafeDispatcher() {
            this.taxis = new HashSet<>();
            this.availableTaxis = new HashSet<>();
        }

        public synchronized void notifyAvailable(SafeTaxi taxi){
            availableTaxis.add(taxi);
        }

        public Image getImaget(){
            Set<SafeTaxi> copy;
            synchronized (this){
                copy = new HashSet<>(taxis);
            }
            Image image = new Image();
            for (SafeTaxi t:copy)
                image.drawMarker(t.getLocation());
            return image;
        }
    }

}
